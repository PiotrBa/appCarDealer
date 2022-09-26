package com.example.demoCarDealer.registration;


import com.example.demoCarDealer.appUser.AppUser;
import com.example.demoCarDealer.appUser.AppUserRole;
import com.example.demoCarDealer.appUser.AppUserservice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterService {


    private final EmailValidator emailValidator;
    private final AppUserservice appUserservice;


    public String register (RegisterRequest request){
        boolean emailIsValid = emailValidator.test(request.getEmail());
        if (!emailIsValid){
            throw new IllegalStateException("Email is not exist.");
        }
        return appUserservice.signUpUser(new AppUser(
                request.getFirstNameOfDealer(),
                request.getLastNameOfdealer(),
                request.getEmail(),
                request.getPassword(),
                AppUserRole.USER
        ));

    }
}
