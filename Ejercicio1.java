import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir datos del alumno
        System.out.println("Ingrese el nombre del alumno:");
        String nombreAlumno = sc.nextLine();
        System.out.println("Ingrese los apellidos del alumno:");
        String apellidosAlumno = sc.nextLine();

        // Crear un nuevo alumno
        Alumno alumno1 = new Alumno(nombreAlumno, apellidosAlumno);

        // Interacción para añadir asignaturas con notas
        boolean continuar = true;
        while (continuar) {
            try {
                System.out.println("Ingrese el nombre de la asignatura (o escriba 'fin' para terminar):");
                String nombreAsignatura = sc.nextLine();
                if (nombreAsignatura.equalsIgnoreCase("fin")) {
                    continuar = false;
                } else {
                    try {
                        // Verificar si el nombre de la asignatura es un string válido
                        Double.parseDouble(nombreAsignatura); // Intenta convertir el nombre en un double (esto lanzará una excepción si no es un número)
                        throw new InputMismatchException(); // Si no lanza una excepción, entonces el nombre no es un string válido
                    } catch (NumberFormatException e) {
                        // Si no se lanza ninguna excepción, el nombre de la asignatura es un string válido
                        System.out.println("Ingrese la nota de la asignatura:");
                        double notaAsignatura = sc.nextDouble();
                        sc.nextLine(); // Limpiar el buffer
                        alumno1.addAsignatura(nombreAsignatura, notaAsignatura);
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un valor válido.");
                sc.nextLine(); // Limpiar el buffer
            }
        }
        

        // Mostrar boletín de notas
        alumno1.mostrarBoletin();

        // Interacción para modificar nota de una asignatura
        System.out.println("¿Desea modificar alguna nota? (s/n)");
        String respuesta = sc.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Ingrese el nombre de la asignatura que desea modificar:");
            String nombreAsignaturaModificar = sc.nextLine();
            try {
                System.out.println("Ingrese la nueva nota:");
                double nuevaNota = sc.nextDouble();
                sc.nextLine(); // Limpiar el buffer
                alumno1.modifNota(nombreAsignaturaModificar, nuevaNota);
                System.out.println("Nota modificada correctamente.");
                // Mostrar boletín de notas actualizado
                alumno1.mostrarBoletin();
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número válido para la nueva nota.");
                sc.nextLine(); // Limpiar el buffer
            }
        } else {
            System.out.println("Hasta luego.");
        }

        sc.close();
    }
}

