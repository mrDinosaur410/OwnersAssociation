package by.bsu.mysummerproj.dto.flat;

import by.bsu.mysummerproj.entity.Person;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

public record FlatDTO(
        @NotNull(message = "Number required")
        Integer flatnumber,
        @NotNull(message = "Area required")
        Double area
) {
}

