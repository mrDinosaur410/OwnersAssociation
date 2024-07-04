package by.bsu.mysummerproj.service.impl;

import by.bsu.mysummerproj.dto.auth.UserCreateDTO;
import by.bsu.mysummerproj.entity.Person;
import by.bsu.mysummerproj.entity.Role;
import by.bsu.mysummerproj.repository.PersonRepository;
import by.bsu.mysummerproj.service.PersonService;
import by.bsu.mysummerproj.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public List<Person> getAll() {
        return this.personRepository.findAll();
    }

    @Override
    public Person getById(Integer id) {
        return this.personRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Person create(UserCreateDTO dto) throws ParseException {
        final Person person = Person
                .builder()
                .name(dto.name())
                .surname(dto.surname())
                .patronymic(dto.patronymic())
                .birthdate(Utils.convertToValidDate(dto.birthdate()))
//                .birthdate(new SimpleDateFormat("yyyy/MM/dd")
//                        .parse(dto.birthdate().replaceAll("-","/")))
                .contact(dto.contact())
                .role(Role.ROLE_USER)
                .username(dto.username())
                .password(passwordEncoder.encode(dto.password()))
                .build();
        return personRepository.save(person);
    }

    @Override
    public Person findByUsername(String username) {
        return this.personRepository.findByUsername(username).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Person findByContact(String contact) {
        return this.personRepository.findByContact(contact).orElseThrow(NoSuchElementException::new);
    }
}
