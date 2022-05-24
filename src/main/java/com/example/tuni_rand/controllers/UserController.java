package com.example.tuni_rand.controllers;


import com.example.tuni_rand.domain.Admin;
import com.example.tuni_rand.domain.Agent;
import com.example.tuni_rand.domain.Client;
import com.example.tuni_rand.validator.UserValidator;
import com.example.tuni_rand.domain.User;
import com.example.tuni_rand.payload.JWTLoginSucessReponse;
import com.example.tuni_rand.payload.LoginRequest;
import com.example.tuni_rand.security.JwtTokenProvider;
import com.example.tuni_rand.services.MapValidationErrorService;
import com.example.tuni_rand.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.example.tuni_rand.security.SecurityConstants.TOKEN_PREFIX;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {
    @Autowired
    private MapValidationErrorService mapValidationErrorService;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserValidator userValidator;


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = TOKEN_PREFIX + jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JWTLoginSucessReponse(true, jwt));
    }


    @PostMapping("/admin/register")
    public ResponseEntity<?> registerAdmin(@Valid @RequestBody Admin admin, BindingResult result){
        //validate password match
        userValidator.validate(admin,result);
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap!=null) return errorMap;
        Admin newAdmin= userService.saveAdmin(admin);
        return new ResponseEntity<Admin>(newAdmin, HttpStatus.CREATED);

    }
    @PostMapping("/agent/register")
    public ResponseEntity<?> registerAgent(@Valid @RequestBody Agent agent, BindingResult result){
        //validate password match
        userValidator.validate(agent,result);
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap!=null) return errorMap;
        Agent newAgent= userService.saveAgent(agent);
        return new ResponseEntity<Agent>(newAgent, HttpStatus.CREATED);

    }
    @PostMapping("/client/register")
    public ResponseEntity<?> registerClient(@Valid @RequestBody Client client, BindingResult result){
        //validate password match
        userValidator.validate(client,result);
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap!=null) return errorMap;
        Client newClient= userService.saveClient(client);
        return new ResponseEntity<Client>(newClient, HttpStatus.CREATED);

    }

}
