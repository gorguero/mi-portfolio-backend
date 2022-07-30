
package com.porfolio.MiPortfolio.interfaces;

import com.porfolio.MiPortfolio.model.Softskill;
import java.util.List;


public interface ISoftskillService {
    
    List<Softskill> getSoftskill();
    
    public void saveSoftskill();
    
    public void deleteSoftskill();
    
    public Softskill findSoftskill(Long id);
    
    public Softskill editSoftskill(Softskill softskill);
    
}
