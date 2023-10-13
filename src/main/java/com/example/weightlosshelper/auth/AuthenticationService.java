package com.example.weightlosshelper.auth;

import com.example.weightlosshelper.configuration.JwtService;
import com.example.weightlosshelper.dao.UserInformationRepository;
import com.example.weightlosshelper.entity.Role;
import com.example.weightlosshelper.entity.UserInformation;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserInformationRepository userInformationRepository;
    private  final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private  final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        UserInformation user= UserInformation.builder()
                .userName(registerRequest.getUserName())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();

        userInformationRepository.save(user);

         var jwtToken=jwtService.generateToken(user);



    return  new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) throws Exception {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUserName(),
                        authenticationRequest.getPassword()
                )
        );

        var user = userInformationRepository.findByUserName(authenticationRequest.getUserName()).orElseThrow(Exception::new);
        var jwtToken=jwtService.generateToken(user);
        return  new AuthenticationResponse(jwtToken);
    }
}
