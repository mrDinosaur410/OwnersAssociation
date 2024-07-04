package by.bsu.mysummerproj.dto.meeting;

import by.bsu.mysummerproj.entity.Person;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

public record MeetingDTO(
        @NotNull(message = "Date required")
        @Size(min = 10, max = 10, message = "Date format mismatch")
        String meetingdate,
        @NotNull(message = "Venue required")
        String venue,
        @NotNull(message = "Protocol required")
        String protocol
) {
}
