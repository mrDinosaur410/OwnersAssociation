package by.bsu.mysummerproj.service;

import by.bsu.mysummerproj.dto.auth.UserCreateDTO;
import by.bsu.mysummerproj.entity.Person;

import java.text.ParseException;
import java.util.List;

public interface PersonService {
    List<Person> getAll();
    Person getById(Integer id);
    Person create(UserCreateDTO userCreateDTO) throws ParseException;
    Person findByUsername(String username);
    Person findByContact(String contact);
}
