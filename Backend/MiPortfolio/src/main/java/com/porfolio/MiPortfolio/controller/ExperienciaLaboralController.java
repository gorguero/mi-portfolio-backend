
package com.porfolio.MiPortfolio.controller;

import com.porfolio.MiPortfolio.interfaces.IExperienciaLaboralService;
import com.porfolio.MiPortfolio.model.ExperienciaLaboral;
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
public class ExperienciaLaboralController {
    
    @Autowired
    private IExperienciaLaboralService expLaboralService;
    
    @GetMapping ("/expLaboral/obtener")
    @ResponseBody
    public List<ExperienciaLaboral> getExperienciaLaboral(){
        return expLaboralService.getExperienciaLaboral();
    }
    
    @PostMapping ("/expLaboral/crear")
    public String agregarExperienciaLaboral(@RequestBody ExperienciaLaboral expLaboral){
        expLaboralService.saveExperienciaLaboral(expLaboral);
        return "Se ha creado correctamente";
    }
    
    @DeleteMapping ("/expLaboral/borrar/{id}")
    public String eliminarExperienciaLaboral(@PathVariable Long id){
        expLaboralService.deleteExperienciaLaboral(id);
        return "Se ha eliminado correctamente";
    }
    
    @PutMapping ("/expLaboral/editar/{id}")
    public ExperienciaLaboral editarExpLaboral(@PathVariable Long id,
                                             @RequestParam ("nombreEmpresa") String nuevoNombreEmpresa,
                                             @RequestParam ("link_logo") String nuevoLogo,
                                             @RequestParam ("nombrePuesto") String nuevoNombrePuesto,
                                             @RequestParam ("fechaIngreso") String nuevoFechaIngreso,
                                             @RequestParam ("fechaFin") String nuevoFechaFin){
        
        ExperienciaLaboral expLaboral = expLaboralService.findExperienciaLaboral(id);
        
        expLaboral.setNombreEmpresa(nuevoNombreEmpresa);
        expLaboral.setLink_logo(nuevoLogo);
        expLaboral.setNombrePuesto(nuevoNombrePuesto);
        expLaboral.setFechaIngreso(nuevoFechaIngreso);
        expLaboral.setFechaFin(nuevoFechaFin);
        
        expLaboralService.saveExperienciaLaboral(expLaboral);
        
        return expLaboral;
        
    }
    
}
