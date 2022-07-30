
package com.porfolio.MiPortfolio.service;

import com.porfolio.MiPortfolio.interfaces.ITecnologiaService;
import com.porfolio.MiPortfolio.model.Tecnologia;
import com.porfolio.MiPortfolio.repository.ITecnologiaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnologiaService implements ITecnologiaService{
    
    @Autowired
    public ITecnologiaRepository itecrepository;

    @Override
    public List<Tecnologia> getTecnologia() {
        List<Tecnologia> tecnologia = itecrepository.findAll();
        return tecnologia;
    }

    @Override
    public void saveTecnologia(Tecnologia tecnologia) {
        itecrepository.save(tecnologia);
    }

    @Override
    public void deleteTecnologia(Long id) {
        itecrepository.deleteById(id);
    }

    @Override
    public Tecnologia findTecnologia(Long id) {
        return itecrepository.findById(id).orElse(null);
    }

    @Override
    public Tecnologia editTecnologia(Tecnologia tecnologia) {
        return itecrepository.save(tecnologia);
    }
    
    
    
}
