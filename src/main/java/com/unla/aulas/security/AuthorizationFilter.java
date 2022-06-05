package com.unla.aulas.security;

import com.unla.aulas.entity.UserEntity;
import com.unla.aulas.service.UserEntityAuthService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static com.unla.aulas.security.SecurityConstants.HEADER_NAME;
import static com.unla.aulas.security.SecurityConstants.KEY;

public class AuthorizationFilter extends BasicAuthenticationFilter {


    UserEntityAuthService userEntityAuthService;
    public AuthorizationFilter(AuthenticationManager authManager, UserEntityAuthService userEntityAuthService ) {
        super(authManager);
     this.userEntityAuthService = userEntityAuthService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(HEADER_NAME);

        if (header == null) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = authenticate(request);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken authenticate(HttpServletRequest request) {
        String token = request.getHeader(HEADER_NAME);
        if (token != null) {
            Claims user = Jwts.parser()
                    .setSigningKey(Keys.hmacShaKeyFor(KEY.getBytes()))
                    .parseClaimsJws(token)
                    .getBody();


            if (user != null) {
                UserDetails userDetails = userEntityAuthService.loadUserByUsername((String)user.get("sub"));
                return new UsernamePasswordAuthenticationToken(user, null, userDetails.getAuthorities());
            }else{
                return  null;
            }

        }
        return null;
    }
}