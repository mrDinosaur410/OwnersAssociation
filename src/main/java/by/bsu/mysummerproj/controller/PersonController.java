package by.bsu.mysummerproj.controller;

import by.bsu.mysummerproj.dto.auth.UserCreateDTO;
import by.bsu.mysummerproj.entity.Person;
import by.bsu.mysummerproj.service.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class PersonController {
    private final PersonService personService;

    @GetMapping("/create-user")
    public String getCreateUserForm() {
        return "person/create";
    }

    @GetMapping("/users")
    public String getPersons(final Model model) {
        model.addAttribute("persons", personService.getAll());
        return "person/list";
    }

    @PostMapping("/create-user")
    public String createUser(
            @Valid final UserCreateDTO dto,
            BindingResult bindingResult,
            Model model
    ) throws Exception {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage).toList());
            model.addAttribute("payload", dto);
            return "person/create";
        }
        try {
            personService.create(dto);
        }
        catch (DataIntegrityViolationException e) {
            bindingResult.rejectValue(
                    "contact",
                    null,
                    "There is already an account registered with the same username or contact");
            model.addAttribute("errors", bindingResult.getAllErrors().stream()
                   .map(ObjectError::getDefaultMessage).toList());
            model.addAttribute("payload", dto);
            return "person/create";
        }
        return "redirect:/admin/users";
    }

}
