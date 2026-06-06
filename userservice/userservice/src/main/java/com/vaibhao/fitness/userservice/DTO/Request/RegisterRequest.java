package com.vaibhao.fitness.userservice.DTO.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank(message = "email required")
    @Email(message = "Invalid format")
    private String email;
    @NotBlank(message = "password required")
    private String password;
    private String firstName;
    private String lastName;
}
