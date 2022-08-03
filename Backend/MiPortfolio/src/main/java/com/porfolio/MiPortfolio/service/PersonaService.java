
package com.porfolio.MiPortfolio.service;

import com.porfolio.MiPortfolio.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.porfolio.MiPortfolio.repository.IPersonaRepository;
import com.porfolio.MiPortfolio.interfaces.IPersonaService;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    public IPersonaRepository ipersonarepository;
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonarepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
       ipersonarepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
       ipersonarepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
       return ipersonarepository.findById(id).orElse(null);
    }

    @Override
    public Persona editPersona(Persona persona) {
        return ipersonarepository.save(persona);
    }
    
}
