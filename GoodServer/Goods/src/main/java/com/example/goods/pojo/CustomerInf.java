package com.example.goods.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 用户信息表
 * @TableName customer_inf
 */
@TableName(value ="customer_inf")
@Data
public class CustomerInf implements Serializable {
    /**
     * 自增主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer customerInfId;

    /**
     * customer_login表的自增ID
     */
    private Integer customerId;

    /**
     * 用户真实姓名
     */
    private String customerName;

    /**
     * 证件类型：1 身份证，2 军官证，3 护照
     */
    private Byte identityCardType;

    /**
     * 证件号码
     */
    private String identityCardNo;

    /**
     * 手机号
     */
    private Integer mobilePhone;

    /**
     * 邮箱
     */
    private String customerEmail;

    /**
     * 性别
     */
    private String gender;

    /**
     * 用户积分
     */
    private Integer userPoint;

    /**
     * 注册时间
     */
    private Date registerTime;

    /**
     * 会员生日
     */
    private Date birthday;

    /**
     * 会员级别：1 普通会员，2 青铜，3白银，4黄金，5钻石
     */
    private Byte customerLevel;

    /**
     * 用户余额
     */
    private BigDecimal userMoney;

    /**
     * 最后修改时间
     */
    private Date modifiedTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

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
        CustomerInf other = (CustomerInf) that;
        return (this.getCustomerInfId() == null ? other.getCustomerInfId() == null : this.getCustomerInfId().equals(other.getCustomerInfId()))
            && (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()))
            && (this.getCustomerName() == null ? other.getCustomerName() == null : this.getCustomerName().equals(other.getCustomerName()))
            && (this.getIdentityCardType() == null ? other.getIdentityCardType() == null : this.getIdentityCardType().equals(other.getIdentityCardType()))
            && (this.getIdentityCardNo() == null ? other.getIdentityCardNo() == null : this.getIdentityCardNo().equals(other.getIdentityCardNo()))
            && (this.getMobilePhone() == null ? other.getMobilePhone() == null : this.getMobilePhone().equals(other.getMobilePhone()))
            && (this.getCustomerEmail() == null ? other.getCustomerEmail() == null : this.getCustomerEmail().equals(other.getCustomerEmail()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getUserPoint() == null ? other.getUserPoint() == null : this.getUserPoint().equals(other.getUserPoint()))
            && (this.getRegisterTime() == null ? other.getRegisterTime() == null : this.getRegisterTime().equals(other.getRegisterTime()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getCustomerLevel() == null ? other.getCustomerLevel() == null : this.getCustomerLevel().equals(other.getCustomerLevel()))
            && (this.getUserMoney() == null ? other.getUserMoney() == null : this.getUserMoney().equals(other.getUserMoney()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCustomerInfId() == null) ? 0 : getCustomerInfId().hashCode());
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        result = prime * result + ((getCustomerName() == null) ? 0 : getCustomerName().hashCode());
        result = prime * result + ((getIdentityCardType() == null) ? 0 : getIdentityCardType().hashCode());
        result = prime * result + ((getIdentityCardNo() == null) ? 0 : getIdentityCardNo().hashCode());
        result = prime * result + ((getMobilePhone() == null) ? 0 : getMobilePhone().hashCode());
        result = prime * result + ((getCustomerEmail() == null) ? 0 : getCustomerEmail().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getUserPoint() == null) ? 0 : getUserPoint().hashCode());
        result = prime * result + ((getRegisterTime() == null) ? 0 : getRegisterTime().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getCustomerLevel() == null) ? 0 : getCustomerLevel().hashCode());
        result = prime * result + ((getUserMoney() == null) ? 0 : getUserMoney().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", customerInfId=").append(customerInfId);
        sb.append(", customerId=").append(customerId);
        sb.append(", customerName=").append(customerName);
        sb.append(", identityCardType=").append(identityCardType);
        sb.append(", identityCardNo=").append(identityCardNo);
        sb.append(", mobilePhone=").append(mobilePhone);
        sb.append(", customerEmail=").append(customerEmail);
        sb.append(", gender=").append(gender);
        sb.append(", userPoint=").append(userPoint);
        sb.append(", registerTime=").append(registerTime);
        sb.append(", birthday=").append(birthday);
        sb.append(", customerLevel=").append(customerLevel);
        sb.append(", userMoney=").append(userMoney);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}