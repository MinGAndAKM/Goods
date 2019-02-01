package com.proaim.entity;

import java.io.Serializable;
import java.util.Date;

public class Carousel implements Serializable {
    private Long id;

    private Date startTime;

    private Date endTime;

    private Boolean roundAtLast;

    private Boolean auto;

    private Byte orderCommodity;

    private Date createTime;

    private Date updateTime;

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