package com.sneivlp.sneivlpidentityservice.entity;

import com.sneivlpcommon.audit.BaseAuditEntity;
import com.sneivlpcommon.enums.CitizenStatus;
import com.sneivlpcommon.enums.Gender;
import com.sneivlpcommon.enums.VerificationStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "citizens")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Citizen extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "citizenId",unique = true,nullable = false)
    private String citizenId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @NonNull
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "aadhaar_reference")
    private String aadhaarReference;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CitizenStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "verification_status")
    private VerificationStatus verificationStatus;

    @OneToMany(mappedBy = "citizen",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<CitizenBiometric> biometrics;

    @OneToMany(mappedBy = "citizen",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<CitizenDocument> documents;

    @OneToMany(mappedBy = "citizen",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<CitizenVerification> verifications;


}



