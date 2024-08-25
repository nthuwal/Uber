package com.project.uber.uberApp.services;

import com.project.uber.uberApp.dto.DriverDto;
import com.project.uber.uberApp.dto.SignUpDto;
import com.project.uber.uberApp.dto.UserDto;

public interface AuthService {
    String[] login(String email,String password);
    String refreshToken(String refreshToken);
    UserDto signUp(SignUpDto signUpDto);
    DriverDto onboardNewDriver(Long userId, String vehicleId);
}
