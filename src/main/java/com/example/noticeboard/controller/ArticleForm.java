package com.example.noticeboard.controller;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticleForm {

    private Long id;

    private String title;
    private String content;
    private String hashtag;

    private LocalDateTime createdDate;
}
