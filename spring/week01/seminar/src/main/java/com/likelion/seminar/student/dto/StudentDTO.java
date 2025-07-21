package com.likelion.seminar.student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class StudentDTO {
    private long studentId;
    private String name;
    private LocalDate dateOfBirth;
}
