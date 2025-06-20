package com.securityjwt.secjwtoauth2.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class HttpController {

    @GetMapping("/public")
     public String publicRoute() {
        return "<h1>Public Route </h1><p>This route is accessible to everyone.</p>";
        
    }

    @GetMapping("/private")
    public String privateRoute(@AuthenticationPrincipal OidcUser principal) {
        //return "<h1>Private Route </h1><p>This route is accessible only to authenticated users.</p>";
        return String.format("""
            <h1>Public Route <p>This route is accessible to everyone</h1>
            <h3>Principal : %s</h3>
            <h3>Email attribute : %s</h3>
            <h3>Authorities : %s</h3>
            <h3>JWT: %s</h3>
            """, principal, principal.getAttribute("email"),
            principal.getAuthorities(),
            principal.getIdToken().getTokenValue());
            
            
    }  
    
    @GetMapping("/cookie")
    public String cookie(@AuthenticationPrincipal OidcUser principal) {
        //return "<h1>Private Route </h1><p>This route is accessible only to authenticated users.</p>";
        return String.format("""
            <h1>Public Route <p>This route is accessible to everyone</h1>
            <h3>Principal : %s</h3>
            <h3>Email attribute : %s</h3>
            <h3>Authorities : %s</h3>
            <h3>JWT: %s</h3>
            """, principal, principal.getAttribute("email"),
            principal.getAuthorities(),
            principal.getIdToken().getTokenValue());
            
    }   
    @GetMapping("/JWT")
    String JWT(@AuthenticationPrincipal Jwt jwt) {
        return String.format("""
            Principal: %s\n
            Email attribute: %s\n
            JWT: %s
                """,jwt.getClaims(), jwt.getClaim("email"),
            jwt.getTokenValue());
    }
    

}
