package by.bsu.mysummerproj.service;

import by.bsu.mysummerproj.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAll();
    Comment getById(Integer id);
}
