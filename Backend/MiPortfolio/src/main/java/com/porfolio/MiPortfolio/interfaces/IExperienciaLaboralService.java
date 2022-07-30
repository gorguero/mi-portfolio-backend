
package com.porfolio.MiPortfolio.interfaces;

import com.porfolio.MiPortfolio.model.ExperienciaLaboral;
import java.util.List;


public interface IExperienciaLaboralService {
    
    List<ExperienciaLaboral> getExperienciaLaboral();
    
    public void saveExperienciaLaboral();
    
    public void deleteExperienciaLaboral();
    
    public ExperienciaLaboral findExperienciaLaboral(Long id);
    
    public ExperienciaLaboral editExperienciaLaboral(ExperienciaLaboral expLab);
    
}
