package com.gyuzero.smarteditor2.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardUpdate {

    private int boardId;

    private String title;

    private String content;
}
