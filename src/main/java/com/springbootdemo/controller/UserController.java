package com.springbootdemo.controller;

import com.springbootdemo.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @RequestMapping(name ="/getUser", method = RequestMethod.POST)
    public List<User> getUser(){
        List<User> users = new ArrayList<>();
        User user1=new User();
        user1.setName("neo");
        user1.setAge(30);
        user1.setPass("neo123");
        users.add(user1);
        User user2=new User();
        user2.setName("benson");
        user2.setAge(12);
        user2.setPass("123456");
        users.add(user2);
        return users;
    }

    @RequestMapping(value = "get/{name}",method = RequestMethod.GET)
    public String findUser(@PathVariable String name){
        return name;
    }

    @RequestMapping("/saveUser")
    public void saveUser(@Valid User user, BindingResult result){
        System.out.println("user: " + user);
        if(result.hasErrors()){
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError error:allErrors) {
                System.out.println(error.getCode() + "-" + error.getDefaultMessage());
            }
        }
    }

}
