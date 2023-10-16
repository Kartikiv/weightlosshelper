package com.example.weightlosshelper.auth;

import com.example.weightlosshelper.entity.UserInformation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private UserInformation userInformation;
    private String token;
}
