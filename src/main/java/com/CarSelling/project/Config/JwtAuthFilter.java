package com.CarSelling.project.Config;

import java.io.IOException;

import com.CarSelling.project.authentification.JwtGenerator;
import com.CarSelling.project.entity.UtilisateurEntity;
import com.CarSelling.project.service.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private  JwtService jwtService;
    @Autowired
    private JwtGenerator jwtGenerator;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UtilisateurService utilisateurService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String jwt;
        String idUser;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            jwt = authHeader.substring(7);
            idUser = jwtService.extractUsername(jwt);
            if (idUser != null &&
                    SecurityContextHolder.getContext().getAuthentication() == null) {
                        System.out.println(idUser);
                UtilisateurEntity util = this.utilisateurService.findUserById(Integer.valueOf(idUser));

                //User user = (User) this.userDetailsService.loadUserByUsername(userEmail);
                if (jwtService.isTokenValid(jwt, util)) {
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(util,
                            null,
                            util.getAuthorities());

                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        } catch (ExpiredJwtException e) {
            // Gérer l'exception d'expiration du token ici
            System.out.println("Token expiré"); 
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Token expiré");
        } catch (JwtException e) {
            // Gérer les autres exceptions JWT ici
            System.out.println("Erreur JWT : " + e.getMessage());
        } catch (Exception e) {
            // Gérer les autres exceptions ici
            System.out.println("Erreur : " + e.getMessage());
        }
        filterChain.doFilter(request, response);

    }


    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

}
