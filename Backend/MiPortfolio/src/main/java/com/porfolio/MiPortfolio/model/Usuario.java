
package com.porfolio.MiPortfolio.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column(nullable=false, updatable=false)
    private Long idUsuario;
    
    private String nombre;
    private String apellido;
    private String presentacion;
    private String telefono;
    private String email;
    private String ubicacion;
    private String link_perfil;
//    private String nickname;
//    private String password;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idEducacion") //LAZY -> Hace una consulta especifica de si queremos traer todo lo del usuario
    private List<Educacion> educacionList; //Vinculamos con la entidad
    
    @OneToMany
    private List<ExperienciaLaboral> expLaboralList;
    
    @OneToMany
    private List<Softskill> skillList;
    
    @OneToMany
    private List<Proyecto> proyectoList;
    
    @OneToMany
    private List<Tecnologia> tecnologiaList;

    public Usuario() {
    }

    public Usuario(Long idUsuario, String nombre, String apellido, String presentacion, String telefono, String email, String ubicacion, String link_perfil) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.presentacion = presentacion;
        this.telefono = telefono;
        this.email = email;
        this.ubicacion = ubicacion;
        this.link_perfil = link_perfil;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getLink_perfil() {
        return link_perfil;
    }

    public void setLink_perfil(String link_perfil) {
        this.link_perfil = link_perfil;
    }
    
    
    
}
