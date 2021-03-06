package com.jack.lottery.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Account {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.userId
     *
     * @mbggenerated
     */
    private Long userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.balance
     *
     * @mbggenerated
     */
    private BigDecimal balance;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.freeze_balance
     *
     * @mbggenerated
     */
    private BigDecimal freezeBalance;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.available_balance
     *
     * @mbggenerated
     */
    private BigDecimal availableBalance;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.win_prize
     *
     * @mbggenerated
     */
    private BigDecimal winPrize;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.id
     *
     * @return the value of account.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.id
     *
     * @param id the value for account.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.userId
     *
     * @return the value of account.userId
     *
     * @mbggenerated
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.userId
     *
     * @param userid the value for account.userId
     *
     * @mbggenerated
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.balance
     *
     * @return the value of account.balance
     *
     * @mbggenerated
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.balance
     *
     * @param balance the value for account.balance
     *
     * @mbggenerated
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.freeze_balance
     *
     * @return the value of account.freeze_balance
     *
     * @mbggenerated
     */
    public BigDecimal getFreezeBalance() {
        return freezeBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.freeze_balance
     *
     * @param freezeBalance the value for account.freeze_balance
     *
     * @mbggenerated
     */
    public void setFreezeBalance(BigDecimal freezeBalance) {
        this.freezeBalance = freezeBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.available_balance
     *
     * @return the value of account.available_balance
     *
     * @mbggenerated
     */
    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.available_balance
     *
     * @param availableBalance the value for account.available_balance
     *
     * @mbggenerated
     */
    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.win_prize
     *
     * @return the value of account.win_prize
     *
     * @mbggenerated
     */
    public BigDecimal getWinPrize() {
        return winPrize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.win_prize
     *
     * @param winPrize the value for account.win_prize
     *
     * @mbggenerated
     */
    public void setWinPrize(BigDecimal winPrize) {
        this.winPrize = winPrize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.create_time
     *
     * @return the value of account.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.create_time
     *
     * @param createTime the value for account.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.update_time
     *
     * @return the value of account.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.update_time
     *
     * @param updateTime the value for account.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account
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
        Account other = (Account) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getFreezeBalance() == null ? other.getFreezeBalance() == null : this.getFreezeBalance().equals(other.getFreezeBalance()))
            && (this.getAvailableBalance() == null ? other.getAvailableBalance() == null : this.getAvailableBalance().equals(other.getAvailableBalance()))
            && (this.getWinPrize() == null ? other.getWinPrize() == null : this.getWinPrize().equals(other.getWinPrize()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getFreezeBalance() == null) ? 0 : getFreezeBalance().hashCode());
        result = prime * result + ((getAvailableBalance() == null) ? 0 : getAvailableBalance().hashCode());
        result = prime * result + ((getWinPrize() == null) ? 0 : getWinPrize().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account
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
        sb.append(", userid=").append(userid);
        sb.append(", balance=").append(balance);
        sb.append(", freezeBalance=").append(freezeBalance);
        sb.append(", availableBalance=").append(availableBalance);
        sb.append(", winPrize=").append(winPrize);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}