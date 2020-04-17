package com.springbootdemo;

import com.springbootdemo.model.Benson;
import com.springbootdemo.model.Peter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PropertiesTest {
    @Value("${benson.title}")
    private String title;

    @Resource
    private Benson benson;

    @Resource
    private Peter peter;

    @Test
    public void  testMore() throws Exception{
        System.out.println(benson.getTitle());
        System.out.println(benson.getDescription());
        System.out.println(peter.getTitle());
        System.out.println(peter.getDescription());
    }

    @Test
    public void testSingle(){
        Assert.assertEquals(title,"benson");
    }
}
