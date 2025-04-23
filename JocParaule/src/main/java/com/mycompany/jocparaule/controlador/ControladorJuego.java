/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jocparaule.controlador;

/**
 *
 * @author oriol
 */
import com.mycompany.jocparaule.model.Juego;
import com.mycompany.jocparaule.model.Palabra;
import com.mycompany.jocparaule.vista.VentanaPrincipal;
import javax.swing.*;

import dao.PalabraDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorJuego {
    private Juego juego;
    private VentanaPrincipal vista;
    private ValidadorPalabra validador;

    public ControladorJuego(Juego juego, VentanaPrincipal vista, PalabraDAO palabraDAO) {
        this.juego = juego;
        this.vista = vista;
        this.validador = new ValidadorPalabra(juego, palabraDAO);

        // Listeners
        vista.obtenerPanelJuego().obtenerPanelEntrada().obtenerBotonEnviar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarPalabra(vista.obtenerPanelJuego().obtenerPanelEntrada().obtenerCampoPalabra().getText());
            }
        });

        vista.obtenerPanelJuego().obtenerPanelEntrada().obtenerBotonNuevaPartida().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarNuevaPartida();
            }
        });

        vista.obtenerBotonTema().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.alternarTema();
            }
        });
    }

    private void validarPalabra(String entrada) {
        String error = validador.validar(entrada);
        if (error != null) {
            JOptionPane.showMessageDialog(vista, error);
        } else {
            Palabra palabra = new Palabra(entrada);
            boolean esParaulogic = validador.esParaulogic(palabra);
            juego.agregarPalabraEncontrada(palabra, esParaulogic);
            actualizarVista();
            vista.obtenerPanelJuego().obtenerPanelEntrada().limpiarCampo();
        }
    }

    private void iniciarNuevaPartida() {
        juego.reiniciar();
        vista.obtenerPanelJuego().obtenerHexagono().actualizarJuego(juego);
        actualizarVista();
    }

    private void actualizarVista() {
        vista.obtenerPanelPuntuacion().actualizarPuntuacion(juego.obtenerPuntuacion().obtenerPuntos());
        StringBuilder textoPalabras = new StringBuilder();
        for (Palabra p : juego.obtenerPalabrasEncontradas()) {
            textoPalabras.append(p.obtenerPalabra()).append("\n");
        }
        vista.obtenerPanelPalabrasEncontradas().actualizarPalabras(textoPalabras.toString());
    }
}