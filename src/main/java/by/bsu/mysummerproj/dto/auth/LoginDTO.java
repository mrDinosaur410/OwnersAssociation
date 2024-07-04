package by.bsu.mysummerproj.dto.auth;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LoginDTO(
        @NotNull (message = "Required")
        String username,
        @NotNull (message = "Required")
        @Size (min = 8, max = 20, message = "Length mismatch")
        String password
) {
}
