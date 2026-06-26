package com.sneivlp.sneivlpidentityservice.entity;

import com.sneivlp.sneivlpsecurity.role.Role;
import com.sneivlpcommon.audit.BaseAuditEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="users")
@Data
@RequiredArgsConstructor
public class User extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private Boolean accountLocked;

    private Boolean accountEnabled;

    private LocalDateTime lastLogin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private Role role;
}
