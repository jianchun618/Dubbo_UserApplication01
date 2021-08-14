package com.sxyh.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sxyh.entities.User;
import com.sxyh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author :自定义实现Ribbon 的基本功能
 *

 */
@RestController
@RequestMapping(value = "/usermanager")
public class UserController {

//    @Autowired
    @Reference
    private IUserService iUserService;

    @GetMapping(value = "/queryUserById")
    public User queryUserById(@RequestParam(value = "id") Integer id){
        User user = iUserService.queryById(id);
        return user;
    }

}
