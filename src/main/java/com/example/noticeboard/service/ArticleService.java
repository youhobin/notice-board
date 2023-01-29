package com.example.noticeboard.service;

import com.example.noticeboard.domain.Article;
import com.example.noticeboard.repository.ArticleRepository;
import com.example.noticeboard.service.dto.article.UpdateArticleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional
    public Long saveArticle(Article article) {
        return articleRepository.save(article);
    }

    public Article findOne(Long articleId) {
        return articleRepository.findOne(articleId);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Transactional
    public void update(Long articleId, UpdateArticleDto updateArticleDto) {
        Article findArticle = articleRepository.findOne(articleId);
        String updateTitle = updateArticleDto.getTitle();
        String updateContent = updateArticleDto.getContent();
        findArticle.updateArticle(updateTitle, updateContent);
    }

}
