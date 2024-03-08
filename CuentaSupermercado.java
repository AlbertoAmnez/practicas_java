import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CuentaSupermercado {
    private Map<String, Integer> productos;
    LineaFactura lineaFactura;

    public CuentaSupermercado() {
        this.productos = new HashMap<>();
        this.lineaFactura = new LineaFactura();
    }

    
    public void agregarProducto(String nombre, int cantidad, double precioUnitario) {
        productos.put(nombre, productos.getOrDefault(nombre, 0) + cantidad);
        lineaFactura.setNumProductos(lineaFactura.getNumProductos() + cantidad);
        lineaFactura.setTotParcial(lineaFactura.getTotParcial() + (cantidad * precioUnitario));
    }

    
    public double calcularPrecioTotal() {
        return lineaFactura.getTotParcial();
    }

    
    public String mostrarListado(Map<String, Double> precios) {
        /*
         * Busque esto en Google para generar un numero random de 6 cifras para que aparezca al lado del ticket, es por adornar un poco
         */

        Random random = new Random();
        int numeroTicket = 100000 + random.nextInt(900000);

        StringBuilder sb = new StringBuilder();

        sb.append("TICKET ").append(numeroTicket).append("\n");

        sb.append(String.format("%-30s %-15s %-15s %-15s\n", "Producto", "Unidades", "P.U", "Total"));

        sb.append("------------------------------------------\n");

        for (Map.Entry<String, Integer> entry : productos.entrySet()) {

            String nombre = entry.getKey();
            int cantidad = entry.getValue();
            double precioUnitario = precios.getOrDefault(nombre, 0.0);
            double total = precioUnitario * cantidad;

            sb.append(String.format("%-30s %-15s %-15.2f %-15.2f\n", nombre, cantidad, precioUnitario, total));
    }

    sb.append("------------------------------------------\n");
    sb.append("Total: ").append(calcularPrecioTotal()).append("\n");
    return sb.toString();
}

}