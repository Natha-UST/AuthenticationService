package com.ust.emploDept.Service;

import com.ust.emploDept.entity.UserCridentialsEntity;
import com.ust.emploDept.repository.UserCredentialsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialsService {
    @Autowired
    UserCredentialsDao authDao;
    @Autowired
    JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public UserCridentialsEntity register(UserCridentialsEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return authDao.saveAndFlush(user);
    }
    public boolean verify(String token){
        jwtService.validateToken(token);
        return true;
    }
    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }


}
