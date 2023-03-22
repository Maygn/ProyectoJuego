package proyecto2.models;

import java.io.Serializable;

public class MovimientoBase implements Serializable{
    protected String nombre;
    protected String descripcion;
    protected double velocidadBase;
    protected String tipo;

    
    //Constructor
    public MovimientoBase(String nombre, String descripcion, double velocidadBase, String tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.velocidadBase = velocidadBase;
        this.tipo = tipo;
    }
    
    //getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getVelocidadBase() {
        return velocidadBase;
    }
    public void setVelocidadBase(double velocidadBase) {
        this.velocidadBase = velocidadBase;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    //para overridear
    public void realizar(Personaje activo, Personaje pasivo) {};
    
    @Override
    public String toString() {
        return "MovimientoBase [nombre=" + nombre + ", descripcion=" + descripcion + ", velocidadBase=" + velocidadBase
                + ", tipo=" + tipo + "]";
    }

    
    

}
