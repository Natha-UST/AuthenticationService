package com.ust.emploDept.Service;

import com.ust.emploDept.entity.UserCridentialsEntity;
import com.ust.emploDept.repository.UserCredentialsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserCredentialsDao userCredentialsDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCridentialsEntity> user =userCredentialsDao.findByName(username);


        return user.map(CustomUserDetails ::new).orElseThrow(()-> new UsernameNotFoundException("username/password not found"));

    }
}
