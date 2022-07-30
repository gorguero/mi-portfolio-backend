
package com.porfolio.MiPortfolio.service;

import com.porfolio.MiPortfolio.interfaces.IUsuarioService;
import com.porfolio.MiPortfolio.model.Usuario;
import com.porfolio.MiPortfolio.repository.IUsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    public IUsuarioRepository iuserrepository;
    
    @Override
    public List<Usuario> getUsuario() {
        List<Usuario> usuario = iuserrepository.findAll();
        return usuario;
    }

    @Override
    public void saveUsuario(Usuario usuario) {
       iuserrepository.save(usuario);
    }

    @Override
    public void deleteUsuario(Long id) {
       iuserrepository.deleteById(id);
    }

    @Override
    public Usuario findUsuario(Long id) {
       return iuserrepository.findById(id).orElse(null);
    }

    @Override
    public Usuario editUsuario(Usuario usuario) {
        return iuserrepository.save(usuario);
    }
    
}
