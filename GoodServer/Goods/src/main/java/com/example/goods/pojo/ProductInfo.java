package com.example.goods.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * 商品信息表
 * @TableName product_info
 */
@TableName(value ="product_info")
@Data
public class ProductInfo implements Serializable {
    /**
     * 商品ID
     */
    @TableId(type = IdType.AUTO)
    private Integer productId;

    /**
     * 商品编码
     */
    private String productCore;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 品牌表的ID
     */
    private Integer brandId;

    /**
     * 一级分类ID
     */
    private Short oneCategoryId;

    /**
     * 二级分类ID
     */
    private Short twoCategoryId;

    /**
     * 三级分类ID
     */
    private Short threeCategoryId;

    /**
     * 商品的供应商ID
     */
    private Integer supplierId;

    /**
     * 商品销售价格
     */
    private BigDecimal price;

    /**
     * 商品加权平均成本
     */
    private BigDecimal averageCost;

    /**
     * 上下架状态：0下架1上架
     */
    private Byte publishStatus;

    /**
     * 审核状态：0未审核，1已审核
     */
    private Byte auditStatus;

    /**
     * 商品重量
     */
    private Double weight;

    /**
     * 商品长度
     */
    private Double length;

    /**
     * 商品高度
     */
    private Double height;

    /**
     * 商品宽度
     */
    private Double width;

    /**
     *
     */
    private Object colorType;

    /**
     * 生产日期
     */
    private Date productionDate;

    /**
     * 商品有效期
     */
    private Integer shelfLife;

    /**
     * 商品描述
     */
    private String descript;

    /**
     * 商品录入时间
     */
    private Date indate;

    /**
     * 最后修改时间
     */
    private Date modifiedTime;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    @TableField(exist = false)
    private BrandInfo brandInfo;
    @TableField(exist = false)
    private List<ProductCategory> productCategoryList;
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
        ProductInfo other = (ProductInfo) that;
        return (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getProductCore() == null ? other.getProductCore() == null : this.getProductCore().equals(other.getProductCore()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getBrandId() == null ? other.getBrandId() == null : this.getBrandId().equals(other.getBrandId()))
            && (this.getOneCategoryId() == null ? other.getOneCategoryId() == null : this.getOneCategoryId().equals(other.getOneCategoryId()))
            && (this.getTwoCategoryId() == null ? other.getTwoCategoryId() == null : this.getTwoCategoryId().equals(other.getTwoCategoryId()))
            && (this.getThreeCategoryId() == null ? other.getThreeCategoryId() == null : this.getThreeCategoryId().equals(other.getThreeCategoryId()))
            && (this.getSupplierId() == null ? other.getSupplierId() == null : this.getSupplierId().equals(other.getSupplierId()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getAverageCost() == null ? other.getAverageCost() == null : this.getAverageCost().equals(other.getAverageCost()))
            && (this.getPublishStatus() == null ? other.getPublishStatus() == null : this.getPublishStatus().equals(other.getPublishStatus()))
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getLength() == null ? other.getLength() == null : this.getLength().equals(other.getLength()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getWidth() == null ? other.getWidth() == null : this.getWidth().equals(other.getWidth()))
            && (this.getColorType() == null ? other.getColorType() == null : this.getColorType().equals(other.getColorType()))
            && (this.getProductionDate() == null ? other.getProductionDate() == null : this.getProductionDate().equals(other.getProductionDate()))
            && (this.getShelfLife() == null ? other.getShelfLife() == null : this.getShelfLife().equals(other.getShelfLife()))
            && (this.getDescript() == null ? other.getDescript() == null : this.getDescript().equals(other.getDescript()))
            && (this.getIndate() == null ? other.getIndate() == null : this.getIndate().equals(other.getIndate()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getProductCore() == null) ? 0 : getProductCore().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getBrandId() == null) ? 0 : getBrandId().hashCode());
        result = prime * result + ((getOneCategoryId() == null) ? 0 : getOneCategoryId().hashCode());
        result = prime * result + ((getTwoCategoryId() == null) ? 0 : getTwoCategoryId().hashCode());
        result = prime * result + ((getThreeCategoryId() == null) ? 0 : getThreeCategoryId().hashCode());
        result = prime * result + ((getSupplierId() == null) ? 0 : getSupplierId().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getAverageCost() == null) ? 0 : getAverageCost().hashCode());
        result = prime * result + ((getPublishStatus() == null) ? 0 : getPublishStatus().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getLength() == null) ? 0 : getLength().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getWidth() == null) ? 0 : getWidth().hashCode());
        result = prime * result + ((getColorType() == null) ? 0 : getColorType().hashCode());
        result = prime * result + ((getProductionDate() == null) ? 0 : getProductionDate().hashCode());
        result = prime * result + ((getShelfLife() == null) ? 0 : getShelfLife().hashCode());
        result = prime * result + ((getDescript() == null) ? 0 : getDescript().hashCode());
        result = prime * result + ((getIndate() == null) ? 0 : getIndate().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productId=").append(productId);
        sb.append(", productCore=").append(productCore);
        sb.append(", productName=").append(productName);
        sb.append(", brandId=").append(brandId);
        sb.append(", oneCategoryId=").append(oneCategoryId);
        sb.append(", twoCategoryId=").append(twoCategoryId);
        sb.append(", threeCategoryId=").append(threeCategoryId);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", price=").append(price);
        sb.append(", averageCost=").append(averageCost);
        sb.append(", publishStatus=").append(publishStatus);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", weight=").append(weight);
        sb.append(", length=").append(length);
        sb.append(", height=").append(height);
        sb.append(", width=").append(width);
        sb.append(", colorType=").append(colorType);
        sb.append(", productionDate=").append(productionDate);
        sb.append(", shelfLife=").append(shelfLife);
        sb.append(", descript=").append(descript);
        sb.append(", indate=").append(indate);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
