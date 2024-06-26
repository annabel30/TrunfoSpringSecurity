package br.senai.sc.supertrunfospringnovo.security.controller;

import br.senai.sc.supertrunfospringnovo.security.model.Login;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/")
    public ResponseEntity<?> login(@RequestBody
                                       Login login, HttpServletRequest request, HttpServletResponse response){
        SecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        if (authentication.isAuthenticated()){
            SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
            securityContext.setAuthentication(authentication);
            securityContextRepository.saveContext(securityContext, request, response);
            return ResponseEntity.ok(authentication.getPrincipal());
        }
        return ResponseEntity.status(401).build();
    }
}
