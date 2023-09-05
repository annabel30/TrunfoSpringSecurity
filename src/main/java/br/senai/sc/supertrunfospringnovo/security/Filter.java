package br.senai.sc.supertrunfospringnovo.security;

import br.senai.sc.supertrunfospringnovo.business.model.entity.Player;
import br.senai.sc.supertrunfospringnovo.security.util.CookieUtil;
import br.senai.sc.supertrunfospringnovo.security.util.JWTUtil;
import com.auth0.jwt.exceptions.JWTDecodeException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.Authentication;

import java.io.IOException;

public class Filter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        if (privateRoute(request.getRequestURI())) {
            try {
                String token = CookieUtil.getToken(request);
                System.out.println(token);
                Player user = JWTUtil.getUser(token);
                System.out.println(user);
                response.addCookie(CookieUtil.generateCookie(user));

                Authentication authentication = new
                        UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (JWTDecodeException e) {
                System.out.println("O token é inválido!");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            } catch (CookieNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        filterChain.doFilter(request, response);
    }

    private boolean privateRoute(String url) {
        return url.startsWith("/test/auth");
    }
}