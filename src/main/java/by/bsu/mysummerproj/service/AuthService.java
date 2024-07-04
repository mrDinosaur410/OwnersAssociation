package by.bsu.mysummerproj.service;

import by.bsu.mysummerproj.dto.auth.LoginDTO;
import by.bsu.mysummerproj.dto.auth.UserCreateDTO;

public interface AuthService {
    void login(LoginDTO dto);
//    void register(UserCreateDTO dto);
}
