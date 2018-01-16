package com.jack.lottery.controller;

import com.jack.lottery.entity.LotteryTerm;
import com.jack.lottery.service.LotteryService;
import com.jack.lottery.utils.exception.Exception2ResponseUtils;
import com.jack.lottery.vo.CommonResponose;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lottery")
public class LotteryController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LotteryService lotteryService;

    /**
     * 根据彩票类型获得当前期
     * @see com.jack.lottery.enums.LotteryType
     * @param type 产品类型
     * */
    @RequestMapping("/getCurrentTerm")
    public CommonResponose<LotteryTerm> getCurrentTerm(int type) {
        try {
            LotteryTerm currentTerm = lotteryService.getCurrentTerm(type);
            return new CommonResponose<>(currentTerm);
        } catch (Exception e) {
            logger.error("查询当前期异常,查询类型,type:{}", type, e);
            return Exception2ResponseUtils.getResponse(e);
        }
    }
}
