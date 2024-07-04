package by.bsu.mysummerproj.service.impl;

import by.bsu.mysummerproj.dto.auth.LoginDTO;
import by.bsu.mysummerproj.dto.auth.UserCreateDTO;
import by.bsu.mysummerproj.entity.Person;
import by.bsu.mysummerproj.repository.PersonRepository;
import by.bsu.mysummerproj.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final PersonRepository personRepository;
    @Override
    public void login(LoginDTO dto) {

    }

//    @Override
//    public void register(UserCreateDTO dto) {
//        final Person person = Person
//                .builder()
//                .name(dto.name())
//                .surname(dto.surname())
//                .patronymic(dto.patronymic())
//                .birthdate(dto.birthdate())
//                .contact(dto.contact())
//                .username(dto.username())
//                .password(dto.password())
//                .build();
//        this.personRepository
//                .save(person);
//    }
}
