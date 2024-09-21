package io.iamkrishna73.ecommerce.service;

import io.iamkrishna73.ecommerce.entity.User;
import io.iamkrishna73.ecommerce.request.SignUpRequest;

public interface IAuthService {
    void registerUser(SignUpRequest request);
}
