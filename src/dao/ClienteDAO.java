package dao;

import modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private String url = "jdbc:postgresql://localhost:5432/kikes_motos";
    private String usuario = "kikes_motos_user";
    private String clave = "jorge1964"; // Reemplaza aquí la contraseña

    public void crearCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (nombre, direccion, telefono) VALUES (?, ?, ?)";
        try (Connection conexion = DriverManager.getConnection(url, usuario, clave);
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, cliente.getNombre());
            sentencia.setString(2, cliente.getDireccion());
            sentencia.setString(3, cliente.getTelefono());
            sentencia.executeUpdate();
        }
    }

    public Cliente obtenerCliente(int idCliente) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE id_cliente = ?";
        try (Connection conexion = DriverManager.getConnection(url, usuario, clave);
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setInt(1, idCliente);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(resultado.getInt("id_cliente"));
                cliente.setNombre(resultado.getString("nombre"));
                cliente.setDireccion(resultado.getString("direccion"));
                cliente.setTelefono(resultado.getString("telefono"));
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> obtenerTodosClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Connection conexion = DriverManager.getConnection(url, usuario, clave);
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(resultado.getInt("id_cliente"));
                cliente.setNombre(resultado.getString("nombre"));
                cliente.setDireccion(resultado.getString("direccion"));
                cliente.setTelefono(resultado.getString("telefono"));
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    public void actualizarCliente(Cliente cliente) throws SQLException {
        String sql = "UPDATE clientes SET nombre = ?, direccion = ?, telefono = ? WHERE id_cliente = ?";
        try (Connection conexion = DriverManager.getConnection(url, usuario, clave);
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, cliente.getNombre());
            sentencia.setString(2, cliente.getDireccion());
            sentencia.setString(3, cliente.getTelefono());
            sentencia.setInt(4, cliente.getIdCliente());
            sentencia.executeUpdate();
        }
    }

    public void eliminarCliente(int idCliente) throws SQLException {
        String sql = "DELETE FROM clientes WHERE id_cliente = ?";
        try (Connection conexion = DriverManager.getConnection(url, usuario, clave);
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setInt(1, idCliente);
            sentencia.executeUpdate();
        }
    }
}