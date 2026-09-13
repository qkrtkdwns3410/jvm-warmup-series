package dev.warmup.core;

public final class Calculator {
    public long calculate(int size) {
        long result = 0;
        for (int i = 0; i < size; i++) {
            result += (long) i * i;
        }
        return result;
    }
}
