
package com.porfolio.MiPortfolio.interfaces;

import com.porfolio.MiPortfolio.model.ExperienciaLaboral;
import java.util.List;


public interface IExperienciaLaboralService {
    
    List<ExperienciaLaboral> getExperienciaLaboral();
    
    public void saveExperienciaLaboral(ExperienciaLaboral expLaboral);
    
    public void deleteExperienciaLaboral(Long id);
    
    public ExperienciaLaboral findExperienciaLaboral(Long id);
    
    public ExperienciaLaboral editExperienciaLaboral(ExperienciaLaboral expLab);
    
}
