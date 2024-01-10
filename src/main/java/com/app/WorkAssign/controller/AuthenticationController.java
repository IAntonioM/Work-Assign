package com.app.WorkAssign.controller;

import com.app.WorkAssign.dto.AuthenticationRequest;
import com.app.WorkAssign.dto.AuthenticationResponse;
import com.app.WorkAssign.dto.RegistrationRequest;
import com.app.WorkAssign.dto.RegistrationResponse;
import com.app.WorkAssign.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest authRequest){

        AuthenticationResponse jwtDto=authenticationService.login(authRequest);
        return ResponseEntity.ok(jwtDto);
    }
    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> register(@RequestBody @Valid RegistrationRequest registrationRequest){
        try {
            return ResponseEntity.ok(authenticationService.register(registrationRequest));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new RegistrationResponse(e.getMessage()));
        }
    }
    @GetMapping("/public-access")
    public String publicAccesEndPoint(){
        return "Este end point es public";
    }
}
