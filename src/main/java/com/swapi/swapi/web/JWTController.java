package com.swapi.swapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swapi.swapi.error.AuthenticationFailedException;
import com.swapi.swapi.service.TokenManagerService;
import com.swapi.swapi.web.dto.JWTRequest;
import com.swapi.swapi.web.dto.JWTResponse;



@RestController
public class JWTController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private TokenManagerService tokenManagerService;

    @Autowired
    private AuthenticationManager authenticationManager;



    @PostMapping("/token")
    public ResponseEntity<com.swapi.swapi.web.dto.JWTResponse> obtainToken(
            @RequestBody JWTRequest request) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getUsername(), request.getPassword()));
        } catch (DisabledException e) {
            throw new AuthenticationFailedException("USER_DISABLED");
        } catch (BadCredentialsException e) {
            throw new AuthenticationFailedException("INVALID_CREDENTIALS");
        }

        final UserDetails userDetails =
                userDetailsService.loadUserByUsername(request.getUsername());
        final String jwtToken = tokenManagerService.generateJwtToken(userDetails);
        return ResponseEntity.ok(JWTResponse.builder().token(jwtToken.toString()).build());
    }

}
