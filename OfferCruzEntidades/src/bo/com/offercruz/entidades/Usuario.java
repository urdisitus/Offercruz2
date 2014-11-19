package bo.com.offercruz.entidades;
// Generated 18-nov-2014 1:51:54 by Hibernate Tools 3.6.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario implements java.io.Serializable {

    private Integer id;
    private Perfil perfil;
    private String password;
    private String login;
    private Date fechaModificacion;
    private int estado;
    private Date fechaCreacion;
    private int tipo;
    private String correoElectronico;
    private Set empresas = new HashSet(0);
    private Set clientes = new HashSet(0);
    private Set clientes_1 = new HashSet(0);
    private Set empresas_1 = new HashSet(0);

    private String passwordInicial;

    public Usuario() {
    }

    public void setPasswordInicial(String contraseñaInicial) {
        this.passwordInicial = contraseñaInicial;
    }

    public String getPasswordInicial() {
        return passwordInicial;
    }

    public Usuario(Perfil perfil, String password, String login, Date fechaModificacion, int estado, Date fechaCreacion, int tipo, String correoElectronico) {
        this.perfil = perfil;
        this.password = password;
        this.login = login;
        this.fechaModificacion = fechaModificacion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.tipo = tipo;
        this.correoElectronico = correoElectronico;
    }

    public Usuario(Perfil perfil, String password, String login, Date fechaModificacion, int estado, Date fechaCreacion, int tipo, String correoElectronico, Set empresas, Set clientes, Set clientes_1, Set empresas_1) {
        this.perfil = perfil;
        this.password = password;
        this.login = login;
        this.fechaModificacion = fechaModificacion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.tipo = tipo;
        this.correoElectronico = correoElectronico;
        this.empresas = empresas;
        this.clientes = clientes;
        this.clientes_1 = clientes_1;
        this.empresas_1 = empresas_1;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Perfil getPerfil() {
        return this.perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getFechaModificacion() {
        return this.fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
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

    public int getTipo() {
        return this.tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Set getEmpresas() {
        return this.empresas;
    }

    public void setEmpresas(Set empresas) {
        this.empresas = empresas;
    }

    public Set getClientes() {
        return this.clientes;
    }

    public void setClientes(Set clientes) {
        this.clientes = clientes;
    }

    public Set getClientes_1() {
        return this.clientes_1;
    }

    public void setClientes_1(Set clientes_1) {
        this.clientes_1 = clientes_1;
    }

    public Set getEmpresas_1() {
        return this.empresas_1;
    }

    public void setEmpresas_1(Set empresas_1) {
        this.empresas_1 = empresas_1;
    }

}