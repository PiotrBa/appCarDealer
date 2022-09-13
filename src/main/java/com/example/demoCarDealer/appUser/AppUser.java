package com.example.demoCarDealer.appUser;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class AppUser implements UserDetails {


    @SequenceGenerator(sequenceName = "dealer_sequence", name = "dealer_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dealer_sequence")
    @Id
    private Long id;
    private String firstNameOfDealer;
    private String lastNameOfDealer;
    private String password;
    private String email;
    private String carBrand;
    private String carModel;
    private String carColor;
    private String typeOfGearbox;
    private String carYear;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private Boolean locked;
    private Boolean enabled;


    public AppUser(String firstNameOfDealer, String lastNameOfDealer, String password, String email,
                   AppUserRole appUserRole) {
        this.firstNameOfDealer = firstNameOfDealer;
        this.lastNameOfDealer = lastNameOfDealer;
        this.password = password;
        this.email = email;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carColor = carColor;
        this.typeOfGearbox = typeOfGearbox;
        this.carYear = carYear;
        this.appUserRole = appUserRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
