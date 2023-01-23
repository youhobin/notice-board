package com.example.noticeboard.service;

import lombok.Getter;

@Getter

public class UpdateArticleCommentDto {

    private String content;

    public UpdateArticleCommentDto(String content) {
        this.content = content;
    }
}
