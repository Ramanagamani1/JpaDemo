package com.example.jpademo.dtos;

import com.example.jpademo.models.Admin;
import javax.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateAdminRequestDto {

    @NotBlank
    private String name;

    public Admin to() {
        return Admin.builder()
                .name(this.name)
                .build();
    }
}
