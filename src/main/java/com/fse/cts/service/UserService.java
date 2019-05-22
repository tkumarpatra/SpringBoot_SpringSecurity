package com.fse.cts.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.fse.cts.model.User;
import com.fse.cts.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);

    User saveUser(User user);
}
