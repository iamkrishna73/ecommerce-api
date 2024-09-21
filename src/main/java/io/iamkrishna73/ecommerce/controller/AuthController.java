package io.iamkrishna73.ecommerce.controller;

import io.iamkrishna73.ecommerce.Constant.LoggingConstant;
import io.iamkrishna73.ecommerce.request.SignUpRequest;
import io.iamkrishna73.ecommerce.service.IAuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
@Slf4j
public class AuthController {
    private final IAuthService authService;

    public ResponseEntity<?> registerUser(SignUpRequest request) {
        var methodName = "AuthController:registerUser";
        log.info(LoggingConstant.START_METHOD_LOG, methodName, request.getUsername());
        authService.registerUser(request);
        log.info(LoggingConstant.END_METHOD_LOG, methodName);
        return new ResponseEntity<>("user successfully register", HttpStatus.OK);
    }


}
