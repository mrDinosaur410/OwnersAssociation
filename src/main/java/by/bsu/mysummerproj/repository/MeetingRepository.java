package by.bsu.mysummerproj.repository;

import by.bsu.mysummerproj.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Integer> {
}
