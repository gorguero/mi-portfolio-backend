
package com.porfolio.MiPortfolio.controller;

import com.porfolio.MiPortfolio.interfaces.IEducacionService;
import com.porfolio.MiPortfolio.model.Educacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EducacionController {
    
    @Autowired
    private IEducacionService educacionService;
    
    @GetMapping ("/educacion/obtener")
    @ResponseBody
    public List<Educacion> getEducacion(){
        return educacionService.getEducacion();
    }
    
    @PostMapping ("/educacion/crear")
    public String agregarEducacion(@RequestBody Educacion educacion){
        educacionService.saveEducacion(educacion);
        return "Se ha creado correctamente";
    }
    
    @DeleteMapping ("/educacion/borrar/{id}")
    public String eliminarEducacion(@PathVariable Long id){
        educacionService.deleteEducacion(id);
        return "Se ha eliminado correctamente.";
    }
    
    // URL -> PUERTO/educacion/editar/{id}/nombre&tanto&tanto&
    @PutMapping ("/educacion/editar/{id}")
    public Educacion editarEducacion(@PathVariable Long id,
                                    @RequestParam ("nombreInsti") String nuevoNombreInsti,
                                    @RequestParam ("link_logo") String nuevoLogo,
                                    @RequestParam ("titulo") String nuevoTitulo,
                                    @RequestParam ("fechaInicio") String nuevoFechaInicio,
                                    @RequestParam ("fechaFinal") String nuevoFechaFinal){
        
        Educacion educacion = educacionService.findEducacion(id);
        
        educacion.setNombreInsti(nuevoNombreInsti);
        educacion.setLink_logo(nuevoLogo);
        educacion.setTitulo(nuevoTitulo);
        educacion.setFechaInicio(nuevoFechaInicio);
        educacion.setFechaFinal(nuevoFechaFinal);
        
        educacionService.saveEducacion(educacion);
        
        return educacion;
    }
    
}
