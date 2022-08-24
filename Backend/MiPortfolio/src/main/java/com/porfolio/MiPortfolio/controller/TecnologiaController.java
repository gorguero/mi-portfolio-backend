
package com.porfolio.MiPortfolio.controller;

import com.porfolio.MiPortfolio.interfaces.ITecnologiaService;
import com.porfolio.MiPortfolio.model.Tecnologia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TecnologiaController {
    
    @Autowired
    private ITecnologiaService tecnologiaService;
    
    @GetMapping ("/tecnologia/obtener")
    public List<Tecnologia> getTecnologia(){
        return tecnologiaService.getTecnologia();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/tecnologia/crear")
    public String agregarTecnologia(@RequestBody Tecnologia tecnologia){
        tecnologiaService.saveTecnologia(tecnologia);
        return "Se ha creado correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/tecnologia/borrar/{id}")
    public String eliminarTecnologia(@PathVariable Long id){
        tecnologiaService.deleteTecnologia(id);
        return "Se ha eliminado correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/tecnologia/editar/{id}")
    public Tecnologia editarTecnologia(@PathVariable Long id,
                                    @RequestParam ("nombre") String nuevoNombre,
                                    @RequestParam ("link_logo") String nuevoLogo){
        
        Tecnologia tecnologia = tecnologiaService.findTecnologia(id);
        
        tecnologia.setNombre(nuevoNombre);
        tecnologia.setLink_logo(nuevoLogo);
        
        tecnologiaService.saveTecnologia(tecnologia);
        
        return tecnologia;
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping ("/tecnologia/encontrar/{id}")
    public Tecnologia findTecnologia(@PathVariable Long id){
        return tecnologiaService.findTecnologia(id);
    }
    
}
