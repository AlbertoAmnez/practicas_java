class EmpleadoPorHora extends Empleado {
    
    private float tarifaHorasExtra;

    // Constructor
    public EmpleadoPorHora(String nombre, String apellidos, float tarifaPorHora, float tarifaHorasExtra) {
        super(nombre, apellidos, tarifaPorHora);
        this.tarifaHorasExtra = tarifaHorasExtra;
    }

    // Sobrescribe el método tipo()
    @Override
    public String tipo() {
        return "Empleado Por Horas";
    }
}