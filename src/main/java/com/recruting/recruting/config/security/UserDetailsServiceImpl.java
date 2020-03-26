package com.recruting.recruting.config.security;

import com.recruting.recruting.models.user.User;
import com.recruting.recruting.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        login = login.toLowerCase();
        User user = userRepository.getUserByLogin(login);
        if(user == null){
            throw new UsernameNotFoundException(login);
        }
        Set<GrantedAuthority> grantedAuthorities = solveAuthorities(user);
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                grantedAuthorities
        );
    }

    //todo
    private Set<GrantedAuthority> solveAuthorities(User user) {
//        return user.getRoles()
//                .stream()
//                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
//                .collect(Collectors.toSet());
        return Set.of(new SimpleGrantedAuthority("ROLE_USER"));
    }
}