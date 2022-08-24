
package com.porfolio.MiPortfolio.security.repository;

import com.porfolio.MiPortfolio.security.Entity.Rol;
import com.porfolio.MiPortfolio.security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
