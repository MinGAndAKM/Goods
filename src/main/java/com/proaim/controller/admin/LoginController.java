package com.proaim.controller.admin;

import com.proaim.entity.Result;
import com.proaim.entity.User;
import com.proaim.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @date 2019/1/24
 */
@Slf4j
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录状态
     */
    @ResponseBody
    @RequestMapping("/login")
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password) {
        log.info("UserName：" + username + "，PassWord：" + password);
        User user = userService.findByName(username);
        if (!StringUtils.isEmpty(user) && user.getPassword().equals(password)) {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            attributes.getRequest().getSession().setAttribute("user", user);// 将登陆用户信息存入到session域对象中
            return new Result(true, username);
        }
        return new Result(false, "登录失败");
    }

    /**
     * 注销
     *
     * @return View templates/home/login.html
     */
    @GetMapping("/logout")
    public String logout() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        attributes.getRequest().getSession().removeAttribute("user");
        return "home/login";
    }

    /**
     * 注册
     *
     * @param username 用户名
     * @param password 密码
     * @return 注册状态
     */
    @ResponseBody
    @RequestMapping("/register")
    public Result register(@RequestParam("username") String username, @RequestParam("password") String password) {
        try {
            if (StringUtils.isEmpty(userService.findByName(username))) {
                userService.create(new User(username, password));
            } else {
                return new Result(false, "该用户名已被注册，请使用其他用户名");
            }
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            //将登陆用户信息存入到session域对象中
            attributes.getRequest().getSession().setAttribute("user", new User(username, password));
            return new Result(true, username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false, "发生未知错误");
    }

    /**
     * 登录页
     *
     * @return View templates/home/login.html
     */
    @GetMapping("/login")
    public String login() {
        return "home/login";
    }

    /**
     * 注册页面
     *
     * @return View templates/home/register.html
     */
    @GetMapping("/register")
    public String register() {
        return "home/register";
    }


}
