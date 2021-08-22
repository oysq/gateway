package com.oysq.cloud.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

@Slf4j
@Component
public class PreLogGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {
    @Override
    public GatewayFilter apply(NameValueConfig config) {
        return (exchange, chain) -> {
            log.info("PreLog 日志打印: {}, {}", config.getName(), config.getValue());
            ServerHttpRequest serverHttpRequest = exchange.getRequest().mutate().build();
            ServerWebExchange serverWebExchange = exchange.mutate().request(serverHttpRequest).build();
            return chain.filter(serverWebExchange);
        };
    }
}
