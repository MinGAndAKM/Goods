package com.proaim.controller.test;

import com.proaim.entity.Test;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @date 2019/1/30
 */
@RestController
@RequestMapping("/test")
@Api(tags = "测试API接口") // 标记controller类是做什么的，tags表示分类
public class TestController {
    @GetMapping("/")
    // 标记controller下的方法，表示这个接口是做什么的，value就是说明作用，notes详细说明
    @ApiOperation(value = "获取列表数据", notes = "获取列表下测试数据")
    public String list() {
        return "查询列表数据！";
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取ID数据", notes = "根据ID获取某条测试数据")
    /*
     * @ApiImplicitParam标记参数，name是参数名，value是参数说明
     * paramType是参数类型：path(路径参数),query(查询参数), body(请求体参数)，header(请求头参数)，
     * form(表单提交参数)，require代表是否必填，默认是false
     */
    @ApiImplicitParam(name = "id", value = "主键id", paramType = "path", required = true)
    public String find(@PathVariable Integer id) {
        return String.format("根据主键查询数据: %d", id);
    }

    @PostMapping("/")
    @ApiOperation(value = "新增数据")
    /*
     * ApiParam与@ApiImplicitParam类似，标记参数，不过不同的是：
     * 对Servlets或者非 JAX-RS的环境，只能使用 ApiImplicitParam。
     * 在使用上，ApiImplicitParam比ApiParam具有更少的代码侵入性，只要写在方法上就可以了，但是需要提供具体的属性才能配合swagger ui解析使用。
     * ApiParam只需要较少的属性，与swagger ui配合更好。
     */
    @ApiParam(name = "test", value = "添加的测试模型实体")
    public String add(@RequestBody Test test) {
        return "插入数据!";
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "更新数据", notes = "根据ID更新测试数据")
    @ApiImplicitParam(name = "id", value = "主键id", paramType = "path", required = true)
    public String update(@PathVariable Integer id, @ApiParam(name = "test", value = "更新的测试模型实体") @RequestBody Test test) {
        return String.format("根据主键更新一条记录: %d", id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除数据", notes = "根据ID删除测试数据")
    @ApiImplicitParam(name = "id", value = "主键id", paramType = "path", required = true)
    public String delete(@PathVariable Integer id) {
        return String.format("根据主键删除记录: %d", id);
    }
}
