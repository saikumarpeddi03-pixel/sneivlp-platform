package com.sneivlp.sneivlpidentityservice.dto.response;

import com.sneivlpcommon.enums.CitizenStatus;
import com.sneivlpcommon.enums.Gender;
import com.sneivlpcommon.enums.VerificationStatus;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CitizenResponse {

    private Long id;

    private String citizenId;

    private String firstName;

    private String middleName;

    private String lastName;

    private Gender gender;

    private LocalDate dateOfBirth;

    private String mobileNumber;

    private String email;

    private CitizenStatus status;

    private VerificationStatus verificationStatus;
}
