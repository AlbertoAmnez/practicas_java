public class Empleado {
    String nombre;
    String apellidos;
    float tarifaPorHora;

    // Constructor
    public Empleado(String nombre, String apellidos, float tarifaPorHora) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tarifaPorHora = tarifaPorHora;
    }

    // Métodos
    public String nombreCompleto() {
        return nombre + " " + apellidos;
    }

    public String tipo() {
        return "Empleado normal";
    }
}







