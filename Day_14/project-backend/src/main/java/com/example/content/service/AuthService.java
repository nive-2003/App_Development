package com.example.content.service;

import com.example.content.dto.request.AuthenticationRequest;
import com.example.content.dto.request.RegisterRequest;
import com.example.content.dto.response.AuthenticationResponse;

public interface AuthService {
    boolean userRegistration(RegisterRequest request);

    AuthenticationResponse userAuthentication(AuthenticationRequest request);
}
