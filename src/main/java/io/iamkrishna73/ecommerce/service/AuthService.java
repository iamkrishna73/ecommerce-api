package io.iamkrishna73.ecommerce.service;

import io.iamkrishna73.ecommerce.Constant.LoggingConstant;
import io.iamkrishna73.ecommerce.entity.AppRole;
import io.iamkrishna73.ecommerce.entity.Role;
import io.iamkrishna73.ecommerce.entity.User;
import io.iamkrishna73.ecommerce.exception.ResourceNotFoundException;
import io.iamkrishna73.ecommerce.repositories.RoleRepository;
import io.iamkrishna73.ecommerce.repositories.UserRepository;
import io.iamkrishna73.ecommerce.request.SignUpRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class AuthService implements IAuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    @Override
    public void registerUser(SignUpRequest request) {
        var methodName = "AuthService:registerUser";
        log.info(LoggingConstant.START_METHOD_LOG, methodName, request.getUsername());
        if(userRepository.existsByUserName(request.getUsername())){
            log.error(LoggingConstant.ERROR_METHOD_LOG, methodName, " Username already exist");
            throw new ResourceNotFoundException("user not found");
        }
        if(userRepository.existsByEmail(request.getEmail())){
           log.error(LoggingConstant.ERROR_METHOD_LOG, methodName, " Email already exists");
           throw new ResourceNotFoundException("Email not found");
        }
        User user = new User(request.getUsername(), request.getEmail(), passwordEncoder.encode(request.getPassword()));

        Set<String> requestRoles = request.getRoles();
        Role role;
        if( requestRoles == null || requestRoles.isEmpty()) {
            role = roleRepository.findByRoleName(AppRole.ROLE_USER).orElseThrow(() -> {
                log.error(LoggingConstant.ERROR_METHOD_LOG, methodName, "role not found");
                throw new ResourceNotFoundException("role not found");
            });

        } else {
            String remainingRole = requestRoles.iterator().next();
            if (remainingRole.equalsIgnoreCase("admin")) {
                role = roleRepository.findByRoleName(AppRole.ROLE_USER).orElseThrow(() -> {
                    log.error(LoggingConstant.ERROR_METHOD_LOG, methodName, "role not found");
                    throw new ResourceNotFoundException("role not found");
                });

            } else {
                role = roleRepository.findByRoleName(AppRole.ROLE_USER).orElseThrow(() -> {
                    log.error(LoggingConstant.ERROR_METHOD_LOG, methodName, "role not found");
                    throw new ResourceNotFoundException("role not found");
                });
            }

        }
        user.setRole(role.getRoleName());
        log.info(LoggingConstant.END_METHOD_LOG, methodName);
         userRepository.save(user);
    }


}
