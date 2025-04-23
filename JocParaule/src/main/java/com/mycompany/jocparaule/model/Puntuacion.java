/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jocparaule.model;

/**
 *
 * @author oriol
 */

public class Puntuacion {
    private int puntos;

    public void agregarPuntos(int longitudPalabra, boolean esParaulogic) {
        int puntosBase;
        switch (longitudPalabra) {
            case 3: puntosBase = 1; break;
            case 4: puntosBase = 2; break;
            case 5: puntosBase = 3; break;
            case 6: puntosBase = 5; break;
            case 7: puntosBase = 10; break;
            default: puntosBase = 0;
        }
        if (esParaulogic) {
            puntosBase += 10; // Puntos extra por usar todas las letras
        }
        this.puntos += puntosBase;
    }

    public int obtenerPuntos() {
        return puntos;
    }

    public void reiniciar() {
        puntos = 0;
    }
}