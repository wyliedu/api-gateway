package com.wylie.api_gateway;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * 通过服务路由的功能，我们在对外提供服务的时候，只需要通过暴露Zuul中配置的调用地址就可以让调用方统一的来访问我们的服务，而不需要了解具体提供服务的主机信息了。
 * @author wylie
 *
 */
@EnableZuulProxy
@SpringCloudApplication    //@SpringCloudApplication注解整合了@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker
public class ApiGatewayApp {
	
    public static void main(String[] args) {
    	new SpringApplicationBuilder(ApiGatewayApp.class).web(true).run(args);
    }
    
    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}