package by.bsu.mysummerproj.service;

import by.bsu.mysummerproj.dto.meeting.MeetingDTO;
import by.bsu.mysummerproj.entity.Meeting;

import java.text.ParseException;
import java.util.List;

public interface MeetingService {
    List<Meeting> getAll();

    Meeting getById(Integer id);

    Meeting create(MeetingDTO dto) throws ParseException;

    void addUsers(Integer id, String[] users) throws ParseException;
    void removeUsers(Integer id, String[] users) throws ParseException;
}
