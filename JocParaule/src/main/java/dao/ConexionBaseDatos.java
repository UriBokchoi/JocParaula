/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author oriol
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static Connection conexion;

    public static Connection obtenerConexion() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            String url = "jdbc:mysql://localhost:3306/paraulogic";
            String usuario = "root"; 
            String contrasena = "Educem123"; 
            conexion = DriverManager.getConnection(url, usuario, contrasena);
        }
        return conexion;
    }
}
