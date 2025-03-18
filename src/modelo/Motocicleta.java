package modelo;

public class Motocicleta {
    private int idMotocicleta;
    private int idCliente;
    private String marca;
    private String modelo;
    private String placa;
    private String numeroSerie;

    // Constructores
    public Motocicleta() {
    }

    public Motocicleta(int idCliente, String marca, String modelo, String placa, String numeroSerie) {
        this.idCliente = idCliente;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.numeroSerie = numeroSerie;
    }

    // Getters y Setters
    public int getIdMotocicleta() {
        return idMotocicleta;
    }

    public void setIdMotocicleta(int idMotocicleta) {
        this.idMotocicleta = idMotocicleta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
}