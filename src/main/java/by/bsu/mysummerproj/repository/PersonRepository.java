package by.bsu.mysummerproj.repository;

import by.bsu.mysummerproj.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByUsername(String username);
    Optional<Person> findByContact(String contact);
}
