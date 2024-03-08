class EmpleadoPorComision extends Empleado {
    // Atributos
    private float porcentajeComision;

    // Constructor
    public EmpleadoPorComision(String nombre, String apellidos, float tarifaPorHora, float porcentajeComision) {
        super(nombre, apellidos, tarifaPorHora);
        this.porcentajeComision = porcentajeComision;
    }

    // Sobrescribe el método tipo()
    @Override
    public String tipo() {
        return "Empleado A Comisión";
    }
}