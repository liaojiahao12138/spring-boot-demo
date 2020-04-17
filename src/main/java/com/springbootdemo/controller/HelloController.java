package com.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 有关注解资料可查看：https://blog.csdn.net/u010412719/article/details/69710480
 * @RestController = @ResponseBody和@Controller
 * 包含响应请求和使用模版，默认类中方法以json格式返回
 * @RequestMapping 处理请求路径，可以使用在方法上或者使用在类上
 * 试生效的范围不一样
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(String name){
        return "Hello World," + name;
    }
}
