package com.gyuzero.smarteditor2.board;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    private final ModelMapper modelMapper;

    @GetMapping("/boardForm")
    public String boardForm() {
        return "board/form";
    }

    @GetMapping("/boards/{boardId}")
    public String getBoard(@PathVariable("boardId") int boardId, Model model) {
        Board board = boardService.findById(boardId);
        model.addAttribute("board", board);
        return "board/detail";
    }

    @GetMapping("/boards/{boardId}/update")
    public String updateBoard(@PathVariable("boardId") int boardId, Model model) {
        Board board = boardService.findById(boardId);
        model.addAttribute("board", board);
        return "board/update";
    }

    @ResponseBody
    @PostMapping("/boards")
    public ResponseEntity<Board> boardSave(@RequestBody BoardForm boardForm) {
        log.info("{}", boardForm);
        boardService.save(boardForm);
        Board board = modelMapper.map(boardForm, Board.class);
        return ResponseEntity.ok().body(board);
    }

    @ResponseBody
    @PostMapping("/boards/{boardId}")
    public ResponseEntity<Board> updateBoard(@PathVariable("boardId") int boardId, @RequestBody BoardUpdate boardUpdate) {
        log.info("{}", boardUpdate);
        boardService.update(boardUpdate);
        Board board = modelMapper.map(boardUpdate, Board.class);
        return ResponseEntity.ok().body(board);
    }

}
