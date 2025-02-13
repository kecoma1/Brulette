package com.example.brulette.BetTypes;

import java.util.ArrayList;
import java.util.List;

public enum Docena implements BetType {

    PRIMERA(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12),
    SEGUNDA(13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24),
    TERCERA(25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36);

    private List<Integer> affected;

    private Docena(int... num) {
        this.affected = new ArrayList<>();
        for (int n: num) this.affected.add(n);
    }

    @Override public List<Integer> getAlcance() { return this.affected; }
}