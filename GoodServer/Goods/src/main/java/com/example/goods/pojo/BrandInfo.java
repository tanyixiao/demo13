package com.example.goods.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 品牌信息表
 * @TableName brand_info
 */
@TableName(value ="brand_info")
@Data
public class BrandInfo implements Serializable {
    /**
     * 品牌ID
     */
    @TableId(type = IdType.AUTO)
    private Short brandId;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 品牌网络
     */
    private String brandWeb;

    /**
     * 品牌logo URL
     */
    private String brandLogo;

    /**
     * 品牌描述
     */
    private String brandDesc;

    /**
     * 品牌状态,0禁用,1启用
     */
    private Byte brandStatus;

    /**
     * 排序
     */
    private Byte brandOrder;

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
        BrandInfo other = (BrandInfo) that;
        return (this.getBrandId() == null ? other.getBrandId() == null : this.getBrandId().equals(other.getBrandId()))
            && (this.getBrandName() == null ? other.getBrandName() == null : this.getBrandName().equals(other.getBrandName()))
            && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
            && (this.getBrandWeb() == null ? other.getBrandWeb() == null : this.getBrandWeb().equals(other.getBrandWeb()))
            && (this.getBrandLogo() == null ? other.getBrandLogo() == null : this.getBrandLogo().equals(other.getBrandLogo()))
            && (this.getBrandDesc() == null ? other.getBrandDesc() == null : this.getBrandDesc().equals(other.getBrandDesc()))
            && (this.getBrandStatus() == null ? other.getBrandStatus() == null : this.getBrandStatus().equals(other.getBrandStatus()))
            && (this.getBrandOrder() == null ? other.getBrandOrder() == null : this.getBrandOrder().equals(other.getBrandOrder()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBrandId() == null) ? 0 : getBrandId().hashCode());
        result = prime * result + ((getBrandName() == null) ? 0 : getBrandName().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        result = prime * result + ((getBrandWeb() == null) ? 0 : getBrandWeb().hashCode());
        result = prime * result + ((getBrandLogo() == null) ? 0 : getBrandLogo().hashCode());
        result = prime * result + ((getBrandDesc() == null) ? 0 : getBrandDesc().hashCode());
        result = prime * result + ((getBrandStatus() == null) ? 0 : getBrandStatus().hashCode());
        result = prime * result + ((getBrandOrder() == null) ? 0 : getBrandOrder().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", brandId=").append(brandId);
        sb.append(", brandName=").append(brandName);
        sb.append(", telephone=").append(telephone);
        sb.append(", brandWeb=").append(brandWeb);
        sb.append(", brandLogo=").append(brandLogo);
        sb.append(", brandDesc=").append(brandDesc);
        sb.append(", brandStatus=").append(brandStatus);
        sb.append(", brandOrder=").append(brandOrder);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}