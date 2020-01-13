package com.example.handler.usecases;

import com.example.handler.handler.StrategyType;
import org.springframework.stereotype.Service;

@Service
@StrategyType(types = "C")
public class PrintC implements Print {
    @Override
    public void print() {
        System.out.println("printing C");
    }
}
