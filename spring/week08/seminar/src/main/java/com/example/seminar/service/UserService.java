package com.example.seminar.service;

import com.example.seminar.dto.SignupRequestDto;
import com.example.seminar.entity.User;
import com.example.seminar.exception.CustomException;
import com.example.seminar.exception.HttpStatus;
import com.example.seminar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void signUp(SignupRequestDto signupRequestDto) {

        String username = signupRequestDto.getUsername();
        if (userRepository.existsByUsername(username))
            throw new CustomException(HttpStatus.USERNAME_DUPLICATED);

        String email = signupRequestDto.getEmail();
        if (!email.endsWith("@sookmyung.ac.kr"))
            throw new CustomException(HttpStatus.INVALID_EMAIL_DOMAIN);

        String password1 = signupRequestDto.getPassword1();
        String password2 = signupRequestDto.getPassword2();
        if (!password1.equals(password2))
            throw new CustomException(HttpStatus.PASSWORD_CONFIRM_MISMATCH);

        User user = User.builder()
                .username(username)
                .email(email)
                .password(password1).build();

        userRepository.save(user);

    }
}
