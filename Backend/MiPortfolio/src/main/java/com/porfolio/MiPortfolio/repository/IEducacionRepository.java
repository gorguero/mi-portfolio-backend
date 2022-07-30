
package com.porfolio.MiPortfolio.repository;

import com.porfolio.MiPortfolio.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository <Educacion, Long>{
    
}
