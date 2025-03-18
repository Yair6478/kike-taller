package controlador;

import modelo.Servicio;
import dao.ServicioDAO;
import java.sql.SQLException;
import java.util.List;

public class ServicioControlador {

    private ServicioDAO servicioDAO = new ServicioDAO();

    public void crearServicio(Servicio servicio) throws SQLException {
        servicioDAO.crearServicio(servicio);
    }

    public Servicio obtenerServicio(int idServicio) throws SQLException {
        return servicioDAO.obtenerServicio(idServicio);
    }

    public List<Servicio> obtenerTodosServicios() throws SQLException {
        return servicioDAO.obtenerTodosServicios();
    }

    // Implementa métodos para actualizar y eliminar servicios
}
