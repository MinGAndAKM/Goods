package com.proaim.controller.brand;

import com.proaim.entity.Brand;
import com.proaim.entity.Result;
import com.proaim.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @date 2019/1/31
 */
@RestController
@RequestMapping("/brand")
@Api(tags = "品牌控制器")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("")
    @ApiOperation(value = "查询所有品牌")
    public List<Brand> list() {
        return brandService.listObjects();
    }

    @GetMapping("/getById")
    @ApiOperation(value = "根据品牌ID查询")
    public Brand getBrandById(@RequestParam(value = "id", required = false) Long id) {
        return brandService.getObjectById(id);
    }

    @GetMapping("/getByName")
    @ApiOperation(value = "根据品牌名称查询")
    public Brand getBrandById(@RequestParam(value = "name", required = false) String name) {
        return brandService.getObjectByName(name);
    }

    @PostMapping("")
    @ApiOperation(value = "保存品牌")
    public Result save(Brand brand) {
        try {
            brandService.saveObject(brand);
            return new Result(true, "添加品牌成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    @DeleteMapping("")
    @ApiOperation(value = "批量删除品牌", notes = "传入ID集")
    public Result remove(@RequestBody Long... ids) {
        try {
            brandService.removeObjects(ids);
            return new Result(true, "删除品牌成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    @PutMapping("")
    @ApiOperation(value = "更新品牌")
    public Result update(Brand brand) {
        try {
            brandService.updateObject(brand);
            return new Result(true, "更新品牌成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }
}
