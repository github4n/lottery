package com.jack.lottery.mapper;

import com.jack.lottery.entity.LotteryOrder;
import com.jack.lottery.entity.LotteryOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LotteryOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lottery_order
     *
     * @mbggenerated
     */
    int countByExample(LotteryOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lottery_order
     *
     * @mbggenerated
     */
    int deleteByExample(LotteryOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lottery_order
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lottery_order
     *
     * @mbggenerated
     */
    int insert(LotteryOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lottery_order
     *
     * @mbggenerated
     */
    int insertSelective(LotteryOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lottery_order
     *
     * @mbggenerated
     */
    List<LotteryOrder> selectByExample(LotteryOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lottery_order
     *
     * @mbggenerated
     */
    LotteryOrder selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lottery_order
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") LotteryOrder record, @Param("example") LotteryOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lottery_order
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") LotteryOrder record, @Param("example") LotteryOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lottery_order
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(LotteryOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lottery_order
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(LotteryOrder record);
}