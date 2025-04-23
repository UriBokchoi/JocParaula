/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jocparaule.model;

/**
 *
 * @author oriol
 */

import java.util.Set;

import java.util.HashSet;

public class Palabra {
    private String palabra;

    public Palabra(String palabra) {
        this.palabra = palabra.toLowerCase();
    }

    public boolean contieneLetra(char letra) {
        return palabra.indexOf(letra) != -1;
    }

    public boolean usaSoloLetrasPermitidas(char[] letrasPermitidas) {
        for (char c : palabra.toCharArray()) {
            boolean encontrada = false;
            for (char permitida : letrasPermitidas) {
                if (c == permitida) {
                    encontrada = true;
                    break;
                }
            }
            if (!encontrada) return false;
        }
        return true;
    }

    public boolean usaLetrasUnicas() {
        Set<Character> letrasUsadas = new HashSet<>();
        for (char c : palabra.toCharArray()) {
            if (letrasUsadas.contains(c)) {
                return false;
            }
            letrasUsadas.add(c);
        }
        return true;
    }

    public int obtenerLongitud() {
        return palabra.length();
    }

    public String obtenerPalabra() {
        return palabra;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Palabra otra = (Palabra) obj;
        return palabra.equals(otra.palabra);
    }

    @Override
    public int hashCode() {
        return palabra.hashCode();
    }
}
