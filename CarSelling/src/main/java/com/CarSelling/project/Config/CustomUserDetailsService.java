package com.CarSelling.project.Config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Implémentez la logique pour charger les détails de l'utilisateur depuis votre source de données (par exemple, base de données)
        // Retournez une implémentation de UserDetails
        // Assurez-vous que cette classe est annotée avec @Service pour que Spring la détecte en tant que bean
        // ou configurez-la manuellement dans votre fichier de configuration Spring
        // (par exemple, avec @Bean dans une classe de configuration)
        return null;
    }
}
