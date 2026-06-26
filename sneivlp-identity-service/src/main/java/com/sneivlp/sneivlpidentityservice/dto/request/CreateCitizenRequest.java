package com.sneivlp.sneivlpidentityservice.dto.request;

import com.sneivlpcommon.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCitizenRequest {

    @NotBlank(message = "First name is required")
    private String firstName;

    private String middleName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotNull(message = "Gender is required")
    private Gender gender;

    @NotNull(message = "Date of birth is required")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Mobile number is required")
    private String mobileNumber;

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Aadhaar reference is required")
    private String aadhaarReference;
}
