
package com.porfolio.MiPortfolio.service;

import com.porfolio.MiPortfolio.interfaces.ISoftskillService;
import com.porfolio.MiPortfolio.model.Softskill;
import com.porfolio.MiPortfolio.repository.ISoftskillsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoftskillService implements ISoftskillService{
    
    @Autowired
    public ISoftskillsRepository iskillrepository;

    @Override
    public List<Softskill> getSoftskill() {
        List<Softskill> skill = iskillrepository.findAll();
        return skill;
    }

    @Override
    public void saveSoftskill(Softskill skill) {
        iskillrepository.save(skill);
    }

    @Override
    public void deleteSoftskill(Long id) {
        iskillrepository.deleteById(id);
    }

    @Override
    public Softskill findSoftskill(Long id) {
        return iskillrepository.findById(id).orElse(null);
    }

    @Override
    public Softskill editSoftskill(Softskill softskill) {
        return iskillrepository.save(softskill);
    }
    
}
