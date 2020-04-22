package com.ztx.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.lang.annotation.Annotation;

/**
 * 自定义拦截器，处理拦截请求
 */
@Slf4j
@Component
public class MyLogGetWayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //自定义拦截逻辑
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (username == null) {
            log.info("参数为空");
            //返回状态码和提示信息
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();//标示为请求处理结束
        }
        return chain.filter(exchange);//传递给其他过滤器连调
    }


    @Override
    public int getOrder() {//过滤器链优先级顺序
        return 0;
    }
}
