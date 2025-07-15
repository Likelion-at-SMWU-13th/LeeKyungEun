package com.likelion.seminar.student.controller;

import com.likelion.seminar.post.dto.PostDTO;
import com.likelion.seminar.student.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
@RequiredArgsConstructor
public class StudentController {
    private final List<StudentDTO> studentDTOList;

    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
        this.studentDTOList.add(studentDTO);
        return studentDTO;
    }

    @GetMapping
    public List<StudentDTO> getStudentAll() {
        return this.studentDTOList;
    }

    @GetMapping("{studentId}")
    public Object getStudent(@PathVariable("studentId") int studentId) {
        for (StudentDTO studentDTO : this.studentDTOList) {
            if (studentDTO.getStudentId() == studentId) {
                return studentDTO;
            }
        }
        return "해당 studentID를 가진 학생이 존재하지 않습니다.";
    }

    @PutMapping("{studentId}")
    public Object updateStudent(@PathVariable("studentId") int studentId, @RequestBody StudentDTO studentDTO) {
        StudentDTO student;

        for (StudentDTO s : this.studentDTOList) {
            if (s.getStudentId() == studentId) {
                student = s;

                if (studentDTO.getName() != null) {
                    student.setName(studentDTO.getName());
                }
                if (studentDTO.getDateOfBirth() != null) {
                    student.setDateOfBirth(studentDTO.getDateOfBirth());
                }
                return student;
            }
        }
        return "해당 studentID를 가진 학생이 존재하지 않습니다.";
    }

    @DeleteMapping("{studentId}")
    public long deleteStudent(@PathVariable("studentId") int studentId) {
        for (StudentDTO studentDTO : this.studentDTOList) {
            if (studentDTO.getStudentId() == studentId) {
                this.studentDTOList.remove(studentDTO);
                return studentId;
            }
        }
        return 0;
    }
}
