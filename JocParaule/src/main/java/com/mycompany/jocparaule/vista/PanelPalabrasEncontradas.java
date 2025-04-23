/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jocparaule.vista;

/**
 *
 * @author oriol
 */
import java.awt.BorderLayout;
import javax.swing.*;

public class PanelPalabrasEncontradas extends JPanel {
    private JTextArea areaPalabras;

    public PanelPalabrasEncontradas() {
        setLayout(new BorderLayout());
        areaPalabras = new JTextArea(5, 20);
        areaPalabras.setEditable(false);
        add(new JScrollPane(areaPalabras), BorderLayout.CENTER);
    }

    public void actualizarPalabras(String palabras) {
        areaPalabras.setText(palabras);
    }
}
