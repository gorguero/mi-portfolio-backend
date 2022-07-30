
package com.porfolio.MiPortfolio.service;

import com.porfolio.MiPortfolio.interfaces.IExperienciaLaboralService;
import com.porfolio.MiPortfolio.model.ExperienciaLaboral;
import com.porfolio.MiPortfolio.repository.IExperienciaLaboralRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaLaboralService implements IExperienciaLaboralService{

    @Autowired
    public IExperienciaLaboralRepository iexplaboralrepository;
    
    @Override
    public List<ExperienciaLaboral> getExperienciaLaboral() {
        
        List<ExperienciaLaboral> expLaboral = iexplaboralrepository.findAll();
        return expLaboral;
                
    }

    @Override
    public void saveExperienciaLaboral(ExperienciaLaboral expLaboral) {
        iexplaboralrepository.save(expLaboral);
    }

    @Override
    public void deleteExperienciaLaboral(Long id) {
        iexplaboralrepository.deleteById(id);
    }

    @Override
    public ExperienciaLaboral findExperienciaLaboral(Long id) {
        return iexplaboralrepository.findById(id).orElse(null);
    }

    @Override
    public ExperienciaLaboral editExperienciaLaboral(ExperienciaLaboral expLab) {
        return iexplaboralrepository.save(expLab);
    }
    
}
