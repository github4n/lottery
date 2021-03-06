package com.jack.lottery.entity;

import java.util.Date;

public class LotteryTerm {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lottery_term.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lottery_term.type
     *
     * @mbggenerated
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lottery_term.term
     *
     * @mbggenerated
     */
    private String term;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lottery_term.startTime
     *
     * @mbggenerated
     */
    private Date starttime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lottery_term.endTime
     *
     * @mbggenerated
     */
    private Date endtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lottery_term.isCurrent
     *
     * @mbggenerated
     */
    private Byte iscurrent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lottery_term.status
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lottery_term.result
     *
     * @mbggenerated
     */
    private String result;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lottery_term.prize_detail
     *
     * @mbggenerated
     */
    private String prizeDetail;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lottery_term.id
     *
     * @return the value of lottery_term.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lottery_term.id
     *
     * @param id the value for lottery_term.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lottery_term.type
     *
     * @return the value of lottery_term.type
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lottery_term.type
     *
     * @param type the value for lottery_term.type
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lottery_term.term
     *
     * @return the value of lottery_term.term
     *
     * @mbggenerated
     */
    public String getTerm() {
        return term;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lottery_term.term
     *
     * @param term the value for lottery_term.term
     *
     * @mbggenerated
     */
    public void setTerm(String term) {
        this.term = term == null ? null : term.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lottery_term.startTime
     *
     * @return the value of lottery_term.startTime
     *
     * @mbggenerated
     */
    public Date getStarttime() {
        return starttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lottery_term.startTime
     *
     * @param starttime the value for lottery_term.startTime
     *
     * @mbggenerated
     */
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lottery_term.endTime
     *
     * @return the value of lottery_term.endTime
     *
     * @mbggenerated
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lottery_term.endTime
     *
     * @param endtime the value for lottery_term.endTime
     *
     * @mbggenerated
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lottery_term.isCurrent
     *
     * @return the value of lottery_term.isCurrent
     *
     * @mbggenerated
     */
    public Byte getIscurrent() {
        return iscurrent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lottery_term.isCurrent
     *
     * @param iscurrent the value for lottery_term.isCurrent
     *
     * @mbggenerated
     */
    public void setIscurrent(Byte iscurrent) {
        this.iscurrent = iscurrent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lottery_term.status
     *
     * @return the value of lottery_term.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lottery_term.status
     *
     * @param status the value for lottery_term.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lottery_term.result
     *
     * @return the value of lottery_term.result
     *
     * @mbggenerated
     */
    public String getResult() {
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lottery_term.result
     *
     * @param result the value for lottery_term.result
     *
     * @mbggenerated
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lottery_term.prize_detail
     *
     * @return the value of lottery_term.prize_detail
     *
     * @mbggenerated
     */
    public String getPrizeDetail() {
        return prizeDetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lottery_term.prize_detail
     *
     * @param prizeDetail the value for lottery_term.prize_detail
     *
     * @mbggenerated
     */
    public void setPrizeDetail(String prizeDetail) {
        this.prizeDetail = prizeDetail == null ? null : prizeDetail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lottery_term
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        LotteryTerm other = (LotteryTerm) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getTerm() == null ? other.getTerm() == null : this.getTerm().equals(other.getTerm()))
            && (this.getStarttime() == null ? other.getStarttime() == null : this.getStarttime().equals(other.getStarttime()))
            && (this.getEndtime() == null ? other.getEndtime() == null : this.getEndtime().equals(other.getEndtime()))
            && (this.getIscurrent() == null ? other.getIscurrent() == null : this.getIscurrent().equals(other.getIscurrent()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getPrizeDetail() == null ? other.getPrizeDetail() == null : this.getPrizeDetail().equals(other.getPrizeDetail()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lottery_term
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getTerm() == null) ? 0 : getTerm().hashCode());
        result = prime * result + ((getStarttime() == null) ? 0 : getStarttime().hashCode());
        result = prime * result + ((getEndtime() == null) ? 0 : getEndtime().hashCode());
        result = prime * result + ((getIscurrent() == null) ? 0 : getIscurrent().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getPrizeDetail() == null) ? 0 : getPrizeDetail().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lottery_term
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", term=").append(term);
        sb.append(", starttime=").append(starttime);
        sb.append(", endtime=").append(endtime);
        sb.append(", iscurrent=").append(iscurrent);
        sb.append(", status=").append(status);
        sb.append(", result=").append(result);
        sb.append(", prizeDetail=").append(prizeDetail);
        sb.append("]");
        return sb.toString();
    }
}