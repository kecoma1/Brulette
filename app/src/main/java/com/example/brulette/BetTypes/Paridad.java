package com.example.brulette.BetTypes;

import java.util.ArrayList;
import java.util.List;

public enum Paridad implements BetType {

    PAR(2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36),
    IMPAR(1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35);

    private List<Integer> affected;

    private Paridad(int... num) {
        this.affected = new ArrayList<>();
        for (int n: num) this.affected.add(n);
    }

    @Override public List<Integer> getAlcance() { return this.affected; }
}