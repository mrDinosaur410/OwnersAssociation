package by.bsu.mysummerproj.controller;

import by.bsu.mysummerproj.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/topic")
public class TopicController {
    private final TopicService topicService;

    @GetMapping
    public String topicMeetings(final Model model) {
        model.addAttribute("topics", topicService.getAll());
        return "topic/topic";
    }
}
