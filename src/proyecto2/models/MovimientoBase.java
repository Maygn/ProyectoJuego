package proyecto2.models;


public class MovimientoBase {
    protected String nombre;
    protected String descripcion;
    protected double velocidadBase;
    protected String tipo;

    
    
    public MovimientoBase(String nombre, String descripcion, double velocidadBase, String tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.velocidadBase = velocidadBase;
        this.tipo = tipo;
    }
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
    
    public void realizar(Personaje activo, Personaje pasivo) {};
    
    @Override
    public String toString() {
        return "MovimientoBase [nombre=" + nombre + ", descripcion=" + descripcion + ", velocidadBase=" + velocidadBase
                + ", tipo=" + tipo + "]";
    }

    
    

}
