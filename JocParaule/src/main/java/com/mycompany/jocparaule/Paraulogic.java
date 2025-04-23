package com.mycompany.jocparaule;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author oriol
 */
import com.mycompany.jocparaule.model.Juego;
import com.mycompany.jocparaule.model.Letra;
import com.mycompany.jocparaule.vista.VentanaPrincipal;
import com.mycompany.jocparaule.controlador.ControladorJuego;
import dao.FabricaDAO;



public class Paraulogic {
    public static void main(String[] args) {
        //inicializo juego, que representa la logic ay los datos
        Juego juego = new Juego(); 

        //inicializo la interfaz, y le paso el juego para poder iniciar el juego en ella
        VentanaPrincipal vista = new VentanaPrincipal(juego);
      
        //gestiona las interacciones con la base de datos
        ControladorJuego controlador = new ControladorJuego(juego, vista, FabricaDAO.obtenerPalabraDAO());
        
    }
}