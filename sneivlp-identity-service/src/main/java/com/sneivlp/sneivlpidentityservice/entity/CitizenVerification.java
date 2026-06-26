package com.sneivlp.sneivlpidentityservice.entity;

import com.sneivlpcommon.audit.BaseAuditEntity;
import com.sneivlpcommon.enums.VerificationStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "citizen_verifications")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CitizenVerification extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "verification_status")
    private VerificationStatus verificationStatus;

    @Column(name = "verified_by")
    private String verifiedBy;

    @Column(name = "verified_date")
    private LocalDateTime verifiedDate;

    @Column(name = "remarks")
    private String remarks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizen_id")
    private Citizen citizen;
}
