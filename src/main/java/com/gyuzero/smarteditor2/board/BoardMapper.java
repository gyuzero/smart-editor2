package com.gyuzero.smarteditor2.board;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    void save(BoardForm boardForm);

    List<Board> findAll();

    Board findById(int boardId);

    void update(BoardUpdate boardUpdate);
}
