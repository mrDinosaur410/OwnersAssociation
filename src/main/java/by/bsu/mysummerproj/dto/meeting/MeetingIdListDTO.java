package by.bsu.mysummerproj.dto.meeting;

import jakarta.validation.constraints.NotNull;

public record MeetingIdListDTO(@NotNull(message = "List of users can't be empty") String[] idList) {}
