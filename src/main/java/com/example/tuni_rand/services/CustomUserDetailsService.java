package com.example.tuni_rand.services;

import com.example.tuni_rand.domain.User;
import com.example.tuni_rand.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException("Could not find user");
        return user;
    }
    @Transactional
    public User loadUserById(Long id){
        User user =userRepository.getById(id);
        if (user==null) new UsernameNotFoundException("User not found");
        return user;
    }


}
