package com.example.brulette.BetTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que define las columnas
 */
public enum Columna implements BetType {
    PRIMERA(1, 4, 7,10, 13, 16, 19, 22, 25, 28, 31, 34),
    SEGUNDA(2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35),
    TERCERA(3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36);

    private List<Integer> affected;

    private Columna(int... num) {
        this.affected = new ArrayList<Integer>();
        for (int n: num) this.affected.add(n);
    }

    @Override public List<Integer> getAlcance() { return this.affected; }
}