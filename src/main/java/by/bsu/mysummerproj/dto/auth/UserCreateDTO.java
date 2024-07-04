package by.bsu.mysummerproj.dto.auth;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record UserCreateDTO(
        String surname,
        @NotNull (message = "Name required")
        String name,
        String patronymic,
        @NotNull (message = "Birthdate required")
        @Size (min = 10, max = 10, message = "Date format mismatch")
//        @JsonFormat(pattern = "dd/MM/yyyy")
        String birthdate,
        @NotNull (message = "Contact required")
        String contact,
        @NotNull (message = "Username required")
        String username,
        @NotNull (message = "Password required")
        @Size (min = 8, max = 20, message = "Password length mismatch")
        String password
) {
}

