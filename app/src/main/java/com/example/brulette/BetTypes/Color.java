package com.example.brulette.BetTypes;

import java.util.ArrayList;
import java.util.List;

public enum Color implements BetType{
    ROJO(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36),
    NEGRO(2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35);

    private List<Integer> affected;

    private Color(int... num) {
        this.affected = new ArrayList<Integer>();
        for (int n: num) this.affected.add(n);
    }

    @Override public List<Integer> getAlcance() { return this.affected; }
}