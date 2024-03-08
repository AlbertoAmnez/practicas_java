import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Empleado> empleados = new ArrayList<>();

        System.out.println("Bienvenido al sistema de gestión de empleados.");

        while (true) {
            System.out.println("Ingrese el nombre del empleado (o 'fin' para terminar):");
            String nombre = sc.nextLine();
            if (nombre.equals("fin")) {
                break;
            }

            System.out.println("Ingrese los apellidos del empleado:");
            String apellidos = sc.nextLine();

            System.out.println("Ingrese la tarifa por hora del empleado:");
            float tarifaPorHora = Float.parseFloat(sc.nextLine());

            System.out.println("Seleccione el tipo de empleado (1. Empleado Por Horas, 2. Empleado Asalariado, 3. Empleado A Comisión):");
            int tipo = Integer.parseInt(sc.nextLine());

            Empleado empleado = null;

            switch (tipo) {
                case 1:
                    System.out.println("Ingrese la tarifa para horas extra del empleado por horas:");
                    float tarifaHorasExtra = Float.parseFloat(sc.nextLine());
                    empleado = new EmpleadoPorHora(nombre, apellidos, tarifaPorHora, tarifaHorasExtra);
                    break;
                case 2:
                    System.out.println("Ingrese el salario mensual del empleado asalariado:");
                    float salarioMensual = Float.parseFloat(sc.nextLine());
                    empleado = new EmpleadoAsalariado(nombre, apellidos, tarifaPorHora, salarioMensual);
                    break;
                case 3:
                    System.out.println("Ingrese el porcentaje de comisión del empleado a comisión:");
                    float porcentajeComision = Float.parseFloat(sc.nextLine());
                    empleado = new EmpleadoPorComision(nombre, apellidos, tarifaPorHora, porcentajeComision);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            if (empleado != null) {
                empleados.add(empleado);
                System.out.println("Empleado añadido correctamente.");
            }

        }

        System.out.println("\nListado de empleados:");
        System.out.printf("%-20s %-20s %-20s %n", "Nombre", "Apellidos", "Tipo");

        for (Empleado empleado : empleados) {
            System.out.printf("%-20s %-20s %-20s %n", empleado.nombre, empleado.apellidos, empleado.tipo());
        }
        sc.close();
    }
    
}
    

