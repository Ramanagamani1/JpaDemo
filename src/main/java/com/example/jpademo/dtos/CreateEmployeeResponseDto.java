package com.example.jpademo.dtos;

import com.example.jpademo.models.Employee;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateEmployeeResponseDto {

    List<Employee> employees;

}
