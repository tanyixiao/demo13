package com.example.goods.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 订单详情表
 * @TableName order_detail
 */
@TableName(value ="order_detail")
@Data
@Accessors(chain = true)
public class OrderDetail implements Serializable {
    /**
     * 订单详情表ID
     */
    @TableId(type = IdType.AUTO)
    private Integer orderDetailId;

    /**
     * 订单表ID
     */
    private Integer orderId;

    /**
     * 订单商品ID
     */
    private Integer productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 购买商品数量
     */
    private Integer productCnt;

    /**
     * 购买商品单价
     */
    private BigDecimal productPrice;

    /**
     * 平均成本价格
     */
    private BigDecimal averageCost;

    /**
     * 商品重量
     */
    private Double weight;

    /**
     * 优惠分摊金额
     */
    private BigDecimal feeMoney;

    /**
     * 仓库ID
     */
    private Integer storeId;

    /**
     * 最后修改时间
     */
    private Date modifiedTime;
    @TableField(exist = false)
    private OrderMaster orderMaster;
    @TableField(exist = false)
    private ProductInfo productInfo;
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
        OrderDetail other = (OrderDetail) that;
        return (this.getOrderDetailId() == null ? other.getOrderDetailId() == null : this.getOrderDetailId().equals(other.getOrderDetailId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getProductCnt() == null ? other.getProductCnt() == null : this.getProductCnt().equals(other.getProductCnt()))
            && (this.getProductPrice() == null ? other.getProductPrice() == null : this.getProductPrice().equals(other.getProductPrice()))
            && (this.getAverageCost() == null ? other.getAverageCost() == null : this.getAverageCost().equals(other.getAverageCost()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getFeeMoney() == null ? other.getFeeMoney() == null : this.getFeeMoney().equals(other.getFeeMoney()))
            && (this.getStoreId() == null ? other.getStoreId() == null : this.getStoreId().equals(other.getStoreId()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderDetailId() == null) ? 0 : getOrderDetailId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getProductCnt() == null) ? 0 : getProductCnt().hashCode());
        result = prime * result + ((getProductPrice() == null) ? 0 : getProductPrice().hashCode());
        result = prime * result + ((getAverageCost() == null) ? 0 : getAverageCost().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getFeeMoney() == null) ? 0 : getFeeMoney().hashCode());
        result = prime * result + ((getStoreId() == null) ? 0 : getStoreId().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderDetailId=").append(orderDetailId);
        sb.append(", orderId=").append(orderId);
        sb.append(", productId=").append(productId);
        sb.append(", productName=").append(productName);
        sb.append(", productCnt=").append(productCnt);
        sb.append(", productPrice=").append(productPrice);
        sb.append(", averageCost=").append(averageCost);
        sb.append(", weight=").append(weight);
        sb.append(", feeMoney=").append(feeMoney);
        sb.append(", storeId=").append(storeId);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
