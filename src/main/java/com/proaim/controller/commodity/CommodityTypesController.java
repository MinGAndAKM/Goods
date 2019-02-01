package com.proaim.controller.commodity;

import com.proaim.entity.CommodityTypes;
import com.proaim.entity.Result;
import com.proaim.service.CommodityTypesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @date 2019/2/1
 */
@RestController
@RequestMapping("/commodityTypes")
@Api(tags = "商品分类控制器")
public class CommodityTypesController {
    @Autowired
    private CommodityTypesService commodityTypesService;


    @ApiOperation(value = "保存分类")
    @PostMapping("/types")
    public Result save(CommodityTypes commodityTypes) {
        try {
            if (commodityTypes == null) {
                return new Result(false, "发生未知错误");
            }
            commodityTypesService.insertSelective(commodityTypes);
            return new Result(true, "保存分类成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    @ApiOperation(value = "删除分类", notes = "根据分类ID")
    @DeleteMapping("/types")
    public Result remove(@RequestParam(value = "typeId", required = false) Short... typeIds) {
        try {
            if (typeIds == null) {
                return new Result(false, "发生未知错误");
            }
            for (Short typeId : typeIds) {
                commodityTypesService.deleteByPrimaryKey(typeId);
            }
            return new Result(true, "删除分类成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    @ApiOperation(value = "根据分类ID更换")
    @PutMapping("/types")
    public Result update(CommodityTypes commodityTypes) {
        try {
            commodityTypesService.updateByPrimaryKeySelective(commodityTypes);
            return new Result(true, "更新分类成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    @ApiOperation(value = "查询所有分类")
    @GetMapping("/types")
    public List<CommodityTypes> list() {
        return commodityTypesService.selectAll();
    }

    @ApiOperation(value = "查询分类", notes = "根据分类ID")
    @GetMapping("/types/{typeId}")
    public CommodityTypes get(@PathVariable(value = "typeId") Short typeId) {
        try {
            if (typeId == null) {
                return null;
            }
            return commodityTypesService.selectByPrimaryKey(typeId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @ApiOperation(value = "总分类下的分类", notes = "根据父分类ID")
    @PostMapping("/types/{parentId}")
    public List<CommodityTypes> list(@PathVariable(value = "parentId") Long parentId) {
        try {
            if (parentId == null) {
                return null;
            }
            return commodityTypesService.listByParentId(parentId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
