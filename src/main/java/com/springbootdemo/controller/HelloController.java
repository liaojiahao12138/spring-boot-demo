package com.springbootdemo.controller;

import com.springbootdemo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 有关注解资料可查看：https://blog.csdn.net/u010412719/article/details/69710480
 * @RestController = @ResponseBody和@Controller
 * 包含响应请求和使用模版，默认类中方法以json格式返回
 * @RequestMapping 处理请求路径，可以使用在方法上或者使用在类上
 * 试生效的范围不一样
 */
@Controller
public class HelloController {
    private List<User> getUserList(){
        List<User> list=new ArrayList<User>();
        User user1=new User("aaa",19,"123456");
        User user2=new User("bbb",50,"123563");
        User user3=new User("ccc",66,"666666");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return list;
    }
    @RequestMapping("/hello")
    public String hello(ModelMap map){
        map.addAttribute("message","http://www.baidu.com");
//        这里需要返回模版的名称
        map.addAttribute("userName","huqing");
        map.addAttribute("flag","no");
        map.addAttribute("users", getUserList());
        map.addAttribute("type", "link");
        map.addAttribute("pageId", "springcloud/2017/09/11/");
        map.addAttribute("img", "http://www.ityouknow.com/assets/images/neo.jpg");

        return "hello";
    }
}
