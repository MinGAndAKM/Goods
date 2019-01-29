package com.proaim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页控制器
 *
 * @date 2019/1/24
 */
@Controller
public class HomeController {
    /**
     * 系统首页
     *
     * @return View templates/home/index.html
     */
    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "home/index";
    }

    /**
     * 商品列表页
     *
     * @return View templates/site/goods.html
     */
    @GetMapping(value = {"/goods"})
    public String user() {
        return "site/goods";
    }
}
