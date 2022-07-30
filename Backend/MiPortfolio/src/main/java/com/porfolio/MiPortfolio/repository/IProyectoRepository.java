
package com.porfolio.MiPortfolio.repository;

import com.porfolio.MiPortfolio.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepository extends JpaRepository <Proyecto,Long>{
    
}
