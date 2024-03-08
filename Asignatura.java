public class Asignatura {
    private String nombre;
    private Double nota;
    


public Asignatura(String nombre, Double nota){
    this.nombre = nombre;
    this.nota = nota;
    
}

/*
 * Metodos get y set para acceder a los atributos privados de la clase "Asignatura"
 */

public String getNombre(){
    return nombre;

}

public Double getNota(){
    return nota;
}

public void setNombre(String nombre){
    this.nombre = nombre;

}

public void setNota(Double nota){
    this.nota = nota;
}




}