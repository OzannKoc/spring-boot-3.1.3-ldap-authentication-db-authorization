package com.security.ldap.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class LdapProvider implements AuthenticationProvider {
    private static Map<String,String> ldapStore = new HashMap<>();
    static {
        ldapStore.put("user1@mail.com","password1");
        ldapStore.put("user2@mail.com","password2");
        ldapStore.put("user3@mail.com","password3");
        ldapStore.put("user4@mail.com","password4");
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
        // need check from ldapStore or your own ldap server
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("USER"));
        return new UsernamePasswordAuthenticationToken(email,password,roles);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
