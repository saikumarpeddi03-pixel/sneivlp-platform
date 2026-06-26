package com.sneivlp.sneivlpidentityservice.entity;


import com.sneivlpcommon.audit.BaseAuditEntity;
import com.sneivlpcommon.enums.BiometricType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "citizen_biometrics")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CitizenBiometric extends com.sneivlpcommon.audit.BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "biometric_type")
    private BiometricType biometricType;

    @Column(name = "biometric_hash", length = 500)
    private String biometricHash;

    @Column(name = "verified")
    private Boolean verified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizen_id")
    private Citizen citizen;
}
