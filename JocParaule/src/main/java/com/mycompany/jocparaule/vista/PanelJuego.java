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

public class PanelJuego extends JPanel {
    private HexagonoLetras hexagono;
    private PanelEntradaPalabra panelEntrada;

    public PanelJuego(Juego juego) {
        setLayout(new BorderLayout());
        hexagono = new HexagonoLetras(juego);
        panelEntrada = new PanelEntradaPalabra();

        add(hexagono, BorderLayout.CENTER);
        add(panelEntrada, BorderLayout.SOUTH);
    }

    public HexagonoLetras obtenerHexagono() {
        return hexagono;
    }

    public PanelEntradaPalabra obtenerPanelEntrada() {
        return panelEntrada;
    }
}
