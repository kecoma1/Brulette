package com.example.brulette.BetTypes;

import java.util.List;

/**
 * Clase para los tipos de apuesta
 */
public abstract interface BetType {

    /**
     * Method to get the numbers that the bet is going to affect
     * @return Lista con todos los números a los que la apuesta afecta
     */
    List<Integer> getAlcance();
}