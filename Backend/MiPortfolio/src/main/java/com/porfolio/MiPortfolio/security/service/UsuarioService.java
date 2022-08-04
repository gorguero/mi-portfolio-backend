
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
    public boolean existByNickname(String nickname){
        return iUsuarioRepository.existByNickname(nickname);
    }
    
    public boolean existByEmail(String email){
        return iUsuarioRepository.existByEmail(email);
    }
    
    public void save(Usuario usuario){
        iUsuarioRepository.save(usuario);
    }
    
}
