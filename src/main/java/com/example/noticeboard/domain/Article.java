package com.example.noticeboard.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
public class Article extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "article_id")
    private Long id;

    private String title;
    private String content;
    private String hashtag;

}
