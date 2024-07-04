package by.bsu.mysummerproj.service.impl;

import by.bsu.mysummerproj.entity.Topic;
import by.bsu.mysummerproj.repository.TopicRepository;
import by.bsu.mysummerproj.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class TopicServiceImpl implements TopicService {
    private final TopicRepository topicRepository;
    @Override
    public List<Topic> getAll() {
        return this.topicRepository.findAll();
    }

    @Override
    public Topic getById(Integer id) {
        return this.topicRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
