package com.proaim.controller.carousel;

import com.proaim.entity.CarouselImage;
import com.proaim.entity.Result;
import com.proaim.service.CarouselImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @date 2019/2/2
 */
@RestController
@RequestMapping("/carouselImage")
@Api(tags = "轮播图片控制器")
public class CarouselImageController {
    @Autowired
    private CarouselImageService carouselImageService;

    @ApiOperation(value = "保存轮播图片图片")
    @PostMapping("")
    public Result save(CarouselImage carouselImage) {
        try {
            if (carouselImage == null) {
                return new Result(false, "发生未知错误");
            }
            carouselImageService.insertSelective(carouselImage);
            return new Result(true, "保存轮播图片成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    @ApiOperation(value = "删除轮播图片", notes = "根据轮播图片ID")
    @DeleteMapping("")
    public Result remove(@RequestParam(value = "id", required = false) Long... ids) {
        try {
            if (ids == null) {
                return new Result(false, "发生未知错误");
            }
            for (Long id : ids) {
                carouselImageService.deleteByPrimaryKey(id);
            }
            return new Result(true, "删除轮播图片成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    @ApiOperation(value = "查询所有轮播图片", notes = "根据轮播ID查询")
    @GetMapping("/{carouselId}")
    public List<CarouselImage> list(@PathVariable Long carouselId) {
        return carouselImageService.selectByCarouselId(carouselId);
    }

}
