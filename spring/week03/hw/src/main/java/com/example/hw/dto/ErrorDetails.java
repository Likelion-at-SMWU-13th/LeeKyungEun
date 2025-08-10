package com.example.hw.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDetails {

    private String message;

}
