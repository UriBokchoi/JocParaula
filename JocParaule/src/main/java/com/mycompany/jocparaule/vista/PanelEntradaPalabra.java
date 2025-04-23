/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jocparaule.vista;

/**
 *
 * @author oriol
 */

import java.awt.FlowLayout;
import javax.swing.*;

public class PanelEntradaPalabra extends JPanel {
    private JTextField campoPalabra;
    private JButton botonEnviar;
    private JButton botonNuevaPartida;

    public PanelEntradaPalabra() {
        setLayout(new FlowLayout());
        campoPalabra = new JTextField(10);
        botonEnviar = new JButton("Validar");
        botonNuevaPartida = new JButton("Nueva Partida");

        add(new JLabel("Palabra: "));
        add(campoPalabra);
        add(botonEnviar);
        add(botonNuevaPartida);
    }

    public JTextField obtenerCampoPalabra() {
        return campoPalabra;
    }

    public JButton obtenerBotonEnviar() {
        return botonEnviar;
    }

    public JButton obtenerBotonNuevaPartida() {
        return botonNuevaPartida;
    }

    public void limpiarCampo() {
        campoPalabra.setText("");
    }
}