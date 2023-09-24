package com.gyuzero.smarteditor2.home;

import com.gyuzero.smarteditor2.board.Board;
import com.gyuzero.smarteditor2.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final BoardService boardService;

    @GetMapping("/")
    public String home(Model model) {
        List<Board> boards = boardService.findAll();
        model.addAttribute("boards", boards);
        return "index";
    }
}
