package by.bsu.mysummerproj.controller;

import by.bsu.mysummerproj.dto.auth.UserCreateDTO;
import by.bsu.mysummerproj.dto.meeting.MeetingDTO;
import by.bsu.mysummerproj.entity.Meeting;
import by.bsu.mysummerproj.entity.Person;
import by.bsu.mysummerproj.service.MeetingService;
import by.bsu.mysummerproj.service.PersonService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class MeetingController {
    private final MeetingService meetingService;
    private final PersonService personService;

    @GetMapping("/meetings")
    public String getMeetings(final Model model) {
        model.addAttribute("meetings", meetingService.getAll());
        return "meeting/list";
    }

    @GetMapping("/meetings/{id}")
    public String getMeetingById(final Model model, @PathVariable Integer id) {
        final Meeting meeting = meetingService.getById(id);
        model.addAttribute("meeting", meeting);
//        System.out.println(personService.getAll().removeAll(meeting.getPersons()));
        model.addAttribute("persons", personService.getAll().stream()
                .filter(item -> !meeting.getPersons().contains(item))
                .toList());
        model.addAttribute("attendees", meeting.getPersons());
        return "meeting/view";
    }

    @GetMapping("/create-meeting")
    public String createMeetingForm() {
        return "meeting/create";
    }

    @PostMapping("/create-meeting")
    public String createMeeting(
            @Valid final MeetingDTO dto,
            BindingResult bindingResult,
            Model model
    ) throws Exception {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage).toList());
            model.addAttribute("payload", dto);
            return "meeting/create";
        }
        Integer id = 0;
        try {
            Meeting meeting = meetingService.create(dto);
            id = meeting.getId();
        } catch (DataIntegrityViolationException e) {
            bindingResult.rejectValue(
                    "date",
                    null,
                    "There is already a meeting held on this date");
            model.addAttribute("errors", bindingResult.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage).toList());
            model.addAttribute("payload", dto);
            return "meeting/create";
        }
        return "redirect:/admin/meetings/" + id;
    }

    @PostMapping("/meetings/{id}/update")
    public String updateMeeting(
            @Valid final String[] idList1,
            Model model,
            @PathVariable Integer id
    ) throws ParseException {
        meetingService.addUsers(id, idList1);
//        System.out.println("person = ");
//        System.out.println(idList[0]);
        return "redirect:/admin/meetings/" + id;
    }

    @PostMapping("/meetings/{id}/remove-users")
    public String removeUsersMeeting(
            @Valid final String[] idList2,
            Model model,
            @PathVariable Integer id
    ) throws ParseException {
        meetingService.removeUsers(id, idList2);
        return "redirect:/admin/meetings/" + id;
    }

}
