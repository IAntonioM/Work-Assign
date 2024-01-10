package com.app.WorkAssign.service;

import com.app.WorkAssign.dto.AuthenticationRequest;
import com.app.WorkAssign.dto.AuthenticationResponse;
import com.app.WorkAssign.dto.RegistrationRequest;
import com.app.WorkAssign.dto.RegistrationResponse;
import com.app.WorkAssign.persistence.entity.User;
import com.app.WorkAssign.persistence.repository.UserRepository;
import com.app.WorkAssign.persistence.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public AuthenticationResponse login(AuthenticationRequest authRequest){
        UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(),authRequest.getPassword()
        );
        authenticationManager.authenticate(authToken);
        User user=userRepository.findByUsername(authRequest.getUsername()).get();
        String jwt=jwtService.generateToken(user,generateExtraClaims(user));
        return new AuthenticationResponse(jwt);

    }

    private Map<String, Object> generateExtraClaims(User user) {
        Map<String,Object> extraClaims=new HashMap<>();
        extraClaims.put("name",user.getName());
        extraClaims.put("role",user.getRole());
        extraClaims.put("permissions",user.getAuthorities());
        return extraClaims;
    }

    public RegistrationResponse register(RegistrationRequest registrationRequest) {
        if(userRepository.existsByUsername(registrationRequest.getUsername())){
            return new RegistrationResponse("Username already exits");
        }
        User user=new User();
        user.setUsername(registrationRequest.getUsername());
        user.setName(registrationRequest.getName());
        user.setPassword(passwordEncoder.encode( registrationRequest.getPassword()));
        user.setRole(Role.CUSTOMER);
        userRepository.save(user);
        return new RegistrationResponse("Registration  success");
    }
}

