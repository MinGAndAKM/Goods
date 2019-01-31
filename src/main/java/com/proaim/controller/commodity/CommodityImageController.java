package com.proaim.controller.commodity;

import com.proaim.entity.CommodityImage;
import com.proaim.entity.Result;
import com.proaim.service.CommodityImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @date 2019/1/31
 */
@RestController
@RequestMapping("/commodityImage")
@Api(tags = "商品图片控制器")
public class CommodityImageController {
    @Autowired
    private CommodityImageService commodityImageService;

    @ApiOperation(value = "保存图片")
    @PostMapping("/image")
    public Result save(CommodityImage commodityImage) {
        try {
            commodityImageService.saveObject(commodityImage);
            return new Result(true, "保存图片成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    @ApiOperation(value = "删除图片", notes = "根据图片ID")
    @DeleteMapping("/image")
    public Result remove(@RequestParam(value = "id", required = false) Long id) {
        try {
            commodityImageService.removeObjects(id);
            return new Result(true, "删除图片成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    @ApiOperation(value = "更换图片")
    @PutMapping("/image")
    public Result update(CommodityImage commodityImage) {
        try {
            commodityImageService.updateObject(commodityImage);
            return new Result(true, "更新图片成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    @ApiOperation(value = "查询图片", notes = "根据商品ID")
    @GetMapping("/image/{commodityId}")
    public List<CommodityImage> list(@PathVariable(value = "commodityId") Long commodityId) {
        try {
            return commodityImageService.getCommodityImageByCommodityId(commodityId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
