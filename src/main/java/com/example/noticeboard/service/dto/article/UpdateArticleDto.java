package com.example.noticeboard.service.dto.article;

import lombok.Getter;

@Getter
public class UpdateArticleDto {

    private String title;
    private String content;

    public UpdateArticleDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
