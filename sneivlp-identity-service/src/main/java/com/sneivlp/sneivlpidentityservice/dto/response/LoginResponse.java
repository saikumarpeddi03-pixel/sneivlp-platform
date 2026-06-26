package com.sneivlp.sneivlpidentityservice.dto.response;

import com.sneivlp.sneivlpsecurity.role.Role;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

   private String accessToken;

   private String tokenType;

   private String userName;

   private Role role;

}
