package com.CarSelling.project.Config;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // Implémentez la logique d'authentification personnalisée ici
        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true; // Cette méthode indique quels types d'objets d'authentification ce fournisseur prend en charge
    }
}
