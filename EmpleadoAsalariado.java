class EmpleadoAsalariado extends Empleado {
    // Atributos
    private float salarioMensual;

    // Constructor
    public EmpleadoAsalariado(String nombre, String apellidos, float tarifaPorHora, float salarioMensual) {
        super(nombre, apellidos, tarifaPorHora);
        this.salarioMensual = salarioMensual;
    }

    // Sobrescribe el método tipo()
    @Override
    public String tipo() {
        return "Empleado Asalariado";
    }
}