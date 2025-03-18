package controlador;

import modelo.Motocicleta;
import dao.MotocicletaDAO;
import java.sql.SQLException;
import java.util.List;

public class MotocicletaControlador {

    private MotocicletaDAO motocicletaDAO = new MotocicletaDAO();

    public void crearMotocicleta(Motocicleta motocicleta) throws SQLException {
        motocicletaDAO.crearMotocicleta(motocicleta);
    }

    public Motocicleta obtenerMotocicleta(int idMotocicleta) throws SQLException {
        return motocicletaDAO.obtenerMotocicleta(idMotocicleta);
    }

    public List<Motocicleta> obtenerTodasMotocicletas() throws SQLException {
        return motocicletaDAO.obtenerTodasMotocicletas();
    }

    // Implementa métodos para actualizar y eliminar motocicletas
}
