package com.proaim.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 商品图片表
 *
 * @date 2019/1/29
 */
@Data
@ApiModel("商品图片模型实体类")
public class CommodityImage implements Serializable {
    @ApiModelProperty(name = "id", value = "商品图片主键")
    private Long id; // 图片ID
    @ApiModelProperty(name = "commodityId", value = "商品外键")
    private Long commodityId; // 商品ID
    @ApiModelProperty(name = "url", value = "商品图片URL", required = true)
    private String url; // 商品图片
    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Timestamp createTime;
    @ApiModelProperty(name = "updateTime", value = "修改时间")
    private Timestamp updateTime;
    @ApiModelProperty(name = "enabled", value = "删除标记(默认：1)")
    private Integer enabled;// 是否删除，默认为1

}
