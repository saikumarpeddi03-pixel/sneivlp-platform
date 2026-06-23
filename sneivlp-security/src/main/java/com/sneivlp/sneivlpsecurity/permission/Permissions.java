package com.sneivlp.sneivlpsecurity.permission;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permissions {

    CITIZEN_READ("citizen:read"),
    CITIZEN_WRITE("citizen:write"),

    ELECTION_READ("election:read"),
    ELECTION_WRITE("election:write"),

    VOTE_CAST("vote:cast"),

    AUDIT_READ("audit:read"),

    FRAUD_READ("fraud:read"),

    ADMIN_ACCESS("admin:access");

    private final String permission;
}
