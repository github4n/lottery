package com.jack.lottery.buss.pls;

import com.alibaba.fastjson.JSONObject;
import com.jack.lottery.enums.LotteryType;
import com.jack.lottery.enums.WEBSITE;
import com.jack.lottery.service.LotteryService;
import com.jack.lottery.utils.URLConnectionUtil;
import com.jack.lottery.vo.LotteryHistory;
import com.jack.lottery.vo.PrizeDetail;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class PLSFetchHistory {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${task.fetch.history.pls.urls}")
    private String plsUrls;

    @Autowired
    private LotteryService lotteryService;

    public boolean fetchPLSHistory(String termNo) {
        String result = getPLSHistory(termNo).getResult();
        if (StringUtils.isBlank(result)) {
            return false;
        }
        lotteryService.updateTermByTermNo(LotteryType.PLS, termNo, result);
        return true;
    }

    public LotteryHistory getPLSHistory(String termNo) {
        LotteryHistory history = new LotteryHistory();
        history.setType(String.valueOf(LotteryType.PLS.getCode()));
        history.setTermNo(termNo);
        String[] urls = plsUrls.split(";");
        for (String url : urls) {
            String[] split = url.split("\\|");
            String type = split[0];//网站标识
            String realUrl = split[1];//网站地址
            if (type.equals(WEBSITE.OK.getCode())) {
                String resp = URLConnectionUtil.doGet(realUrl, "?LotteryNo=" + termNo.substring(2) + "&Type=lotteryresult");
                if (StringUtils.isBlank(resp)) {
                    logger.info("从澳客抓取排列三历史数据出错");
                    continue;
                }
                JSONObject respJson = JSONObject.parseObject(resp);
                String result = respJson.getString("LotteryResult").replace(";", ",");
                history.setResult(result);
                history.setOpenDate(respJson.getDate("date"));
                history.setDetails(createPLSPrizeDetailFromOK(respJson.getJSONObject("PrizeList")));
                return history;
            } else if (type.equals(WEBSITE.FIVEBILLION.getCode())){
                realUrl = realUrl.replace("{}", termNo.substring(2));
                Document document = null;
                try {
                    document = Jsoup.connect(realUrl).get();
                } catch (IOException e) {
                    logger.info("从500W抓取排列三历史数据出错");
                    continue;
                }
                history.setResult(getPLSResultFrom500W(document));
                history.setOpenDate(getPLSDateFrom500W(document));
                history.setDetails(getPLSPrizeDetailFrom500W(document));
            }
        }
        return history;
    }

    //{"LotteryResult":"5;0;6","PrizeList":{"1":{"LotteryType":"P3","LotteryNo":"18024","PrizeLevel":"1","Prize":"1040","HitNum":"3653"},"3":{"LotteryType":"P3","LotteryNo":"18024","PrizeLevel":"3","Prize":"173","HitNum":"6860"}},"Sale":"16014884","PoolPrize":"-1","riqi":["01","24","\u661f\u671f\u4e09"],"date":"2018-01-24"}
    //{"LotteryResult":"6;5;6","PrizeList":{"1":{"LotteryType":"P3","LotteryNo":"18022","PrizeLevel":"1","Prize":"1040","HitNum":"9151"},"2":{"LotteryType":"P3","LotteryNo":"18022","PrizeLevel":"2","Prize":"346","HitNum":"13460"}},"Sale":"17114890","PoolPrize":"-1","riqi":["01","22","\u661f\u671f\u4e00"],"date":"2018-01-22"}
    private List<PrizeDetail> createPLSPrizeDetailFromOK(JSONObject json) {
        List<PrizeDetail> detailList = new ArrayList<>();
        for (int i=1; i<4; i++) {
            PrizeDetail prize = new PrizeDetail();
            JSONObject jsonObject = json.getJSONObject(String.valueOf(i));
            if (null == jsonObject) {
                prize.setAmount(BigDecimal.ZERO);
                prize.setNum(0);
            } else {
                prize.setAmount(jsonObject.getBigDecimal("Prize"));
                prize.setNum(jsonObject.getIntValue("HitNum"));
            }
            prize.setName(String.valueOf(i));
            detailList.add(prize);
        }
        return detailList;
    }

    private String getPLSResultFrom500W(Document document) {
        Elements iSelectList1 = document.getElementsByClass("ball_box01");
        Elements lis = iSelectList1.select("li");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Element li : lis) {
            sb.append(li.text());
            if (i == 2) {

            } else {
                sb.append(",");
            }
            i++;
        }
        return sb.toString();
    }

    private List<PrizeDetail> getPLSPrizeDetailFrom500W(Document document) {
        List<PrizeDetail> detailList = new ArrayList<>();
        Elements trs = document.getElementsByClass("kj_tablelist02").get(1).getElementsByTag("tr");

        PrizeDetail prize1 = new PrizeDetail();
        Elements tds1 = trs.get(2).getElementsByTag("td");
        prize1.setAmount(BigDecimal.valueOf(Double.parseDouble(tds1.get(2).text().replace(",", ""))));
        prize1.setName(String.valueOf(1));
        prize1.setNum(Integer.parseInt(tds1.get(1).text()));
        detailList.add(prize1);


        Elements tds2 = trs.get(3).getElementsByTag("td");
        if (tds2.get(0).text().equals("排列三组三") || tds2.get(0).text().equals("排列三组六")) {
            PrizeDetail prize2 = new PrizeDetail();
            if (tds2.get(0).text().equals("排列三组三")) {
                prize2.setName(String.valueOf(2));
            } else {
                prize2.setName(String.valueOf(3));
            }
            if (tds2.get(2).text().contains("--") || tds2.get(1).text().contains("--")) {
                prize2.setAmount(BigDecimal.ZERO);
                prize2.setNum(0);
            } else {
                prize2.setAmount(BigDecimal.valueOf(Double.parseDouble(tds2.get(2).text().replace(",", ""))));
                prize2.setNum(Integer.parseInt(tds2.get(1).text()));
            }
            detailList.add(prize2);
        }

        return detailList;
    }

    private Date getPLSDateFrom500W(Document document) {
        Elements span_right = document.getElementsByClass("span_right");
        String endTime = span_right.text();
        String year = endTime.split("兑奖截止日期")[0].split("年")[0].split("：")[1].trim();
        String month = endTime.split("兑奖截止日期")[0].split("年")[1].split("月")[0].trim();
        String day = endTime.split("兑奖截止日期")[0].split("年")[1].split("月")[1].split("日")[0].trim();
        String date = year + "-"+ month + "-"+day;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d = sdf.parse(date);
            return d;
        } catch (ParseException e) {
            logger.error("日期格式转换失败");
            return null;
        }
    }
}
