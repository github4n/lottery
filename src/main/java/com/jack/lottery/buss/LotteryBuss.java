package com.jack.lottery.buss;

import com.jack.lottery.enums.LotteryType;
import com.jack.lottery.utils.exception.BaseException;
import com.jack.lottery.utils.exception.ParamException;
import com.jack.lottery.utils.exception.SystermException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class LotteryBuss {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 验证投注内容
     * type=1 双色球   fs-06,07,11,14,30,31|10（1注） fs-01,10,12,17,23,32|05,11（2注） fs-02,10,12,14,22,25,27|15（7注）
     * type=2 大乐透   fs-12,17,20,21,29|01,05（普通投注1注） fs-19,23,28,29,33|02,05,09（普通投注3注） fs-04,12,17,22,30,34|01,12（普通投注6注）
     * type=3 排列三   fs-3,8,3（直选1注） zs_bh-8,4（组三包号2注） zl_bh-6,2,8（组六包号1注） zl_bh-4,5,7^zs_bh-4,2^fs-9,5,1（4注）
     * type=4 排列五   fs-9,8,2,5,0（单式投注）
     * type=5 福彩3D   fs-3,8,3（直选1注） zs_bh-8,4（组三包号2注） zl_bh-6,2,8（组六包号1注） zl_bh-4,5,7^zs_bh-4,2^fs-9,5,1（4注）
     */
    public void checkContent(String type, String content, int num, BigDecimal amt, int muti) throws BaseException {
        LotteryType lotteryType = LotteryType.getTypeByCode(type);
        if (StringUtils.isBlank(content)) {
            throw new ParamException("投注格式不正确");
        }
        if (0 >= num) {
            throw new ParamException("总注数不正确");
        }
        if (BigDecimal.valueOf(2).compareTo(amt) > 0) {
            throw new ParamException("金额不正确");
        }
        if (0 >= muti) {
            muti = 1;
        }
        if (BigDecimal.valueOf(2).multiply(BigDecimal.valueOf(num))
                .multiply(BigDecimal.valueOf(muti)).compareTo(amt) != 0) {
            throw new ParamException("总注数和金额不匹配");
        }
        switch (lotteryType) {
            case SSQ:
                checkSSQ(content, num);
                break;
            case DLT:
                checkDLT(content, num);
                break;
            case PLS:
                checkPLS(content, num);
                break;
            case PLW:
                checkPLW(content, num);
                break;
            case SD:
                checkSD(content, num);
                break;
        }
    }

    //6个红球最大33，最小01，1个蓝球最大16，最小01
    //fs-06,07,11,14,30,31|10^fs-01,10,12,17,23,32|05,11
    private void checkSSQ(String content, int num) throws ParamException, SystermException {
        int allNum = 0;
        String[] orders = content.split("\\^");
        for (String order : orders) {
            String type = order.split("-")[0];
            if (!"fs".equals(type)) {
                throw new ParamException("投注格式不正确");
            }
            String oneOrder = order.split("-")[1];
            String[] contents = oneOrder.split("\\|");
            if (contents.length != 2) {
                throw new ParamException("投注格式不正确");
            }
            String red = contents[0];
            String blue = contents[1];
            if (StringUtils.isBlank(red) || StringUtils.isBlank(blue)) {
                throw new ParamException("投注格式不正确");
            }
            String[] reds = red.split(",");
            for (String r : reds) {
                if (!StringUtils.isNumeric(r) || r.compareTo("34") >= 0 || r.compareTo("00") <= 0) {
                    throw new ParamException("投注格式不正确");
                }
            }
            String[] blues = blue.split(",");
            for (String b : blues) {
                if (!StringUtils.isNumeric(b) || b.compareTo("17") >= 0 || b.compareTo("00") <= 0) {
                    throw new ParamException("投注格式不正确");
                }
            }
            allNum = allNum + (getNFromM(6, reds.length) * getNFromM(1, blues.length));
        }
        if (num != allNum) {
            throw new ParamException("投注总注数不正确");
        }
    }

    //总共三个数，每个数字都是从0到9
    //zl_bh-4,5,7^zs_bh-4,2^fs-9,5,1
    private void checkSD(String content, int num) throws BaseException {
        checkPLS(content, num);
    }

    //总共五个数，每个数字都是从0到9
    //fs-9,8,2,5,0^fs-8,9,2,5,1
    private void checkPLW(String content, int num) throws ParamException {
        int allNum = 0;
        String[] orders = content.split("\\^");
        for (String order : orders) {
            String type = order.split("-")[0];
            if (!"fs".equals(type)) {
                throw new ParamException("投注格式不正确");
            }
            String oneOrder = order.split("-")[1];
            allNum = allNum + checkPL(oneOrder, 5);
        }
        if (allNum != num) {
            throw new ParamException("投注总注数不正确");
        }
    }

    //总共三个数，每个数字都是从0到9
    //zl_bh-4,5,7^zs_bh-4,2^fs-9,5,1
    private void checkPLS(String content, int num) throws BaseException {
        int allNum = 0;
        String[] orders = content.split("\\^");
        for (String order : orders) {
            String type = order.split("-")[0];
            String contents = order.split("-")[1];
            if ("zl_bh".equals(type)) {
                allNum = allNum + checkZLBH(contents);
            } else if ("zs_bh".equals(type)) {
                allNum = allNum + checkZSBH(contents);
            } else if ("fs".equals(type)) {
                allNum = allNum + checkPL(contents, 3);
            } else {
                throw new ParamException("投注格式不正确");
            }
        }
        if (allNum != num) {
            throw new ParamException("投注总注数不正确");
        }
    }

    private int checkZSBH(String content) throws BaseException {
        String[] contents = content.split(",");
        if (contents.length < 2) {
            throw new ParamException("投注格式不正确");
        }
        for (String s : contents) {
            if (StringUtils.isBlank(s) || !StringUtils.isNumeric(s) || !isBetween(s, "0", "9")) {
                throw new ParamException("投注格式不正确");
            }
        }
        return contents.length * (contents.length - 1);
    }

    private int checkZLBH(String content) throws BaseException {
        String[] contents = content.split(",");
        if (contents.length < 3) {
            throw new ParamException("投注格式不正确");
        }
        for (String s : contents) {
            if (StringUtils.isBlank(s) || !StringUtils.isNumeric(s) || !isBetween(s, "0", "9")) {
                throw new ParamException("投注格式不正确");
            }
        }
        return getNFromM(3, contents.length);
    }

    private int checkPL(String content, int length) throws ParamException {
        String[] contents = content.split(",");
        if (contents.length != length) {
            throw new ParamException("投注格式不正确");
        }
        int totalNum = 1;
        for (int i=0; i<contents.length; i++) {
            String part = contents[i];
            if (StringUtils.isBlank(part)) {
                throw new ParamException("投注格式不正确");
            }
            String[] parts = part.split("");
            totalNum = totalNum * parts.length;
            for (String s : parts) {
                if (StringUtils.isBlank(s) || !StringUtils.isNumeric(s) || !isBetween(s, "0", "9")) {
                    throw new ParamException("投注格式不正确");
                }
            }
        }
        return totalNum;
    }

    //5个红球最大35，最小01，2个篮球最大12，最小01
    //fs-12,17,20,21,29|01,05^fs-19,23,28,29,33|02,05,09
    private void checkDLT(String content, int num) throws ParamException, SystermException {
        int allNum = 0;
        String[] orders = content.split("\\^");
        for (String order : orders) {
            String type = order.split("-")[0];
            if (!"fs".equals(type)) {
                throw new ParamException("投注格式不正确");
            }
            String oneOrder = order.split("-")[1];
            String[] contents = oneOrder.split("\\|");
            if (contents.length != 2) {
                throw new ParamException("投注格式不正确");
            }
            String red = contents[0];
            String blue = contents[1];
            if (StringUtils.isBlank(red) || StringUtils.isBlank(blue)) {
                throw new ParamException("投注格式不正确");
            }
            String[] reds = red.split(",");
            for (String r : reds) {
                if (!StringUtils.isNumeric(r) || r.compareTo("36") >= 0 || r.compareTo("00") <= 0) {
                    throw new ParamException("投注格式不正确");
                }
            }
            String[] blues = blue.split(",");
            for (String b : blues) {
                if (!StringUtils.isNumeric(b) || b.compareTo("13") >= 0 || b.compareTo("00") <= 0) {
                    throw new ParamException("投注格式不正确");
                }
            }
            allNum = allNum + (getNFromM(5, reds.length) * getNFromM(2, blues.length));
        }
        if (num != allNum) {
            throw new ParamException("投注总注数不正确");
        }
    }


    //从M个数字中筛选N个数字算法
    private int getNFromM(int n, int m) throws SystermException {
        if (n <= 0 || m <= 0) {
            return 0;
        }
        int totalA = 1;
        for (int i=0; i<n; i++) {
            totalA = totalA * (m-i);
        }
        int totalB = 1;
        for (int i=0; i<n; i++) {
            totalB = totalB * (n-i);
        }
        if (totalA % totalB != 0) {
            throw new SystermException("金额计算错误");
        }
        return totalA/totalB;
    }

    private boolean isBetween(String n, String max, String min) {
        int maxInt = Integer.parseInt(max);
        int minInt = Integer.parseInt(min);
        int nInt = Integer.parseInt(n);
        return nInt >= minInt && nInt <= maxInt;
    }
}
