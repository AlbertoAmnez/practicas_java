import java.util.HashMap;
import java.util.Map;

public class Alumno {
    private String nombre;
    private String apellidos;
    private Map<String, Asignatura> asignaturas;


public Alumno(String nombre, String apellidos){
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.asignaturas = new HashMap<>();
}

/*
 * Metodos get y set para acceder a los atributos privados de la clase "Alumno"
 */

public String getNombre() {
    return nombre;
}

public String getApellidos() {
    return apellidos;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
}

public Map<String, Asignatura> getAsignaturas() {
    return asignaturas;
}

public void addAsignatura(String nombreAsignatura, double nuevaNota){
    Asignatura nuevaAsignatura = new Asignatura(nombreAsignatura, nuevaNota);
    asignaturas.put(nombreAsignatura, nuevaAsignatura); // Añade nueva asignatura
}

/*
 * la idea era que no pudiera modificar la nota si la asignatura no existe, la parte de la modificacion es correcta.
 * El problema surge cuando me pide una asignatura para modificar e introduzco un valor inexistente, no me la contabiliza en el boletin pero no me salta error.
 */

public void modifNota(String nombreAsignatura, double nuevaNota){
    if (asignaturas.containsKey(nombreAsignatura)){
        Asignatura asignatura = asignaturas.get(nombreAsignatura);
        asignatura.setNota(nuevaNota); // Modifica la nota de la asignatura
    } else {
        System.out.println("Esta asignatura no pertenece a dicho alumno");
    }
}

/*
 * Nota media
 */
public double calculoPromedio(){
    double suma = 0;
    for (Asignatura asignatura : asignaturas.values()){
        suma += asignatura.getNota();
    }
    return suma / asignaturas.size();
}


public void mostrarBoletin() {
    StringBuilder boletin = new StringBuilder();
    boletin.append(String.format("Alumno %s %s:\n", nombre, apellidos));
    boletin.append("Asignatura                    Nota\n");
    boletin.append("-----------------------------------\n");
    
    for (Map.Entry<String, Asignatura> entry : asignaturas.entrySet()) {
        String nombreAsignatura = entry.getKey();
        double notaAsignatura = entry.getValue().getNota();
        boletin.append(String.format("%-30s%.2f\n", nombreAsignatura, notaAsignatura));
    }
    boletin.append("----------------------------------\n");
    boletin.append(String.format("Nota media:                   %.2f\n", calculoPromedio()));
    
    System.out.println(boletin.toString());
}

}