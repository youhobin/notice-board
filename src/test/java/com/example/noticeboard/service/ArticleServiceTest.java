package com.example.noticeboard.service;

import com.example.noticeboard.domain.Article;
import com.example.noticeboard.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class ArticleServiceTest {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ArticleService articleService;

    @Test
    public void saveArticle() throws Exception {
        //given
        Article article = Article.of("title", "content", "hashtag");

        //when
        Long savedId = articleService.saveArticle(article);

        //then
        assertThat(article).isEqualTo(articleRepository.findOne(savedId));
    }

    @Test
    public void findAll() throws Exception {
        //given
        Article article1 = Article.of("title1", "content1", "hashtag1");
        Article article2 = Article.of("title2", "content2", "hashtag2");

        articleService.saveArticle(article1);
        articleService.saveArticle(article2);

        //when
        List<Article> articles = articleService.findAll();

        //then
        assertThat(articles.size()).isEqualTo(2);
    }

    @Test
    public void updateArticle() throws Exception {
        //given
        Article article = Article.of("title", "content", "hashtag");
        Long savedId = articleService.saveArticle(article);

        //when
        UpdateArticleDto updateArticleDto = new UpdateArticleDto("updateTitle", "updateContent");
        articleService.update(savedId, updateArticleDto);

        Article findArticle = articleService.findOne(savedId);

        //then
        assertThat(findArticle.getTitle()).isEqualTo(updateArticleDto.getTitle());
        assertThat(findArticle.getContent()).isEqualTo(updateArticleDto.getContent());
    }

}