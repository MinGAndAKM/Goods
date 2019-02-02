package com.proaim.controller.carousel;

import com.proaim.entity.Carousel;
import com.proaim.entity.Result;
import com.proaim.service.CarouselService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @date 2019/2/2
 */
@RestController
@RequestMapping("/carousel")
@Api(tags = "轮播控制器")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;

    @ApiOperation(value = "保存轮播")
    @PostMapping("")
    public Result save(Carousel carousel) {
        try {
            if (carousel == null) {
                return new Result(false, "发生未知错误");
            }
            carouselService.insertSelective(carousel);
            return new Result(true, "保存轮播成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    @ApiOperation(value = "删除轮播", notes = "根据轮播ID")
    @DeleteMapping("")
    public Result remove(@RequestParam(value = "id", required = false) Long... ids) {
        try {
            if (ids == null) {
                return new Result(false, "发生未知错误");
            }
            for (Long id : ids) {
                carouselService.deleteByPrimaryKey(id);
            }
            return new Result(true, "删除轮播成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    @ApiOperation(value = "根据轮播ID更换")
    @PutMapping("")
    public Result update(Carousel carousel) {
        try {
            carouselService.updateByPrimaryKeySelective(carousel);
            return new Result(true, "更新轮播成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    @ApiOperation(value = "查询所有轮播",notes = "按照order_commodity字段0、1、2排序的先后顺序显示")
    @GetMapping("")
    public List<Carousel> list() {
        return carouselService.selectAll();
    }

    @ApiOperation(value = "查询轮播", notes = "根据轮播ID")
    @GetMapping("/{id}")
    public Carousel get(@PathVariable(value = "id") Long id) {
        try {
            if (id == null) {
                return null;
            }
            return carouselService.selectByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
