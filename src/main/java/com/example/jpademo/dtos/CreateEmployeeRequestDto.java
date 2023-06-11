package com.example.jpademo.dtos;

import com.example.jpademo.models.Employee;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateEmployeeRequestDto {

    @NotBlank
    private String name;

    @Max(60)
    @NotNull
    private Integer age;

    private String address;

    private String country;

    private Integer yearsOfExp;


    public Employee to() {
        return Employee.builder()
                .age(this.age)
                .name(this.name)
                .address(this.address)
                .country(this.country)
                .yearsOfExp(this.yearsOfExp)
                .build();
    }
}
