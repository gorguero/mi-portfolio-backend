
package com.porfolio.MiPortfolio.controller;

import com.porfolio.MiPortfolio.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    
    @Autowired
    private IUsuarioService userService;
    
    
    
}
