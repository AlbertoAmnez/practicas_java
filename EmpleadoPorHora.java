class EmpleadoPorHora extends Empleado {
    
    private float tarifaHorasExtra;

    
    public EmpleadoPorHora(String nombre, String apellidos, float tarifaPorHora, float tarifaHorasExtra) {
        super(nombre, apellidos, tarifaPorHora);
        this.tarifaHorasExtra = tarifaHorasExtra;
    }

    // Sobreescribimos el tipo
    @Override
    public String tipo() {
        return "Empleado Por Horas";
    }
}