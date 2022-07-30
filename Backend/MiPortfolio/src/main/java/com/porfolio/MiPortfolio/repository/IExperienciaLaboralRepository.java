
package com.porfolio.MiPortfolio.repository;

import com.porfolio.MiPortfolio.model.ExperienciaLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaLaboralRepository extends JpaRepository <ExperienciaLaboral, Long>{
    
}
