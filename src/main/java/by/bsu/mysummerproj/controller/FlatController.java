package by.bsu.mysummerproj.controller;

import by.bsu.mysummerproj.service.FlatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/flat")
public class FlatController {
    private final FlatService flatService;

    @GetMapping
    public String getFlats(final Model model) {
        model.addAttribute("flats", flatService.getAll());
        return "flat/flat";
    }
}
