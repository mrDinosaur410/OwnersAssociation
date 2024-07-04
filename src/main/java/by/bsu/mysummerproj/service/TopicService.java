package by.bsu.mysummerproj.service;

import by.bsu.mysummerproj.entity.Topic;

import java.util.List;

public interface TopicService {
    List<Topic> getAll();
    Topic getById(Integer id);
}
