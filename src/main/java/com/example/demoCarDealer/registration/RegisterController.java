package com.example.demoCarDealer.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class RegisterController {


    private final RegisterService registerService;


    @PostMapping("/register")
    public String register (@RequestBody RegisterRequest request){
        return registerService.register(request);
    }
}
