package com.example.handler.usecases;

import com.example.handler.handler.StrategyType;
import org.springframework.stereotype.Service;

@Service
@StrategyType(types = "B")
public class PrintB implements Print {

    @Override
    public void print() {
        System.out.println("printing B e D");
    }
}
