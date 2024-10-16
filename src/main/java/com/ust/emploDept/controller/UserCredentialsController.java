package com.ust.emploDept.controller;

import com.ust.emploDept.Service.JwtService;
import com.ust.emploDept.Service.UserCredentialsService;
import com.ust.emploDept.entity.UserCridentialsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserCredentialsController {
    @Autowired
    public UserCredentialsService userCredentialsService;
    @Autowired
    public JwtService jwtService;
    @Autowired
    public AuthenticationManager authenticationManager;
    @PostMapping("/register")
    public UserCridentialsEntity register(@RequestBody UserCridentialsEntity user){
        return userCredentialsService.register(user);
    }
    @GetMapping("/validate/user")
            public String getToken(@RequestBody UserCridentialsEntity user){
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));
        if(authenticate.isAuthenticated()){
            return jwtService.generateToken(user.getName());
        }
            return null;


    }
    @GetMapping("/validate/token")
    public boolean validateToken(@RequestParam String token){
        return userCredentialsService.verify(token);
    }

}
