package by.bsu.mysummerproj.controller;

import by.bsu.mysummerproj.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public String getFlats(final Model model) {
        model.addAttribute("comments", commentService.getAll());
        return "comment/comment";
    }
}
