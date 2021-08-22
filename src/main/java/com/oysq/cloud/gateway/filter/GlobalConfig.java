package com.oysq.cloud.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GlobalConfig {

    @Order(0)
    @Bean
    public GlobalFilter filter1() {
        return (exchange, chain) -> {
            log.info("进入 GlobalFilter");
            return chain.filter(exchange);
        };
    }

}
