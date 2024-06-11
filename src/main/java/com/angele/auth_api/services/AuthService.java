package com.angele.auth_api.services;

import com.angele.auth_api.dto.LoginDto;
import com.angele.auth_api.dto.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto) throws Exception;
    void register(RegisterDto registerDto);
}
