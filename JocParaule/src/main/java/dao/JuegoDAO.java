/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author oriol
 */
import com.mycompany.jocparaule.model.Juego;
import com.mycompany.jocparaule.model.Palabra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class JuegoDAO {
    public void guardarJuego(Juego juego, String nombreJugador) {
        String consulta = "INSERT INTO historial_juegos (nombre_jugador, puntuacion, palabras) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBaseDatos.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(consulta)) {
            stmt.setString(1, nombreJugador);
            stmt.setInt(2, juego.obtenerPuntuacion().obtenerPuntos());
            StringBuilder palabras = new StringBuilder();
            for (Palabra p : juego.obtenerPalabrasEncontradas()) {
                palabras.append(p.obtenerPalabra()).append(",");
            }
            stmt.setString(3, palabras.toString());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
