package com.proaim.interceptor;

import com.proaim.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @date 2019/1/24
 */
// 使用切面来统一处理日志记录
@Aspect
// log.info()打印日志
@Slf4j
//@Component泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。注解的bean会被spring-mvc框架所使用。
@Component
public class MyInterceptor {

    // @Pointcut放在方法头上，定义一个可被别的方法引用的切入点表达式。
    // within 指定某些类型的全部方法执行，也可用来指定一个包。
    @Pointcut("within (com.proaim.controller..*) && !within(com.proaim.controller.admin.LoginController)")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object trackInfo(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //request.getSession().setAttribute("user", new User()); //测试，手动添加用户登录的session
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            log.error("-----------用户未登录-----------");
            attributes.getResponse().sendRedirect("/login"); // 手动转发到/login映射路径
        } else {
            log.info("-----------用户已登录-----------");
        }
        // 一定要指定Object返回值，若AOP拦截的Controller return了一个视图地址，
        // 那么本来Controller应该跳转到这个视图地址的，但是被AOP拦截了，那么原来Controller仍会执行return，但是视图地址却找不到404了
        // 切记一定要调用proceed()方法
        // proceed()：执行被通知的方法，如不调用将会阻止被通知的方法的调用，也就导致Controller中的return会404
        return joinPoint.proceed();
    }
}
