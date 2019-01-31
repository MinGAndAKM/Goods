package com.proaim.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @date 2019/1/31
 */
@Data
@ApiModel("商品品牌模型实体类")
public class Brand {
    @ApiModelProperty(name = "id", value = "品牌ID")
    private Long id;
    @ApiModelProperty(name = "name", value = "品牌名称")
    private String name;
    @ApiModelProperty(name = "coverUrl", value = "封面url")
    private String coverUrl;
    @ApiModelProperty(name = "logoLg", value = "品牌logo，大图")
    private String logoLg;
    @ApiModelProperty(name = "logoSm", value = "品牌logo，中图")
    private String logoSm;
    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Timestamp createTime;
    @ApiModelProperty(name = "updateTime", value = "更新时间")
    private Timestamp updateTime;
    @ApiModelProperty(name = "description", value = "品牌描述")
    private String description;
    @ApiModelProperty(name = "enabled", value = "删除标记（默认：1）")
    private Integer enabled;

}
