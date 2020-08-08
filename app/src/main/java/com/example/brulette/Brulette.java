package com.example.brulette;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.brulette.BetTypes.BetType;
import com.example.brulette.BetTypes.Color;
import com.example.brulette.BetTypes.Columna;
import com.example.brulette.BetTypes.DesdeHasta;
import com.example.brulette.BetTypes.Docena;
import com.example.brulette.BetTypes.Paridad;

/**
 * Main class of the application, here we are going to be able to add roulettes
 */
public class Brulette {

    private static Brulette app;    //Instance of the app
    private File file = null;       //File to store things
    private Roulette roulettes;     //roulettes of the application

    /**
     * Constructor, private because we are using the singleton pattern
     */
    private Brulette() {
        try {
            Context c = MainActivity.getContext();
            File file = new File(c.getFilesDir().getPath().toString()+"/ruleta.txt");
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    throw new IOException("Unable to create file");
                }
            }
            if (this.file == null) this.file = file;

            ObjectInputStream cargar = new ObjectInputStream(new FileInputStream(this.file));
            Roulette rouletteSaved = (Roulette) cargar.readObject();
            this.roulettes = rouletteSaved;
            cargar.close();
        } catch (Exception e) {
            e.printStackTrace();
            this.roulettes = new Roulette("Your roulette");
        }
    }

    /**
     * Metodo para añadir una ruleta a la app
     *
     * @param r Ruleta a añadir
     * @return True si se ha añadido, False si no.
     */
    /*public boolean addRoulette(Roulette  r){
        if (r == null) return false;

        this.roulettes.add(r);
        return true;
    }*/

    /**
     * Metodo para remover una ruleta de la app
     *
     * @param r Nombre de la ruleta a remover
     * @return True si se ha borrado, false if not
     * @throws NameException Exception thrown cuando la ruleta con ese nombre no esta en la app
     */
    /*public boolean delRoulette(String r) throws  NameException {
        if (r == null) return false;
        else if (!this.roulettes.contains(r)) throw new NameException("La ruleta con el nombre "+r+" no esta en la app");

        this.roulettes.remove(r);
        return true;
    }*/

    /**
     * Method to get the roulette
     *
     * @return Roulette of the app
     */
    public Roulette getRoulette() { return this.roulettes; }

    /**
     * Static method to get an instance of the application
     *
     * @return Instance of the application
     */
    public static Brulette getBrulette() {
        if (app == null) {
            app = new Brulette();
        }
        return app;
    }

    /**
     * Method to store all the info of the app
     */
    public void guardar() {
        try {
            Context c = MainActivity.getContext();
            File file = new File(c.getFilesDir().getPath().toString()+"/ruleta.txt");
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    throw new IOException("Unable to create file");
                }
            }
            if (this.file == null) this.file = file;

            ObjectOutputStream guardar = new ObjectOutputStream(new FileOutputStream(this.file));
            guardar.writeObject(this.roulettes);
            guardar.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reset() {
        this.roulettes.resetValues();
        this.roulettes.resetLastResults();
    }
}