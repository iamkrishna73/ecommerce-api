package io.iamkrishna73.ecommerce.service;

import io.iamkrishna73.ecommerce.Constant.LoggingConstant;
import io.iamkrishna73.ecommerce.dto.ChangePasswordRequest;
import io.iamkrishna73.ecommerce.entity.Role;
import io.iamkrishna73.ecommerce.entity.User;
import io.iamkrishna73.ecommerce.exception.ResourceNotFoundException;
import io.iamkrishna73.ecommerce.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        var methodName = "UserService:registerUser";
        log.info(LoggingConstant.START_METHOD_LOG, methodName, user.getUsername());

        if(userRepository.findByEmail(user.getEmail()).isPresent()) {
            log.info(LoggingConstant.ERROR_METHOD_LOG, methodName, user.getEmail() + "that email Already exists");
            throw new IllegalStateException("Email Already exists");

        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        log.info(LoggingConstant.END_METHOD_LOG, methodName);
        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        var methodName = "UserService:getUserByEmail";
        log.info(LoggingConstant.START_METHOD_LOG, methodName, email);
        User user =userRepository.findByEmail(email).orElseThrow(() -> {
            log.error(LoggingConstant.ERROR_METHOD_LOG, methodName, email);
            throw new ResourceNotFoundException("User not found");
        }
        );
        log.info(LoggingConstant.END_METHOD_LOG, methodName);
        return user ;
    }

    public void changePassword(String email, ChangePasswordRequest request) {
        var methodName = "UserService:changePassword";
        log.info(LoggingConstant.START_METHOD_LOG, methodName, email);
        User user = getUserByEmail(email);
        if(!passwordEncoder.matches(user.getPassword(), request.getCurrentPassword())) {
            log.error(LoggingConstant.ERROR_METHOD_LOG, methodName, user.getEmail() + "current password not match");
            throw new BadCredentialsException("Password mis match");
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        log.info(LoggingConstant.END_METHOD_LOG, methodName);
        userRepository.save(user);
    }



}
