package by.bsu.mysummerproj.service.impl;

import by.bsu.mysummerproj.entity.Comment;
import by.bsu.mysummerproj.repository.CommentRepository;
import by.bsu.mysummerproj.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    @Override
    public List<Comment> getAll() {
        return this.commentRepository.findAll();
    }

    @Override
    public Comment getById(Integer id) {
        return this.commentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}

