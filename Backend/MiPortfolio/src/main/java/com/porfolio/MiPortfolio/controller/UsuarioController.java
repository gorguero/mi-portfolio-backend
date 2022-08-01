
package com.porfolio.MiPortfolio.controller;

import com.porfolio.MiPortfolio.interfaces.IUsuarioService;
import com.porfolio.MiPortfolio.model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    
    @Autowired
    private IUsuarioService userService;
    
    @GetMapping ("/usuario/obtener")
    public List<Usuario> getUsuario(){
        return userService.getUsuario();
    }
    
    @PostMapping ("/usuario/crear")
    public String agregarUsuario(@RequestBody Usuario usuario){
        userService.saveUsuario(usuario);
        return "Se creado correctamente";
    }
    
    @DeleteMapping ("/usuario/borrar/{id}")
    public String eliminarUsuario(@PathVariable Long id){
        userService.deleteUsuario(id);
        return "Se ha eliminado correctamente";
    }
    
    @PutMapping ("/usuario/editar/{id}")
    public Usuario editarUsuario(@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("presentacionUno") String nuevoPresentacionUno,
                                @RequestParam("presentacionDos") String nuevoPresentacionDos,
                                @RequestParam("telefono") String nuevoTelefono,
                                @RequestParam("email") String nuevoEmail,
                                @RequestParam("ubicacion") String nuevoUbicacion,
                                @RequestParam("link_perfil") String nuevoPerfil,
                                @RequestParam("perfilLaboral") String nuevoPerfilLaboral){
        
        Usuario usuario = userService.findUsuario(id);
        
        usuario.setNombre(nuevoNombre);
        usuario.setApellido(nuevoApellido);
        usuario.setPresentacionUno(nuevoPresentacionUno);
        usuario.setPresentacionDos(nuevoPresentacionDos);
        usuario.setTelefono(nuevoTelefono);
        usuario.setEmail(nuevoEmail);
        usuario.setUbicacion(nuevoUbicacion);
        usuario.setLink_perfil(nuevoPerfil);
        usuario.setPerfilLaboral(nuevoPerfilLaboral);
        
        userService.saveUsuario(usuario);
        
        return usuario;
        
    }
    
}
