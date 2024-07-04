package by.bsu.mysummerproj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {
    @GetMapping("/register")
    public String getRegisterForm () {
        return "auth/register";
    }
}
