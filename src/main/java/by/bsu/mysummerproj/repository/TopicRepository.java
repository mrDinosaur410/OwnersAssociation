package by.bsu.mysummerproj.repository;

import by.bsu.mysummerproj.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
}
