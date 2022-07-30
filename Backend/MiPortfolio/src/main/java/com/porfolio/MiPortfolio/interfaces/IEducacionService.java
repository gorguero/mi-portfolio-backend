
package com.porfolio.MiPortfolio.interfaces;

import com.porfolio.MiPortfolio.model.Educacion;
import java.util.List;


public interface IEducacionService {
    
    //Obtenemos una lista de educacion
    List<Educacion> getEducacion();
    
    //Guardamos una educacion
    public void saveEducacion(Educacion educacion);
    
    //Eliminamos una educacion por su id
    public void deleteEducacion(Long id);
    
    //Buscamos una educacion por su id
    public Educacion findEducacion(Long id);
    
    //Editamos una educacion
    public Educacion editEducacion(Educacion educacion);
    
}
