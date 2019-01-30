package com.proaim.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @date 2019/1/30
 */
// 作用在参数实体或者响应实体上，description代表描述信息
@ApiModel(description = "测试模型实体")
@Data
public class Test {
    // 作用在实体属性上，标记属性名称和说明内容，name代表属性名称，value表示属性内容，hidden是否因此，默认是false
    @ApiModelProperty(name = "id", value = "主键", hidden = true)
    private Integer id;
    @ApiModelProperty(name = "content", value = "测试内容")
    private String content;
    @ApiModelProperty(name = "valid", value = "是否有效0=无效，1=有效", hidden = true)
    private Integer valid;
}
