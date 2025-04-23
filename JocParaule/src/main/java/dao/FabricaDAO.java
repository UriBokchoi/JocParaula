/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author oriol
 */

public class FabricaDAO {
    public static PalabraDAO obtenerPalabraDAO() {
        return new PalabraDAO();
    }

    public static JuegoDAO obtenerJuegoDAO() {
        return new JuegoDAO();
    }
}
