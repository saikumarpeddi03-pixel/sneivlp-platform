package com.sneivlp.sneivlpidentityservice.dto.request;

import com.sneivlpcommon.enums.Gender;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCitizenRequest {

    private String firstName;

    private String middleName;

    private String lastName;

    private Gender gender;

    private LocalDate dateOfBirth;

    private String mobileNumber;

    @Email(message = "Invalid email format")
    private String email;
}
