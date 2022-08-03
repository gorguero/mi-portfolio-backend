
package com.porfolio.MiPortfolio.interfaces;

import com.porfolio.MiPortfolio.model.Persona;
import java.util.List;


public interface IPersonaService {
    
    List<Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public void deletePersona(Long id);
    
    public Persona findPersona(Long id);
    
    public Persona editPersona(Persona persona);
    
}
