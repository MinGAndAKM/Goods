package com.proaim.controller.goods;

import com.proaim.entity.Goods;
import com.proaim.entity.PageBean;
import com.proaim.entity.Result;
import com.proaim.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @date 2019/1/25
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 分页查询
     * 第一种必须带有参数,也就是说你直接输入localhost:8080/list 会报错 不会执行方法 只能输入localhost:8080/list?parentId=? 才能执行相应的方法
     * 第二种 可带参数也可不带参数  就是说你输入  localhost:8080/list  以及 localhost:8080/list?parentId=?  方法都能执行
     *
     * @param goods    查询条件
     * @param pageCode 当前页
     * @param pageSize 每页显示的记录数
     * @return PageBean
     */
    @PostMapping("/findByConPage")
    public PageBean findByConPage(Goods goods,
                                  @RequestParam(value = "pageCode", required = false) Integer pageCode,
                                  @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        return goodsService.findByPage(goods, pageCode, pageSize);
    }

    /**
     * 新增商品
     *
     * @param goods 页面传递的JSON数据
     * @return 商品添加状态
     */
    //处理application/json Or application/xml请求的数据
    @PostMapping("/create")
    public Result create(@RequestBody Goods goods) {
        try {
            goodsService.create(goods);
            return new Result(true, "添加商品成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    /**
     * @param goods 页面传递的JSON数据
     * @return 商品更新状态
     */
    @PostMapping("/update")
    public Result update(@RequestBody Goods goods) {
        try {
            goodsService.update(goods);
            return new Result(true, "更新商品成功");
        } catch (Exception e) {
            return new Result(false, "发生未知错误");
        }
    }

    /**
     * 批量删除数据
     *
     * @param ids 商品ID集
     * @return 商品删除状态
     */
    @PostMapping("/delete")
    public Result delete(@RequestBody Long... ids) {
        try {
            goodsService.delete(ids);
            return new Result(true, "删除商品成功");
        } catch (Exception e) {
            return new Result(false, "发生未知错误");
        }
    }

    /**
     * 根据id查询
     *
     * @param id 商品ID
     * @return 返回List<Goods> Goods对象集
     */
    @PostMapping("/findById")
    public List<Goods> findById(@RequestParam(value = "id", required = false) Long id) {
        return goodsService.findById(id);
    }

}
