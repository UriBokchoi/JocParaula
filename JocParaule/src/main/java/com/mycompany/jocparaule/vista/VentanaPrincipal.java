/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jocparaule.vista;
/**
 *
 * @author oriol
 */


import com.mycompany.jocparaule.model.Juego;
import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private PanelJuego panelJuego;
    private PanelPuntuacion panelPuntuacion;
    private PanelPalabrasEncontradas panelPalabrasEncontradas;
    private JButton botonTema;

    public VentanaPrincipal(Juego juego) {
        setTitle("Paraulogic");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelJuego = new PanelJuego(juego);
        panelPuntuacion = new PanelPuntuacion();
        panelPalabrasEncontradas = new PanelPalabrasEncontradas();
        botonTema = new JButton("Cambiar Tema");

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(panelPuntuacion, BorderLayout.WEST);
        panelSuperior.add(botonTema, BorderLayout.EAST);

        add(panelSuperior, BorderLayout.NORTH);
        add(panelJuego, BorderLayout.CENTER);
        add(panelPalabrasEncontradas, BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public PanelJuego obtenerPanelJuego() {
        return panelJuego;
    }

    public PanelPuntuacion obtenerPanelPuntuacion() {
        return panelPuntuacion;
    }

    public PanelPalabrasEncontradas obtenerPanelPalabrasEncontradas() {
        return panelPalabrasEncontradas;
    }

    public JButton obtenerBotonTema() {
        return botonTema;
    }

    public void alternarTema() {
        Color bg = getContentPane().getBackground();
        if (bg.equals(Color.WHITE) || bg.equals(new Color(0, 0, 0, 0))) {
            getContentPane().setBackground(Color.DARK_GRAY);
            actualizarColorComponentes(Color.WHITE);
        } else {
            getContentPane().setBackground(Color.WHITE);
            actualizarColorComponentes(Color.BLACK);
        }
        repaint();
    }

    private void actualizarColorComponentes(Color color) {
        panelJuego.setForeground(color);
        panelPuntuacion.setForeground(color);
        panelPalabrasEncontradas.setForeground(color);
        botonTema.setForeground(color);
    }
}