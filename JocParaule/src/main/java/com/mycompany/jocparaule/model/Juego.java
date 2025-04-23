/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jocparaule.model;

/**
 *
 * @author oriol
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Juego {
    private List<Letra> letras;
    private Letra letraCentral;
    private List<Palabra> palabrasEncontradas;
    private Puntuacion puntuacion;
    private static final String VOCALES = "aeiou";

    public Juego() {
        //se instancia en Paraulogic.java
        letras = new ArrayList<>();
        palabrasEncontradas = new ArrayList<>();
        puntuacion = new Puntuacion();
        generarLetras();
    }

    private void generarLetras() {
        
        
        Random random = new Random();
        char[] todasLetras = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int contadorVocales = 0;
        int contadorConsonantes = 0;

        //se elige una letra central que debe estar en todas las palabras
        char central = todasLetras[random.nextInt(todasLetras.length)];
        letraCentral = new Letra(central, true);
        letras.add(letraCentral);
        if (VOCALES.indexOf(central) != -1) contadorVocales++;
        else contadorConsonantes++;

        // Genera 6 letras, 2 vocales y 4 consonantes, y se almazenan en una lista de objetos Letra que esta en el modelo
        while (letras.size() < 7) {
            char letra = todasLetras[random.nextInt(todasLetras.length)];
            if (VOCALES.indexOf(letra) != -1 && contadorVocales < 2) {
                letras.add(new Letra(letra, false));
                contadorVocales++;
            } else if (VOCALES.indexOf(letra) == -1 && contadorConsonantes < 4) {
                letras.add(new Letra(letra, false));
                contadorConsonantes++;
            } else if (contadorVocales >= 2 && contadorConsonantes >= 4) {
                letras.add(new Letra(letra, false));
            }
        }
    }

    public void agregarPalabraEncontrada(Palabra palabra, boolean esParaulogic) {
        if (!palabrasEncontradas.contains(palabra)) {
            palabrasEncontradas.add(palabra);
            puntuacion.agregarPuntos(palabra.obtenerLongitud(), esParaulogic);
        }
    }

    public char[] obtenerLetrasComoArreglo() {
        char[] arregloLetras = new char[letras.size()];
        for (int i = 0; i < letras.size(); i++) {
            arregloLetras[i] = letras.get(i).obtenerCaracter();
        }
        return arregloLetras;
    }

    public List<Letra> obtenerLetras() {
        return letras;
    }

    public Letra obtenerLetraCentral() {
        return letraCentral;
    }

    public Puntuacion obtenerPuntuacion() {
        return puntuacion;
    }

    public List<Palabra> obtenerPalabrasEncontradas() {
        return palabrasEncontradas;
    }

    public void reiniciar() {
        letras.clear();
        palabrasEncontradas.clear();
        puntuacion.reiniciar();
        generarLetras();
    }
}