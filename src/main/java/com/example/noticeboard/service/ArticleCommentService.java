package com.example.noticeboard.service;

import com.example.noticeboard.domain.Article;
import com.example.noticeboard.domain.ArticleComment;
import com.example.noticeboard.repository.ArticleCommentRepository;
import com.example.noticeboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ArticleCommentService {

    private final ArticleCommentRepository articleCommentRepository;
    private final ArticleRepository articleRepository;

    @Transactional
    public Long saveArticleComment(Long articleId, String content) {
        Article article = articleRepository.findOne(articleId);
        ArticleComment articleComment = ArticleComment.of(article, content);
        return articleCommentRepository.save(articleComment);
    }

    public List<ArticleComment> findAll() {
        return articleCommentRepository.findAll();
    }

    @Transactional
    public void updateArticleComment(Long ArticleCommentId, UpdateArticleCommentDto updateArticleCommentDto) {
        ArticleComment savedArticleComment = articleCommentRepository.findOne(ArticleCommentId);
        savedArticleComment.updateContent(updateArticleCommentDto.getContent());
    }

}
