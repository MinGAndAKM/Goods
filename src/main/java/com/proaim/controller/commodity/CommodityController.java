package com.proaim.controller.commodity;

import com.proaim.entity.Commodity;
import com.proaim.entity.PageBean;
import com.proaim.entity.Result;
import com.proaim.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @date 2019/1/30
 */
@RestController
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    /**
     * 分页查询
     * 第一种必须带有参数,也就是说你直接输入localhost:8080/list 会报错 不会执行方法 只能输入localhost:8080/list?parentId=? 才能执行相应的方法
     * 第二种 可带参数也可不带参数  就是说你输入  localhost:8080/list  以及 localhost:8080/list?parentId=?  方法都能执行
     *
     * @param commodity 查询条件
     * @param pageCode  当前页码
     * @param pageSize  每页显示记录数
     * @return PageBean 将当前页数及每页记录数返回
     */
    @PostMapping("/getByConPage")
    public PageBean getByConPage(Commodity commodity,
                                 @RequestParam(value = "pageCode", required = false) Integer pageCode,
                                 @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        return commodityService.getByPageBean(commodity, pageCode, pageSize);
    }

    /**
     * 新增商品
     *
     * @param commodity 页面传递的JSON数据
     * @return 商品添加状态
     */
    //处理application/json Or application/xml请求的数据
    @PostMapping("/save")
    public Result save(@RequestBody Commodity commodity) {
        try {
            commodityService.saveObject(commodity);
            return new Result(true, "添加商品成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发送未知错误");
        }
    }

    /**
     * @param commodity 页面传递的JSON数据
     * @return 商品更新状态
     */
    @PostMapping("/update")
    public Result update(@RequestBody Commodity commodity) {
        try {
            commodityService.updateObject(commodity);
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
    @PostMapping("/remove")
    public Result remove(@RequestBody Long... ids) {
        try {
            commodityService.removeObjects(ids);
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
    @PostMapping("/getById")
    public Commodity getById(@RequestParam(value = "id", required = false) Long id) {
        return commodityService.getObjectById(id);
    }
}
