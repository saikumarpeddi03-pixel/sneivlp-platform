package com.sneivlp.sneivlpidentityservice.entity;

import com.sneivlpcommon.audit.BaseAuditEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "citizen_documents")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CitizenDocument extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "document_number")
    private String documentNumber;

    @Column(name = "document_url")
    private String documentUrl;

    @Column(name = "verified")
    private Boolean verified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizen_id")
    private Citizen citizen;
}
