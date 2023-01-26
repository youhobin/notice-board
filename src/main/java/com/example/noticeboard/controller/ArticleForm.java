package com.example.noticeboard.controller;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

//setter를 나중에 바꿀 수 있나?
@Getter @Setter
public class ArticleForm {

    private Long id;

    private String title;
    private String content;
    private String hashtag;

    private LocalDateTime createdDate;
}
