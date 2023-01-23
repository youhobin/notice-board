package com.example.noticeboard.service;

import com.example.noticeboard.domain.ArticleComment;
import com.example.noticeboard.repository.ArticleCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ArticleCommentService {

    private final ArticleCommentRepository articleCommentRepository;

    @Transactional
    public Long saveArticleComment(ArticleComment articleComment) {
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
