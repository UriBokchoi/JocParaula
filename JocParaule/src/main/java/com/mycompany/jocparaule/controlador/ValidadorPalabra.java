/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jocparaule.controlador;

/**
 *
 * @author oriol
 */


import dao.PalabraDAO;
import com.mycompany.jocparaule.model.Juego;
import com.mycompany.jocparaule.model.Palabra;

public class ValidadorPalabra {
    private Juego juego;
    private PalabraDAO palabraDAO;

    public ValidadorPalabra(Juego juego, PalabraDAO palabraDAO) {
        this.juego = juego;
        this.palabraDAO = palabraDAO;
    }

    public String validar(String entrada) {
        if (entrada.trim().isEmpty()) {
            return "¡Introduce una palabra!";
        }

        Palabra palabra = new Palabra(entrada);
        char[] letrasPermitidas = juego.obtenerLetrasComoArreglo();

        if (palabra.obtenerLongitud() < 3) {
            return "¡La palabra debe tener al menos 3 letras!";
        }
        if (!palabra.contieneLetra(juego.obtenerLetraCentral().obtenerCaracter())) {
            return "¡La palabra debe contener la letra central!";
        }
        if (!palabra.usaSoloLetrasPermitidas(letrasPermitidas)) {
            return "¡Solo puedes usar las letras del hexágono!";
        }
        if (!palabra.usaLetrasUnicas()) {
            return "¡Cada letra solo se puede usar una vez!";
        }
        if (!palabraDAO.esPalabraValida(palabra.obtenerPalabra())) {
            return "¡La palabra no existe en el diccionario!";
        }
        return null; // Palabra válida
    }

    public boolean esParaulogic(Palabra palabra) {
        return palabra.obtenerLongitud() == 7;
    }
}
