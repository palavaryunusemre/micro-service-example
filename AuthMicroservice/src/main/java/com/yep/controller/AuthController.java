package com.yep.controller;

import com.yep.dto.request.LoginRequestDto;
import com.yep.dto.request.RegisterRequestDto;
import com.yep.entity.Auth;
import com.yep.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.yep.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTHSERVICE)
public class AuthController {
    private final AuthService authService;
    @PostMapping(REGISTER)
    public ResponseEntity<Auth> register(@RequestBody RegisterRequestDto dto){
        if(!dto.getPassword().equals((dto.getPassword())))
            throw new RuntimeException("Şifreler uyuşmuyor.");
        return ResponseEntity.ok(authService.register(dto));
    }
    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody LoginRequestDto dto) {
        return ResponseEntity.ok(authService.login(dto));

    }
}
