package modelo;

import java.util.Date;

public class OrdenTrabajo {
    private int idOrden;
    private int idMotocicleta;
    private Date fecha;
    private String descripcionProblema;
    private String estado;
    private int idEmpleado;

    // Constructores
    public OrdenTrabajo() {
    }

    public OrdenTrabajo(int idMotocicleta, Date fecha, String descripcionProblema, String estado, int idEmpleado) {
        this.idMotocicleta = idMotocicleta;
        this.fecha = fecha;
        this.descripcionProblema = descripcionProblema;
        this.estado = estado;
        this.idEmpleado = idEmpleado;
    }

    // Getters y Setters
    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdMotocicleta() {
        return idMotocicleta;
    }

    public void setIdMotocicleta(int idMotocicleta) {
        this.idMotocicleta = idMotocicleta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcionProblema() {
        return descripcionProblema;
    }

    public void setDescripcionProblema(String descripcionProblema) {
        this.descripcionProblema = descripcionProblema;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}
