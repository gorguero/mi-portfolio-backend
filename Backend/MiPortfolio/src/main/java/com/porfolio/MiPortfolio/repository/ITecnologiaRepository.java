
package com.porfolio.MiPortfolio.repository;

import com.porfolio.MiPortfolio.model.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITecnologiaRepository extends JpaRepository <Tecnologia, Long>{
    
}
