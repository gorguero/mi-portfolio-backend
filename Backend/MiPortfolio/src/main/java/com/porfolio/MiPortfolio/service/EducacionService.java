
package com.porfolio.MiPortfolio.service;

import com.porfolio.MiPortfolio.interfaces.IEducacionService;
import com.porfolio.MiPortfolio.model.Educacion;
import com.porfolio.MiPortfolio.repository.IEducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{
    
    @Autowired
    public IEducacionRepository ieducacionrepository; 

    @Override
    public List<Educacion> getEducacion() {
        List<Educacion> educacion = ieducacionrepository.findAll();
        return educacion;
    }

    @Override
    public void saveEducacion(Educacion educacion) {
        ieducacionrepository.save(educacion);
    }

    @Override
    public void deleteEducacion(Long id) {
        ieducacionrepository.deleteById(id);
    }

    @Override
    public Educacion findEducacion(Long id) {
        return ieducacionrepository.findById(id).orElse(null);
    }

    @Override
    public Educacion editEducacion(Educacion educacion) {
        return ieducacionrepository.save(educacion);
    }
    
    
    
}
