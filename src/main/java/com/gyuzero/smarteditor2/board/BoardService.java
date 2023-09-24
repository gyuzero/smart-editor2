package com.gyuzero.smarteditor2.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardMapper boardMapper;

    public void save(BoardForm boardForm) {
        boardMapper.save(boardForm);
    }

    public List<Board> findAll() {
        return boardMapper.findAll();
    }

    public Board findById(int boardId) {
        return boardMapper.findById(boardId);
    }

    public void update(BoardUpdate boardUpdate) {
        boardMapper.update(boardUpdate);
    }
}
