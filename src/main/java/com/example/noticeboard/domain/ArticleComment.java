package com.example.noticeboard.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
public class ArticleComment extends BaseTimeEntity{

    @Id @GeneratedValue
    @Column(name = "article_comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    private String title;
    private String content;
    private String hashtag;

}
