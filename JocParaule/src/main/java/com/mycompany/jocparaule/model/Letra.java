/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jocparaule.model;

/**
 *
 * @author oriol
 */

public class Letra {
    private char caracter;
    private boolean esCentral;

    public Letra(char caracter, boolean esCentral) {
        this.caracter = caracter;
        this.esCentral = esCentral;
    }

    public char obtenerCaracter() {
        return caracter;
    }

    public boolean esCentral() {
        return esCentral;
    }
}
