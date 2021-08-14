package com.baizhi.controller;

import com.baizhi.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
/**
 * @author :自定义实现Ribbon 的基本功能
 *

 */
@RestController
@RequestMapping(value = "/usermanager")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/queryUserById")
    public User queryUserById(@RequestParam(value = "id") Integer id){
//        String[] urls={
//                "http://localhost:8888/formUserManager/queryUserById?id={id}",
//                "http://localhost:8889/formUserManager/queryUserById?id={id}"
//        };
//        int randomIndex = new Random().nextInt(urls.length);

        String url="http://USER-SERVER/FormUserManager/queryById?id={id}";
        return restTemplate.getForObject(url,User.class,id);
    }

}
