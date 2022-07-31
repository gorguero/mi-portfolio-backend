
package com.porfolio.MiPortfolio.controller;

import com.porfolio.MiPortfolio.interfaces.IUsuarioService;
import com.porfolio.MiPortfolio.model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    
    @Autowired
    private IUsuarioService userService;
    
    @GetMapping ("/usuario/obtener")
    public List<Usuario> getUsuario(){
        return userService.getUsuario();
    }
    
    
}
