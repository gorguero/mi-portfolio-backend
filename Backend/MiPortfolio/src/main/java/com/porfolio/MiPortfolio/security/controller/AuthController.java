
package com.porfolio.MiPortfolio.security.controller;

import com.porfolio.MiPortfolio.security.Entity.Rol;
import com.porfolio.MiPortfolio.security.Entity.Usuario;
import com.porfolio.MiPortfolio.security.Enums.RolNombre;
import com.porfolio.MiPortfolio.security.dto.JwtDto;
import com.porfolio.MiPortfolio.security.dto.LoginUsuario;
import com.porfolio.MiPortfolio.security.dto.NuevoUsuario;
import com.porfolio.MiPortfolio.security.jwt.JwtProvider;
import com.porfolio.MiPortfolio.security.service.RolService;
import com.porfolio.MiPortfolio.security.service.UsuarioService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    AuthenticationManager authManager;
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    RolService rolService;
    
    @Autowired
    JwtProvider jwtProvider;
    
    /* Crea un usuario nuevo */
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos o email invalido"), HttpStatus.BAD_REQUEST);
        
        if(usuarioService.existByNickname(nuevoUsuario.getNickname()))
            return new ResponseEntity(new Mensaje("Este nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        
        if(usuarioService.existByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("Email existente"), HttpStatus.BAD_REQUEST);
        
        Usuario usuario = new Usuario(nuevoUsuario.getName(), nuevoUsuario.getNickname(), nuevoUsuario.getEmail(),
                                passwordEncoder.encode(nuevoUsuario.getPassword()));
        
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolName(RolNombre.ROLE_USER).get());
        
        if(nuevoUsuario.getRoles().contains("admin")){
            roles.add(rolService.getByRolName(RolNombre.ROLE_ADMIN).get());
        }
        
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        
        return new ResponseEntity(new Mensaje("Usuario guardado"), HttpStatus.CREATED);
    }
    
    
    /* Login para el usuario */
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Validated @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);
        
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(
                                            loginUsuario.getNickname(), loginUsuario.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto, HttpStatus.OK);
        
    }
    
}
