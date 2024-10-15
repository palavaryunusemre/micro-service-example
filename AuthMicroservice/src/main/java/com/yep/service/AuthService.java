package com.yep.service;

import com.yep.dto.request.CreateUserRequestDto;
import com.yep.dto.request.LoginRequestDto;
import com.yep.dto.request.RegisterRequestDto;
import com.yep.entity.Auth;
import com.yep.manager.UserProfileManager;
import com.yep.respository.AuthRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository repository;
    private final UserProfileManager userProfileManager;

    @Transactional
    public Auth register(RegisterRequestDto dto) {
        Auth auth = repository.save(Auth.builder()
                .userName(dto.getUserName())
                .email(dto.getEmail())
                .password(dto.getPassword())
        .build());
        userProfileManager.createUser(CreateUserRequestDto.builder()
                        .authId(auth.getId())
                        .email(auth.getEmail())
                        .username(auth.getUserName())
                .build());
        return auth;
    }

    public Boolean login(LoginRequestDto dto) {
        return repository.existsByUserNameAndPassword(dto.getUserName(), dto.getPassword());
    }
}
