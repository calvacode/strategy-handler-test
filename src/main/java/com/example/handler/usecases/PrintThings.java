package com.example.handler.usecases;

import com.example.handler.domains.PrintType;
//import com.example.handler.handler.StrategyHandler;
import com.example.handler.handler.StrategyHandler;
import com.example.handler.handler.StrategyType;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrintThings {

    private final StrategyHandler<Print> printHandler;

    private final List<Print> printList;

    @EventListener(ApplicationReadyEvent.class)
    public void print() {
        System.out.println("Iniciando handler pré mapeado -> " + Calendar.getInstance().getTimeInMillis());
        printHandler.getImpl(PrintType.G.name()).ifPresent(Print::print);
        System.out.println("Finalizando pré mapeado -> " + Calendar.getInstance().getTimeInMillis());
    }

    @EventListener(ApplicationReadyEvent.class)
    public void print2(){
        System.out.println("Iniciando nao mapeado -> " + Calendar.getInstance().getTimeInMillis());
        findConverter(PrintType.G)
                .ifPresent(Print::print);
        System.out.println("Finalizando nao mapeado -> " + Calendar.getInstance().getTimeInMillis());
    }

    private Optional<Print> findConverter(final PrintType printType) {
        return this.printList.stream()
                .filter(tokenConverter -> tokenConverter.getClass()
                        .isAnnotationPresent(StrategyType.class))
                .filter(tokenConverter -> printType.name().equals(tokenConverter.getClass().getAnnotation(StrategyType.class).types()))
                .findFirst();
    }
}
