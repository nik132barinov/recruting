package com.recruting.recruting.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@RequiredArgsConstructor
public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) {
//        super.unsuccessfulAuthentication(request, response, failed);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        try( PrintWriter writer = response.getWriter()) {
            writer.println("Bad credentials");
        } catch (IOException ignore) {
        }
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        Map<String, Object> stringObjectMap = extractDataToMap(request);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = getAuthToken(stringObjectMap);
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        if (authenticate.isAuthenticated()) {
            SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
            securityContext.setAuthentication(authenticate);
            SecurityContextHolder.setContext(securityContext);
            rememberUser(request, response, stringObjectMap);
        }
        return authenticate;
    }

    private Map<String, Object> extractDataToMap(HttpServletRequest request) {
        Map<String, Object> stringObjectMap = null;
        try {
            stringObjectMap = new BasicJsonParser().parseMap(request.getReader().readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringObjectMap;
    }

    private UsernamePasswordAuthenticationToken getAuthToken(Map<String, Object> stringObjectMap) {
        return new UsernamePasswordAuthenticationToken(stringObjectMap.get("login"), stringObjectMap.get("password"));
    }

    private void rememberUser(HttpServletRequest request, HttpServletResponse response, Map<String, Object> stringObjectMap) {
        if (stringObjectMap.get("remember").equals("true")) {
            Cookie[] cookies = request.getCookies();
            for (Cookie value : cookies) {
                if (value.getName().equals("SESSION")) {
                    value.setMaxAge(Integer.MAX_VALUE);
                    response.addCookie(value);
                    break;
                }
            }
        }
    }

}
