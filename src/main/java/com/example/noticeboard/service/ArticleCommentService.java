package com.example.noticeboard.service;

import com.example.noticeboard.domain.ArticleComment;
import com.example.noticeboard.repository.ArticleCommentRepository;
import com.example.noticeboard.repository.ArticleRepository;
import com.example.noticeboard.service.dto.articlecomment.UpdateArticleCommentDto;
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
    public Long saveArticleComment(ArticleComment articleComment) {
        return articleCommentRepository.save(articleComment);
    }

    public List<ArticleComment> findAll() {
        return articleCommentRepository.findAll();
    }

    public List<ArticleComment> findAllWithArticle() {
        return articleCommentRepository.findAllWithArticle();
    }

    @Transactional
    public void updateArticleComment(Long ArticleCommentId, UpdateArticleCommentDto updateArticleCommentDto) {
        ArticleComment savedArticleComment = articleCommentRepository.findOne(ArticleCommentId);
        savedArticleComment.updateContent(updateArticleCommentDto.getContent());
    }

}
