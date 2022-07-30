
package com.porfolio.MiPortfolio.repository;

import com.porfolio.MiPortfolio.model.Softskill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISoftskillsRepository extends JpaRepository <Softskill, Long>{
    
}
