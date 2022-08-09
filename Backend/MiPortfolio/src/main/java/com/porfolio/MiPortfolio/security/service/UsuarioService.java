
package com.porfolio.MiPortfolio.security.service;

import com.porfolio.MiPortfolio.security.Entity.Usuario;
import com.porfolio.MiPortfolio.security.repository.IUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    
    @Autowired
    IUsuarioRepository iUsuarioRepository;
    
    public Optional<Usuario> getByNickname(String nickname){
        return iUsuarioRepository.findByNombreUsuario(nickname);
    }
    public boolean existsByNickname(String nickname){
        return iUsuarioRepository.existsByNickname(nickname);
    }
    
    public boolean existsByEmail(String email){
        return iUsuarioRepository.existsByEmail(email);
    }
    
    public void save(Usuario usuario){
        iUsuarioRepository.save(usuario);
    }
    
}
