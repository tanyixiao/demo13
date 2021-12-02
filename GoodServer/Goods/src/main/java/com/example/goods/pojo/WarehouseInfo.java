package com.example.goods.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 仓库信息表
 * @TableName warehouse_info
 */
@TableName(value ="warehouse_info")
@Data
public class WarehouseInfo implements Serializable {
    /**
     * 仓库ID
     */
    @TableId(type = IdType.AUTO)
    private Short wId;

    /**
     * 仓库编码
     */
    private String warehouseSn;

    /**
     * 仓库名称
     */
    private String warehoustName;

    /**
     * 仓库电话
     */
    private String warehousePhone;

    /**
     * 仓库联系人
     */
    private String contact;

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
    private String distrct;

    /**
     * 仓库地址
     */
    private String address;

    /**
     * 仓库状态：0禁用，1启用
     */
    private Integer warehouseStatus;

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
        WarehouseInfo other = (WarehouseInfo) that;
        return (this.getWId() == null ? other.getWId() == null : this.getWId()).equals(other.getWId())
            && (this.getWarehouseSn() == null ? other.getWarehouseSn() == null : this.getWarehouseSn().equals(other.getWarehouseSn()))
            && (this.getWarehoustName() == null ? other.getWarehoustName() == null : this.getWarehoustName().equals(other.getWarehoustName()))
            && (this.getWarehousePhone() == null ? other.getWarehousePhone() == null : this.getWarehousePhone().equals(other.getWarehousePhone()))
            && (this.getContact() == null ? other.getContact() == null : this.getContact().equals(other.getContact()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getDistrct() == null ? other.getDistrct() == null : this.getDistrct().equals(other.getDistrct()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getWarehouseStatus() == null ? other.getWarehouseStatus() == null : this.getWarehouseStatus().equals(other.getWarehouseStatus()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWId() == null) ? 0 : getWId().hashCode());
        result = prime * result + ((getWarehouseSn() == null) ? 0 : getWarehouseSn().hashCode());
        result = prime * result + ((getWarehoustName() == null) ? 0 : getWarehoustName().hashCode());
        result = prime * result + ((getWarehousePhone() == null) ? 0 : getWarehousePhone().hashCode());
        result = prime * result + ((getContact() == null) ? 0 : getContact().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getDistrct() == null) ? 0 : getDistrct().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getWarehouseStatus() == null) ? 0 : getWarehouseStatus().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", wId=").append(wId);
        sb.append(", warehouseSn=").append(warehouseSn);
        sb.append(", warehoustName=").append(warehoustName);
        sb.append(", warehousePhone=").append(warehousePhone);
        sb.append(", contact=").append(contact);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", distrct=").append(distrct);
        sb.append(", address=").append(address);
        sb.append(", warehouseStatus=").append(warehouseStatus);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
