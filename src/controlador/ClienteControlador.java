package controlador;

import modelo.Cliente;
import dao.ClienteDAO;
import java.sql.SQLException;
import java.util.List;

public class ClienteControlador {

    private ClienteDAO clienteDAO = new ClienteDAO();

    public void crearCliente(Cliente cliente) throws SQLException {
        clienteDAO.crearCliente(cliente);
    }

    public Cliente obtenerCliente(int idCliente) throws SQLException {
        return clienteDAO.obtenerCliente(idCliente);
    }

    public List<Cliente> obtenerTodosClientes() throws SQLException {
        return clienteDAO.obtenerTodosClientes();
    }

    // Implementa métodos para actualizar y eliminar clientes
}
