package com.oysq.cloud.gateway.predicate;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class ContainRoutePredicateFactory extends AbstractRoutePredicateFactory<ContainConfig> {

    public ContainRoutePredicateFactory() {
        super(ContainConfig.class);
    }

    /**
     * 该方法的返回体是一个 Predicate 函数式接口，有点像策略模式
     * @param config
     * @return
     */
    @Override
    public Predicate<ServerWebExchange> apply(ContainConfig config) {
        return exchange -> {
            String rawPath = exchange.getRequest().getURI().getRawPath();
            return rawPath.contains(config.getContent());
        };
    }

    /**
     * 通过该方法将yml文件的谓词与配置类的字段一一对应起来
     * @return
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("content");
    }
}
