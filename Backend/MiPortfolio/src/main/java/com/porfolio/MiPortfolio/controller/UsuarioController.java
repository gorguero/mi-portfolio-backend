
package com.porfolio.MiPortfolio.controller;

import com.porfolio.MiPortfolio.interfaces.IUsuarioService;
import com.porfolio.MiPortfolio.model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    
    @Autowired
    private IUsuarioService userService;
    
    @GetMapping ("/usuario/obtener")
    public List<Usuario> getUsuario(){
        return userService.getUsuario();
    }
    
    @PutMapping ("/usuario/editar/{id}")
    public Usuario editarUsuario(@PathVariable Long id,
                                @RequestParam ("nombre") String nuevoNombre,
                                @RequestParam ("apellido") String nuevoApellido,
                                @RequestParam ("presentacion") String nuevoPresentacion,
                                @RequestParam ("telefono") String nuevoTelefono,
                                @RequestParam ("email") String nuevoEmail,
                                @RequestParam ("ubicacion") String nuevoUbicacion,
                                @RequestParam ("link_perfil") String nuevoPerfil){
        
        Usuario usuario = userService.findUsuario(id);
        
        usuario.setNombre(nuevoNombre);
        usuario.setApellido(nuevoApellido);
        usuario.setPresentacion(nuevoPresentacion);
        usuario.setTelefono(nuevoTelefono);
        usuario.setEmail(nuevoEmail);
        usuario.setUbicacion(nuevoUbicacion);
        usuario.setLink_perfil(nuevoPerfil);
        
        userService.saveUsuario(usuario);
        
        return usuario;
        
    }
    
}
