package org.dav.ndw.interview.tickets.service;

import org.dav.ndw.interview.tickets.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TicketService ticketService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Client client = ticketService.getClientByLogin(s);

        if (client == null)
            throw new UsernameNotFoundException("There's not such client.");

        //TODO: set the real roles from DB here.
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority("USER"));

        UserDetails userDetails = new User(client.getLogin(), "{noop}" + client.getPassword(), roles);

        return userDetails;
    }
}
