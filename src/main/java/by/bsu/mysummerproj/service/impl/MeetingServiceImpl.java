package by.bsu.mysummerproj.service.impl;

import by.bsu.mysummerproj.dto.meeting.MeetingDTO;
import by.bsu.mysummerproj.entity.Meeting;
import by.bsu.mysummerproj.entity.Person;
import by.bsu.mysummerproj.repository.MeetingRepository;
import by.bsu.mysummerproj.service.MeetingService;
import by.bsu.mysummerproj.service.PersonService;
import by.bsu.mysummerproj.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MeetingServiceImpl implements MeetingService {
    private final MeetingRepository meetingRepository;
    private final PersonService personService;
    @Override
    public List<Meeting> getAll() {
        return this.meetingRepository.findAll();
    }

    @Override
    public Meeting getById(Integer id) {
        return this.meetingRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Meeting create(MeetingDTO dto) throws ParseException {
        final Meeting meeting = Meeting
                .builder()
                .venue(dto.venue())
                .meetingdate(Utils.convertToValidDate(dto.meetingdate()))
                .protocol(dto.protocol())
                .build();

        return this.meetingRepository.save(meeting);
    }

    @Override
    public void addUsers(Integer id, String[] users) throws ParseException {
        Meeting meeting = this.getById(id);
        List<Person> persons = meeting.getPersons();
        for (String userId : users) {
            try {
                Person person = personService.getById(Integer.valueOf(userId));
                persons.add(person);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        meeting.setPersons(persons);
        meetingRepository.save(meeting);
    }

    @Override
    public void removeUsers(Integer id, String[] users) throws ParseException {
        Meeting meeting = this.getById(id);
        List<Person> persons = new ArrayList<>();
        for (String userId : users) {
            try {
                Person person = personService.getById(Integer.valueOf(userId));
                persons.add(person);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        List<Person> removedUsers = meeting.getPersons();
        removedUsers.removeAll(persons);
        meeting.setPersons(removedUsers);
        meetingRepository.save(meeting);
    }
}
