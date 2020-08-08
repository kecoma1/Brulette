package com.example.brulette;

import com.example.brulette.BetTypes.BetType;
import com.example.brulette.BetTypes.Color;
import com.example.brulette.BetTypes.Columna;
import com.example.brulette.BetTypes.DesdeHasta;
import com.example.brulette.BetTypes.Docena;
import com.example.brulette.BetTypes.Paridad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Roulette implements Serializable {

    private String name;
    private List<Integer> lastResults;
    private Collection<BetType> types;      //Types of bets in a roulette
    private Map<Integer, Integer> values;

    public Roulette(String name) {
        this.name = name;
        this.lastResults = new ArrayList<>();
        this.types = new ArrayList<BetType>();
        this.values = new HashMap<>();

        for (int i = 0; i < 37; i++) this.values.put(i, 0);

        this.types.add(Columna.PRIMERA);
        this.types.add(Columna.SEGUNDA);
        this.types.add(Columna.TERCERA);
        this.types.add(Color.NEGRO);
        this.types.add(Color.ROJO);
        this.types.add(Paridad.PAR);
        this.types.add(Paridad.IMPAR);
        this.types.add(Docena.PRIMERA);
        this.types.add(Docena.SEGUNDA);
        this.types.add(Docena.TERCERA);
        this.types.add(DesdeHasta.UNO18);
        this.types.add(DesdeHasta.DIECINUEVE36);
    }

    public List<Integer> getLastResults() { return this.lastResults; }
    public Map<Integer, Integer> getValues() { return  this.values; }
    public void resetValues() {
        this.values = new HashMap<>();
        for (int i = 0; i < 37; i++) this.values.put(i, 0);
    }
    public void resetLastResults() { this.lastResults = new ArrayList<>(); }

    public void addResult(int n) {
        this.lastResults.add(n);
        int previousTimes = this.values.get(n);
        this.values.put(n,previousTimes+1);
    }

    public double getDocenaData(Docena d) {
        double times = 0;
        double result = 0;

        for (int n: this.lastResults) {
            if (d.getAlcance().contains(n)) times++;
        }

        if (this.lastResults.size() == 0) return 0;
        double b = this.lastResults.size();
        result = times/b;

        return result*100;
    }

    public int getDocenaTimes(Docena d) {
        int times = 0;

        for (int n: this.lastResults) {
            if (d.getAlcance().contains(n)) times++;
        }

        return times;
    }

    public double getNumeroData(int n) {
        double result = 0;

        if (this.lastResults.size() == 0) return 0;
        double a = this.values.get(n);
        double b = this.lastResults.size();
        result = a/b;

        return result*100;
    }

    public int getNumeroTimes(int n) { return this.values.get(n); }

    public double getColumnaData(Columna d) {
        int times = 0;
        double result = 0;

        for (int n: this.lastResults) {
            if (d.getAlcance().contains(n)) times++;
        }

        if (this.lastResults.size() == 0) return 0;
        double b = this.lastResults.size();
        result = times/b;

        return result*100;
    }

    public int getColumnaTimes(Columna d) {
        int times = 0;

        for (int n: this.lastResults) {
            if (d.getAlcance().contains(n)) times++;
        }

        return times;
    }

    public double getColorData(Color c) {
        int times = 0;
        double result = 0;

        for (int n: this.lastResults) {
            if (c.getAlcance().contains(n)) times++;
        }

        if (this.lastResults.size() == 0) return 0;
        double b = this.lastResults.size();
        result = times/b;

        return result*100;
    }

    public double getParidadData(Paridad p) {
        int times = 0;
        double result = 0;

        for (int n: this.lastResults) {
            if (p.getAlcance().contains(n)) times++;
        }

        if (this.lastResults.size() == 0) return 0;
        double b = this.lastResults.size();
        result = times/b;

        return result*100;
    }

    public int getParidadTimes(Paridad p) {
        int times = 0;

        for (int n: this.lastResults) {
            if (p.getAlcance().contains(n)) times++;
        }

        return times;
    }

    public double getDesdeHastaData(DesdeHasta dh) {
        int times = 0;
        double result = 0;

        for (int n: this.lastResults) {
            if (dh.getAlcance().contains(n)) times++;
        }

        if (this.lastResults.size() == 0) return 0;
        double b = this.lastResults.size();
        result = times/b;

        return result*100;
    }

    public int getDesdeHastaTimes(DesdeHasta dh) {
        int times = 0;

        for (int n: this.lastResults) {
            if (dh.getAlcance().contains(n)) times++;
        }

        return times;
    }
}