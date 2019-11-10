package com.lepao.comsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.lepao.myRibbion.MyRibbon;

/**
 * Hello world!
 *
 */
@EnableHystrix   //开启熔断器
@SpringBootApplication
@EnableEurekaClient    //打开eurekaclient
@RibbonClient(name="PROVIDER7001",configuration=MyRibbon.class) //使用自定义的ribbon规则
public class ComsumerApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ComsumerApplication.class, args);
    }
}
