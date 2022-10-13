package com.example.demoCarDealer.appUser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserservice implements UserDetailsService {



    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).orElseThrow(()-> new IllegalStateException("Email not found"));
    }


    public String signUpUser (AppUser appUser){
        boolean emailIsExist = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
        if (emailIsExist){
            throw new IllegalStateException("Email is already taken!");
        }
        String encoderPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encoderPassword);
        appUserRepository.save(appUser);

        return encoderPassword;
    }

}
