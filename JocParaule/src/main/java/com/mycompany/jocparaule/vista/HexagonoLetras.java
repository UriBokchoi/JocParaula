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
import com.mycompany.jocparaule.model.Letra;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class HexagonoLetras extends JPanel {
    private Juego juego;

    public HexagonoLetras(Juego juego) {
        this.juego = juego;
        setPreferredSize(new Dimension(300, 300));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int centroX = getWidth() / 2;
        int centroY = getHeight() / 2;
        int radio = 50;

        // Hexágono central
        Path2D hexagonoCentral = crearHexagono(centroX, centroY, radio);
        g2d.setColor(Color.YELLOW);
        g2d.fill(hexagonoCentral);
        g2d.setColor(Color.BLACK);
        g2d.draw(hexagonoCentral);
        g2d.setFont(new Font("Arial", Font.BOLD, 24));
        g2d.drawString(String.valueOf(juego.obtenerLetraCentral().obtenerCaracter()).toUpperCase(), centroX - 10, centroY + 10);

        // Hexágonos periféricos
        int numPerifericas = juego.obtenerLetras().size() - 1;
        double angulo = 2 * Math.PI / numPerifericas;
        int indicePeriferico = 0;

        for (Letra letra : juego.obtenerLetras()) {
            if (!letra.esCentral()) {
                double theta = angulo * indicePeriferico;
                int x = (int) (centroX + 2 * radio * Math.cos(theta));
                int y = (int) (centroY + 2 * radio * Math.sin(theta));
                Path2D hexagono = crearHexagono(x, y, radio);
                g2d.setColor(Color.LIGHT_GRAY);
                g2d.fill(hexagono);
                g2d.setColor(Color.BLACK);
                g2d.draw(hexagono);
                g2d.drawString(String.valueOf(letra.obtenerCaracter()).toUpperCase(), x - 10, y + 10);
                indicePeriferico++;
            }
        }
    }

    private Path2D crearHexagono(int x, int y, int radio) {
        Path2D hexagono = new Path2D.Double();
        for (int i = 0; i < 6; i++) {
            double anguloRad = 2 * Math.PI / 6 * i + Math.PI / 6;
            double px = x + radio * Math.cos(anguloRad);
            double py = y + radio * Math.sin(anguloRad);
            if (i == 0) hexagono.moveTo(px, py);
            else hexagono.lineTo(px, py);
        }
        hexagono.closePath();
        return hexagono;
    }

    public void actualizarJuego(Juego juego) {
        this.juego = juego;
        repaint();
    }
}