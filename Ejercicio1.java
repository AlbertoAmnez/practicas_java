import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Ingrese el nombre del alumno:");
        String nombreAlumno = sc.nextLine();
        System.out.println("Ingrese los apellidos del alumno:");
        String apellidosAlumno = sc.nextLine();

        // Instanciar un alumno 
        Alumno alumno1 = new Alumno(nombreAlumno, apellidosAlumno);

        
        boolean continuar = true;
        while (continuar) {
            try {
                System.out.println("Ingrese el nombre de la asignatura (o escriba 'fin' para terminar):");
                String nombreAsignatura = sc.nextLine();
                if (nombreAsignatura.equalsIgnoreCase("fin")) {
                    continuar = false;
                } else {
                    try {
                        // El nombre deberá ser un string
                        Double.parseDouble(nombreAsignatura); // Lanzara un error si no es un numero
                        throw new InputMismatchException(); // 
                    } catch (NumberFormatException e) {
                        // Excepcion si no es string valido
                        System.out.println("Ingrese la nota de la asignatura:");
                        double notaAsignatura = sc.nextDouble();
                        sc.nextLine(); 
                        alumno1.addAsignatura(nombreAsignatura, notaAsignatura);
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un valor válido.");
                sc.nextLine(); 
            }
        }
        

        
        alumno1.mostrarBoletin();

        
        System.out.println("¿Desea modificar alguna nota? (s/n)");
        String respuesta = sc.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Ingrese el nombre de la asignatura que desea modificar:");
            String nombreAsignaturaModificar = sc.nextLine();
            try {
                System.out.println("Ingrese la nueva nota:");
                double nuevaNota = sc.nextDouble();
                sc.nextLine(); 
                alumno1.modifNota(nombreAsignaturaModificar, nuevaNota);
                System.out.println("Nota modificada correctamente.");
                
                alumno1.mostrarBoletin();
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número válido para la nueva nota.");
                sc.nextLine(); 
            }
        } else {
            System.out.println("Hasta luego.");
        }

        sc.close();
    }
}

