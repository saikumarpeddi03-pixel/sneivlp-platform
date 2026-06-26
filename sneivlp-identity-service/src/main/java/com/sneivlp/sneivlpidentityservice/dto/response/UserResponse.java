package com.sneivlp.sneivlpidentityservice.dto.response;

import com.sneivlp.sneivlpsecurity.role.Role;
import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
public class UserResponse {

    private Long  id;

    public UserResponse(Long id, String userName, String email,Role role) {
        this.id = id;
        this.userName = userName;
        this.role = role;
        this.email = email;
    }

    private String userName;

    private Role role;

    private String email;

}
