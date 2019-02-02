package com.proaim.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel("轮播模型实体类")
public class Carousel implements Serializable {
    @ApiModelProperty("轮播ID")
    private Long id;
    /*@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")*/
    /*@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")*/
    @ApiModelProperty("开始时间")
    private Date startTime;
    /*@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")*/
    /*@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")*/
    @ApiModelProperty("结束时间")
    private Date endTime;
    @ApiModelProperty("轮播轮数")
    private Boolean roundAtLast;
    @ApiModelProperty("是否自动播放")
    private Boolean auto;
    @ApiModelProperty("按照0、1、2排序的先后顺序显示")
    private Byte orderCommodity;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("修改时间")
    private Date updateTime;
    @ApiModelProperty(name = "enabled", value = "删除标记(默认：1)")
    private Boolean enabled;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Boolean getRoundAtLast() {
        return roundAtLast;
    }

    public void setRoundAtLast(Boolean roundAtLast) {
        this.roundAtLast = roundAtLast;
    }

    public Boolean getAuto() {
        return auto;
    }

    public void setAuto(Boolean auto) {
        this.auto = auto;
    }

    public Byte getOrderCommodity() {
        return orderCommodity;
    }

    public void setOrderCommodity(Byte orderCommodity) {
        this.orderCommodity = orderCommodity;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", roundAtLast=").append(roundAtLast);
        sb.append(", auto=").append(auto);
        sb.append(", orderCommodity=").append(orderCommodity);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", enabled=").append(enabled);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}