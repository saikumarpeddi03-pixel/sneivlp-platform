package com.sneivlp.sneivlpidentityservice.entity;

import com.sneivlpcommon.audit.BaseAuditEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="refresh_tokens")
@NoArgsConstructor
@AllArgsConstructor
public class RefreshToken extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true,length =500)
    private String token;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    private LocalDateTime expiryDate;

    private Boolean revoked;
}
