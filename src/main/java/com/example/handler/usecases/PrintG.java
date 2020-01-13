package com.example.handler.usecases;

import com.example.handler.handler.StrategyType;
import org.springframework.stereotype.Service;

@Service
@StrategyType(types = "G")
public class PrintG implements Print {
    @Override
    public void print() {
        System.out.println("printing C");
    }
}
