package com.proaim.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 商品表
 *
 * @date 2019/1/29
 */
@Data
@ApiModel("商品模型实体类")
public class Commodity implements Serializable {
    @ApiModelProperty(name = "id", value = "商品主键")
    private Long id; // 商品ID
    @ApiModelProperty(name = "brandId", value = "品牌外键")
    private Long brandId; // 品牌ID
    @ApiModelProperty(name = "categoryId", value = "分类外键")
    private Long categoryId; // 分类ID
    @ApiModelProperty(name = "name", value = "商品名称")
    private String name; // 商品名称
    @ApiModelProperty(name = "brandName", value = "品牌名称")
    private String brandName; //品牌名称
    @ApiModelProperty(name = "description", value = "商品描述")
    private String description; // 商品描述
    @ApiModelProperty(name = "price", value = "商品价格")
    private BigDecimal price; // 商品价格
    @ApiModelProperty(name = "detail", value = "商品详细")
    private String detail; // 商品详情
    @ApiModelProperty(name = "orderCommodity", value = "排序")
    private Integer orderCommodity; // 排序
    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Timestamp createTime;
    @ApiModelProperty(name = "updateTime", value = "修改时间")
    private Timestamp updateTime;
    @ApiModelProperty(name = "enabled", value = "删除标记(默认：1)")
    private Integer enabled; // 是否删除，默认为1

}
