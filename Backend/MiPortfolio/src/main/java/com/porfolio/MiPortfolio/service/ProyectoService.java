
package com.porfolio.MiPortfolio.service;

import com.porfolio.MiPortfolio.interfaces.IProyectoService;
import com.porfolio.MiPortfolio.model.Proyecto;
import com.porfolio.MiPortfolio.repository.IProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{

    @Autowired
    public IProyectoRepository iproyectorepository;
    
    @Override
    public List<Proyecto> getProyecto() {
        List<Proyecto> proyecto = iproyectorepository.findAll();
        return proyecto;
    }

    @Override
    public void saveProyecto(Proyecto proyecto) {
        iproyectorepository.save(proyecto);
    }

    @Override
    public void deleteProyecto(Long id) {
        iproyectorepository.deleteById(id);
    }

    @Override
    public Proyecto findProyecto(Long id) {
        return iproyectorepository.findById(id).orElse(null);
    }

    @Override
    public Proyecto editProyecto(Proyecto proyecto) {
        return iproyectorepository.save(proyecto);
    }
          
}
