package com.example.goods.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品图片信息表
 * @TableName product_pic_info
 */
@TableName(value ="product_pic_info")
@Data
public class ProductPicInfo implements Serializable {
    /**
     * 商品图片ID
     */
    @TableId(type = IdType.AUTO)
    private Integer productPicId;

    /**
     * 商品ID
     */
    private Integer productId;

    /**
     * 图片描述
     */
    private String picDesc;

    /**
     * 图片URL
     */
    private String picUrl;

    /**
     * 是否主图：0.非主图1.主图
     */
    private Byte isMaster;

    /**
     * 图片排序
     */
    private Byte picOrder;

    /**
     * 图片是否有效：0无效 1有效
     */
    private Byte picStatus;

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
        ProductPicInfo other = (ProductPicInfo) that;
        return (this.getProductPicId() == null ? other.getProductPicId() == null : this.getProductPicId().equals(other.getProductPicId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getPicDesc() == null ? other.getPicDesc() == null : this.getPicDesc().equals(other.getPicDesc()))
            && (this.getPicUrl() == null ? other.getPicUrl() == null : this.getPicUrl().equals(other.getPicUrl()))
            && (this.getIsMaster() == null ? other.getIsMaster() == null : this.getIsMaster().equals(other.getIsMaster()))
            && (this.getPicOrder() == null ? other.getPicOrder() == null : this.getPicOrder().equals(other.getPicOrder()))
            && (this.getPicStatus() == null ? other.getPicStatus() == null : this.getPicStatus().equals(other.getPicStatus()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProductPicId() == null) ? 0 : getProductPicId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getPicDesc() == null) ? 0 : getPicDesc().hashCode());
        result = prime * result + ((getPicUrl() == null) ? 0 : getPicUrl().hashCode());
        result = prime * result + ((getIsMaster() == null) ? 0 : getIsMaster().hashCode());
        result = prime * result + ((getPicOrder() == null) ? 0 : getPicOrder().hashCode());
        result = prime * result + ((getPicStatus() == null) ? 0 : getPicStatus().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productPicId=").append(productPicId);
        sb.append(", productId=").append(productId);
        sb.append(", picDesc=").append(picDesc);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", isMaster=").append(isMaster);
        sb.append(", picOrder=").append(picOrder);
        sb.append(", picStatus=").append(picStatus);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}