package dao;

import modelo.Servicio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicioDAO {

    private String url = "jdbc:postgresql://localhost:5432/kikes_motos";
    private String usuario = "kikes_motos_user";
    private String clave = "tu_contraseña_segura"; // Reemplaza con tu contraseña

    public void crearServicio(Servicio servicio) throws SQLException {
        String sql = "INSERT INTO servicios (descripcion, precio) VALUES (?, ?)";
        try (Connection conexion = DriverManager.getConnection(url, usuario, clave);
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, servicio.getDescripcion());
            sentencia.setDouble(2, servicio.getPrecio());
            sentencia.executeUpdate();
        }
    }

    public Servicio obtenerServicio(int idServicio) throws SQLException {
        String sql = "SELECT * FROM servicios WHERE id_servicio = ?";
        try (Connection conexion = DriverManager.getConnection(url, usuario, clave);
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setInt(1, idServicio);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                Servicio servicio = new Servicio();
                servicio.setIdServicio(resultado.getInt("id_servicio"));
                servicio.setDescripcion(resultado.getString("descripcion"));
                servicio.setPrecio(resultado.getDouble("precio"));
                return servicio;
            }
        }
        return null;
    }

    public List<Servicio> obtenerTodosServicios() throws SQLException {
        List<Servicio> servicios = new ArrayList<>();
        String sql = "SELECT * FROM servicios";
        try (Connection conexion = DriverManager.getConnection(url, usuario, clave);
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {
            while (resultado.next()) {
                Servicio servicio = new Servicio();
                servicio.setIdServicio(resultado.getInt("id_servicio"));
                servicio.setDescripcion(resultado.getString("descripcion"));
                servicio.setPrecio(resultado.getDouble("precio"));
                servicios.add(servicio);
            }
        }
        return servicios;
    }

    // Implementa métodos para actualizar y eliminar servicios
}
