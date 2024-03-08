import java.util.ArrayList;
import java.util.Scanner;

/*
 * Solo he creado la super clase y las subclases para poder dar de alta un trabajador y sacar por pantalla el posterior registro
 */

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Empleado> empleados = new ArrayList<>();

        System.out.println("Bienvenido al sistema de gestión de empleados.");

        /*
         * Bucle While 
         */

        while (true) {
            System.out.println("Ingrese el nombre del empleado ('fin' para salir):");
            String nombre = sc.nextLine();
            if (nombre.equals("fin")) {
                break;
            }

            System.out.println("Apellidos del empleado:");
            String apellidos = sc.nextLine();

            System.out.println("Tarifa por hora del empleado:");
            float tarifaPorHora = Float.parseFloat(sc.nextLine());

            System.out.println("Tipo de empleado (1. Empleado Por Horas, 2. Empleado Asalariado, 3. Empleado A Comisión):"); // El tipo lo introduciremos en un Switch
            int tipo = Integer.parseInt(sc.nextLine());

            Empleado empleado = null;

            /*
             * Establecemos un Switch case para relacionar cada uno de esos cases a Empleado por Horas, Empleado Asalariado y Empleado A Comision.
             * Ademas añadimos un default por si el usuario no introdujese un valor que sea 1,2 o 3.
             */

            switch (tipo) {
                case 1:
                    System.out.println("Tarifa para horas extra del empleado por horas:");
                    float tarifaHorasExtra = Float.parseFloat(sc.nextLine());
                    empleado = new EmpleadoPorHora(nombre, apellidos, tarifaPorHora, tarifaHorasExtra);
                    break;
                case 2:
                    System.out.println("Salario mensual del empleado asalariado:");
                    float salarioMensual = Float.parseFloat(sc.nextLine());
                    empleado = new EmpleadoAsalariado(nombre, apellidos, tarifaPorHora, salarioMensual);
                    break;
                case 3:
                    System.out.println("Porcentaje de comisión del empleado a comisión:");
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
    

