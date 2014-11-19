package bo.com.offercruz.entidades;
// Generated 18-nov-2014 1:51:54 by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Categoria generated by hbm2java
 */
public class Categoria  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private int tipo;
     private int estado;
     private Date fechaCreacion;
     private Date fechaModificacion;
     private Set categoriaempresas = new HashSet(0);
     private Set ofertas = new HashSet(0);
     private Set ofertas_1 = new HashSet(0);

    public Categoria() {
    }

	
    public Categoria(String nombre, int tipo, int estado, Date fechaCreacion, Date fechaModificacion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }
    public Categoria(String nombre, int tipo, int estado, Date fechaCreacion, Date fechaModificacion, Set categoriaempresas, Set ofertas, Set ofertas_1) {
       this.nombre = nombre;
       this.tipo = tipo;
       this.estado = estado;
       this.fechaCreacion = fechaCreacion;
       this.fechaModificacion = fechaModificacion;
       this.categoriaempresas = categoriaempresas;
       this.ofertas = ofertas;
       this.ofertas_1 = ofertas_1;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getTipo() {
        return this.tipo;
    }
    
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public int getEstado() {
        return this.estado;
    }
    
    public void setEstado(int estado) {
        this.estado = estado;
    }
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public Date getFechaModificacion() {
        return this.fechaModificacion;
    }
    
    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    public Set getCategoriaempresas() {
        return this.categoriaempresas;
    }
    
    public void setCategoriaempresas(Set categoriaempresas) {
        this.categoriaempresas = categoriaempresas;
    }
    public Set getOfertas() {
        return this.ofertas;
    }
    
    public void setOfertas(Set ofertas) {
        this.ofertas = ofertas;
    }
    public Set getOfertas_1() {
        return this.ofertas_1;
    }
    
    public void setOfertas_1(Set ofertas_1) {
        this.ofertas_1 = ofertas_1;
    }




}

