
package com.porfolio.MiPortfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyecto {
    
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private Long idProyecto;
    
    private String titulo;
    private String descripcion;
    private String link_portada;

    public Proyecto() {
    }

    public Proyecto(Long idProyecto, String titulo, String descripcion, String link_portada) {
        this.idProyecto = idProyecto;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.link_portada = link_portada;
    }
    
    
    
}
