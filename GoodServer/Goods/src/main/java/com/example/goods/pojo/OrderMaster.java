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
 * 订单主表
 * @TableName order_master
 */
@TableName(value ="order_master")
@Data
public class OrderMaster implements Serializable {
    /**
     * 订单ID
     */
    @TableId(type = IdType.AUTO)
    private Integer orderId;

    /**
     * 订单编号 yyyymmddnnnnnnnn
     */
    private String orderSn;

    /**
     * 下单人ID
     */
    private Integer customerId;

    /**
     * 收货人姓名
     */
    private String shippingUser;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String district;

    /**
     * 地址
     */
    private String address;

    /**
     * 支付方式：1现金，2余额，3网银，4支付宝，5微信
     */
    private Integer paymentMethod;

    /**
     * 订单金额
     */
    private BigDecimal orderMoney;

    /**
     * 优惠金额
     */
    private BigDecimal districtMoney;

    /**
     * 运费金额
     */
    private BigDecimal shippingMoney;

    /**
     * 支付金额
     */
    private BigDecimal paymentMoney;

    /**
     * 快递公司名称
     */
    private String shippingCompName;

    /**
     * 快递单号
     */
    private String shippingSn;

    /**
     * 下单时间
     */
    private Date createTime;

    /**
     * 发货时间
     */
    private Date shippingTime;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 收货时间
     */
    private Date receiveTime;

    /**
     * 订单状态
     */
    private Byte orderStatus;

    /**
     * 订单积分
     */
    private Integer orderPoint;

    /**
     * 发票抬头
     */
    private String invoiceTime;

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
        OrderMaster other = (OrderMaster) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getOrderSn() == null ? other.getOrderSn() == null : this.getOrderSn().equals(other.getOrderSn()))
            && (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()))
            && (this.getShippingUser() == null ? other.getShippingUser() == null : this.getShippingUser().equals(other.getShippingUser()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getDistrict() == null ? other.getDistrict() == null : this.getDistrict().equals(other.getDistrict()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getPaymentMethod() == null ? other.getPaymentMethod() == null : this.getPaymentMethod().equals(other.getPaymentMethod()))
            && (this.getOrderMoney() == null ? other.getOrderMoney() == null : this.getOrderMoney().equals(other.getOrderMoney()))
            && (this.getDistrictMoney() == null ? other.getDistrictMoney() == null : this.getDistrictMoney().equals(other.getDistrictMoney()))
            && (this.getShippingMoney() == null ? other.getShippingMoney() == null : this.getShippingMoney().equals(other.getShippingMoney()))
            && (this.getPaymentMoney() == null ? other.getPaymentMoney() == null : this.getPaymentMoney().equals(other.getPaymentMoney()))
            && (this.getShippingCompName() == null ? other.getShippingCompName() == null : this.getShippingCompName().equals(other.getShippingCompName()))
            && (this.getShippingSn() == null ? other.getShippingSn() == null : this.getShippingSn().equals(other.getShippingSn()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getShippingTime() == null ? other.getShippingTime() == null : this.getShippingTime().equals(other.getShippingTime()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getReceiveTime() == null ? other.getReceiveTime() == null : this.getReceiveTime().equals(other.getReceiveTime()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
            && (this.getOrderPoint() == null ? other.getOrderPoint() == null : this.getOrderPoint().equals(other.getOrderPoint()))
            && (this.getInvoiceTime() == null ? other.getInvoiceTime() == null : this.getInvoiceTime().equals(other.getInvoiceTime()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getOrderSn() == null) ? 0 : getOrderSn().hashCode());
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        result = prime * result + ((getShippingUser() == null) ? 0 : getShippingUser().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getDistrict() == null) ? 0 : getDistrict().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getPaymentMethod() == null) ? 0 : getPaymentMethod().hashCode());
        result = prime * result + ((getOrderMoney() == null) ? 0 : getOrderMoney().hashCode());
        result = prime * result + ((getDistrictMoney() == null) ? 0 : getDistrictMoney().hashCode());
        result = prime * result + ((getShippingMoney() == null) ? 0 : getShippingMoney().hashCode());
        result = prime * result + ((getPaymentMoney() == null) ? 0 : getPaymentMoney().hashCode());
        result = prime * result + ((getShippingCompName() == null) ? 0 : getShippingCompName().hashCode());
        result = prime * result + ((getShippingSn() == null) ? 0 : getShippingSn().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getShippingTime() == null) ? 0 : getShippingTime().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getReceiveTime() == null) ? 0 : getReceiveTime().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getOrderPoint() == null) ? 0 : getOrderPoint().hashCode());
        result = prime * result + ((getInvoiceTime() == null) ? 0 : getInvoiceTime().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", customerId=").append(customerId);
        sb.append(", shippingUser=").append(shippingUser);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", district=").append(district);
        sb.append(", address=").append(address);
        sb.append(", paymentMethod=").append(paymentMethod);
        sb.append(", orderMoney=").append(orderMoney);
        sb.append(", districtMoney=").append(districtMoney);
        sb.append(", shippingMoney=").append(shippingMoney);
        sb.append(", paymentMoney=").append(paymentMoney);
        sb.append(", shippingCompName=").append(shippingCompName);
        sb.append(", shippingSn=").append(shippingSn);
        sb.append(", createTime=").append(createTime);
        sb.append(", shippingTime=").append(shippingTime);
        sb.append(", payTime=").append(payTime);
        sb.append(", receiveTime=").append(receiveTime);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", orderPoint=").append(orderPoint);
        sb.append(", invoiceTime=").append(invoiceTime);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}