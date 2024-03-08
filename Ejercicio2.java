import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio2 {
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Cuál es el número total de productos?");
        int numProductos = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        CuentaSupermercado cuenta = new CuentaSupermercado();
        Map<String, Double> precios = new HashMap<>();

        for (int i = 0; i < numProductos; i++) {
            System.out.println("Nombre del producto a introducir: ");
            String nombre = scanner.nextLine();

            System.out.println("Precio del producto en cuestión: ");
            double precioUnitario = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("¿Cuántas unidades de este producto va a adquirir? ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            cuenta.agregarProducto(nombre, cantidad, precioUnitario);
            precios.put(nombre, precioUnitario);

            System.out.println("¿Quieres añadir algún producto más? (s/n)");
            String continuar = scanner.nextLine();
            if (!continuar.equalsIgnoreCase("s")) {
                break;
            }
        }

        // Mostrar ticket de toda la compra
        System.out.println(cuenta.mostrarListado(precios));

        scanner.close();
    }
}