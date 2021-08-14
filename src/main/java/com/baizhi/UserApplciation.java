package com.baizhi;

import com.baizhi.urlinterceptors.URLInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author :自定义实现Ribbon(实现了负载均衡，无法自动移故障服务)
 */
@SpringBootApplication
public class UserApplciation {
    public static void main(String[] args) {
        SpringApplication.run(UserApplciation.class,args);
    }

    /**
     * 对RestTemplate 做加强
     * @param servers
     * @return
     */
    @Bean
    public RestTemplate restTemplate(@Value("${servers}")List<String> servers){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new URLInterceptor(servers));
        return restTemplate;
    }
}
