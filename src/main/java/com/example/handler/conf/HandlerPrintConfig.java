package com.example.handler.conf;

import com.example.handler.handler.StrategyHandler;
import com.example.handler.usecases.Print;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

@RequiredArgsConstructor
@Configuration
public class HandlerPrintConfig {

    private final Collection<Print> prints;

    @Bean
    public StrategyHandler<Print> printHandler() {
        return new StrategyHandler<>(prints);
    }
}
