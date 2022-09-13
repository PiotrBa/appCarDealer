package com.example.demoCarDealer.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class RegisterRequest {


    private String firstNameOfDealer;
    private String lastNameOfdealer;
    private String password;
    private String email;


}
