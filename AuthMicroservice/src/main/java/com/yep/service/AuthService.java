package com.yep.service;

import com.yep.dto.request.LoginRequestDto;
import com.yep.dto.request.RegisterRequestDto;
import com.yep.entity.Auth;
import com.yep.respository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository repository;

    public Auth register(RegisterRequestDto dto) {
        return repository.save(Auth.builder()
                .userName(dto.getUserName())
                .email(dto.getEmail())
                .password(dto.getPassword())
        .build());
    }

    public Boolean login(LoginRequestDto dto) {
        return repository.existsByUserNameAndPassword(dto.getUserName(), dto.getPassword());
    }
}
