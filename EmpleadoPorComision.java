class EmpleadoPorComision extends Empleado {
    
    private float porcentajeComision;

    
    public EmpleadoPorComision(String nombre, String apellidos, float tarifaPorHora, float porcentajeComision) {
        super(nombre, apellidos, tarifaPorHora);
        this.porcentajeComision = porcentajeComision;
    }

    // Sobreescribimos el tipo
    @Override
    public String tipo() {
        return "Empleado A Comisión";
    }
}