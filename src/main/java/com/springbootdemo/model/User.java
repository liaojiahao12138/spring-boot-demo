package com.springbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotEmpty(message = "姓名不能为空")
    private String name;
    @Max(value = 100,message = "年龄不能超过100岁")
    @Min(value = 18,message = "必须年满18周岁")
    private  int age;
    @NotEmpty(message = "密码不能为空")
    @Length(min = 6,message = "密码长度不能小于6位")
    private  String pass;


}
