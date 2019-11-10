package com.lepao.comsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient    //打开eurekaclient
@EnableFeignClients(basePackages="com.lepao.api.service")
@ComponentScan(basePackages={"com.lepao.comsumer","com.lepao.api.service"})//这里不许把断路器的component模块添加进去
@EnableHystrixDashboard  //开启熔断监视器
public class ComsumerApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ComsumerApplication.class, args);
    }
}
