package dao;

import modelo.Motocicleta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotocicletaDAO {

    private String url = "jdbc:postgresql://localhost:5432/kikes_motos";
    private String usuario = "kikes_motos_user";
    private String clave = "tu_contraseña_segura"; // Reemplaza con tu contraseña

    public void crearMotocicleta(Motocicleta motocicleta) throws SQLException {
        String sql = "INSERT INTO motocicletas (id_cliente, marca, modelo, placa, numero_serie) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexion = DriverManager.getConnection(url, usuario, clave);
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setInt(1, motocicleta.getIdCliente());
            sentencia.setString(2, motocicleta.getMarca());
            sentencia.setString(3, motocicleta.getModelo());
            sentencia.setString(4, motocicleta.getPlaca());
            sentencia.setString(5, motocicleta.getNumeroSerie());
            sentencia.executeUpdate();
        }
    }

    public Motocicleta obtenerMotocicleta(int idMotocicleta) throws SQLException {
        String sql = "SELECT * FROM motocicletas WHERE id_motocicleta = ?";
        try (Connection conexion = DriverManager.getConnection(url, usuario, clave);
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setInt(1, idMotocicleta);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                Motocicleta motocicleta = new Motocicleta();
                motocicleta.setIdMotocicleta(resultado.getInt("id_motocicleta"));
                motocicleta.setIdCliente(resultado.getInt("id_cliente"));
                motocicleta.setMarca(resultado.getString("marca"));
                motocicleta.setModelo(resultado.getString("modelo"));
                motocicleta.setPlaca(resultado.getString("placa"));
                motocicleta.setNumeroSerie(resultado.getString("numero_serie"));
                return motocicleta;
            }
        }
        return null;
    }

    public List<Motocicleta> obtenerTodasMotocicletas() throws SQLException {
        List<Motocicleta> motocicletas = new ArrayList<>();
        String sql = "SELECT * FROM motocicletas";
        try (Connection conexion = DriverManager.getConnection(url, usuario, clave);
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {
            while (resultado.next()) {
                Motocicleta motocicleta = new Motocicleta();
                motocicleta.setIdMotocicleta(resultado.getInt("id_motocicleta"));
                motocicleta.setIdCliente(resultado.getInt("id_cliente"));
                motocicleta.setMarca(resultado.getString("marca"));
                motocicleta.setModelo(resultado.getString("modelo"));
                motocicleta.setPlaca(resultado.getString("placa"));
                motocicleta.setNumeroSerie(resultado.getString("numero_serie"));
                motocicletas.add(motocicleta);
            }
        }
        return motocicletas;
    }

    // Implementa métodos para actualizar y eliminar motocicletas
}
