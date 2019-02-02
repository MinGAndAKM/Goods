package com.proaim.controller.category;

import com.proaim.entity.Category;
import com.proaim.entity.Result;
import com.proaim.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @date 2019/2/2
 */
@RestController
@RequestMapping("/category")
@Api(tags = "总分类控制器")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @ApiOperation(value = "保存分类")
    @PostMapping("")
    public Result save(Category category) {
        try {
            if (category == null) {
                return new Result(false, "发生未知错误");
            }
            categoryService.insertSelective(category);
            return new Result(true, "保存分类成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    @ApiOperation(value = "删除分类", notes = "根据分类ID")
    @DeleteMapping("")
    public Result remove(@RequestParam(value = "id", required = false) Long... ids) {
        try {
            if (ids == null) {
                return new Result(false, "发生未知错误");
            }
            for (Long id : ids) {
                categoryService.deleteByPrimaryKey(id);
            }
            return new Result(true, "删除分类成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    @ApiOperation(value = "根据分类ID更换")
    @PutMapping("")
    public Result update(Category category) {
        try {
            categoryService.updateByPrimaryKeySelective(category);
            return new Result(true, "更新分类成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    @ApiOperation(value = "查询所有分类")
    @GetMapping("")
    public List<Category> list() {
        return categoryService.selectAll();
    }

    @ApiOperation(value = "查询分类", notes = "根据分类ID")
    @GetMapping("/{id}")
    public Category get(@PathVariable(value = "id") Long id) {
        try {
            if (id == null) {
                return null;
            }
            return categoryService.selectByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
