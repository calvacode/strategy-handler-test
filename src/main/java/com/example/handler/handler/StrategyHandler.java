package com.example.handler.handler;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.Arrays.stream;

public class StrategyHandler<T> {
    private Map<String, T> map;

    public StrategyHandler(final Collection<T> impls) {
        this.map = createMap(impls);
    }

    public Optional<T> getImpl(final String type) {
        return Optional.ofNullable(map.get(type));
    }


    private Map<String, T> createMap(final Collection<T> impl) {
        final Map<String, T> map = new HashMap<>();

        impl.forEach(t -> stream(t.getClass().getAnnotationsByType(StrategyType.class))
                .findFirst()
                .ifPresent(s -> map.put(s.types(), t)));
        return map;
    }

//    private Map<String, T> createMap(final Collection<T> impl) {
//        final Map<String, T> map = new HashMap<>();
//
//        impl.forEach(t -> stream(t.getClass().getAnnotationsByType(StrategyType.class))
//                .findFirst()
//                .ifPresent(genericHandler -> stream(genericHandler.types())
//                        .forEach(s -> map.put(s, t))));
//        return map;
//    }
}
