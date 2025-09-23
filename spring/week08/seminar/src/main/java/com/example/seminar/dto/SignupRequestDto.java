package com.example.seminar.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupRequestDto {

    @NotBlank
    @Size(max = 20, message = "아이디는 20자 이하여야 합니다.")
    private String username;

    @NotBlank
    @Email(message = "잘못된 이메일 형식입니다.")
    @Size(max = 50, message = "이메일은 50자 이하여야 합니다.")
    private String email;

    @NotBlank
    @Size(min = 8, max = 20)
    private String password1;

    @NotBlank
    @Size(min = 8, max = 20)
    private String password2;

}
