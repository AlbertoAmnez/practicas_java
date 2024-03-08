class EmpleadoAsalariado extends Empleado {
    
    private float salarioMensual;

    
    public EmpleadoAsalariado(String nombre, String apellidos, float tarifaPorHora, float salarioMensual) {
        super(nombre, apellidos, tarifaPorHora);
        this.salarioMensual = salarioMensual;
    }

    // Sobreescribimos el tipo
    @Override
    public String tipo() {
        return "Empleado Asalariado";
    }
}