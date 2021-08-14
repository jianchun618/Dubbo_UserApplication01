package com.sxyh;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


/**
 * @author :自定义实现Ribbon(实现了负载均衡，无法自动移故障服务)
 */
@EnableDubbo  //开启基于注解的dubbo功能
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class UserApplciation {
    public static void main(String[] args) {
        SpringApplication.run(UserApplciation.class,args);
    }

}
