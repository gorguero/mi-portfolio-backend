
package com.porfolio.MiPortfolio.interfaces;

import com.porfolio.MiPortfolio.model.Usuario;
import java.util.List;


public interface IUsuarioService {
    
    List<Usuario> getUsuario();
    
    public void saveUsuario();
    
    public void deleteUsuario();
    
    public Usuario findUsuario(Long id);
    
    public Usuario editUsuario(Usuario usuario);
    
}
