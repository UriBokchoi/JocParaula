/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jocparaule.vista;

/**
 *
 * @author oriol
 */

import javax.swing.*;

public class PanelPuntuacion extends JPanel {
    private JLabel etiquetaPuntuacion;

    public PanelPuntuacion() {
        etiquetaPuntuacion = new JLabel("Puntuación: 0");
        add(etiquetaPuntuacion);
    }

    public void actualizarPuntuacion(int puntos) {
        etiquetaPuntuacion.setText("Puntuación: " + puntos);
    }
}