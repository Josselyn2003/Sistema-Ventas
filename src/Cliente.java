public class Cliente {
    private int id;
    private String nombre;
    private String cedula;

    public Cliente(int id, String nombre, String cedula) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCedula() { return cedula; }

    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCedula(String cedula) { this.cedula = cedula; }
}
