
package com.porfolio.MiPortfolio.security.service;

import com.porfolio.MiPortfolio.security.Entity.Rol;
import com.porfolio.MiPortfolio.security.Enums.RolNombre;
import com.porfolio.MiPortfolio.security.repository.IRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional /*Si una operacion falla, esto hace un roll back y que no impacte en la base de datos*/
public class RolService {
    
    @Autowired
    IRolRepository iRolRepository;
    
    public Optional<Rol> getByRolName(RolNombre rolNombre){
        return iRolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        iRolRepository.save(rol);
    }
    
}
