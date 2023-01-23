package com.example.noticeboard.repository;

import com.example.noticeboard.domain.Article;
import com.example.noticeboard.domain.ArticleComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class ArticleCommentRepository {

    private final EntityManager em;

    public Long save(ArticleComment articleComment) {
        em.persist(articleComment);
        return articleComment.getId();
    }

    public List<ArticleComment> findAll() {
        return em.createQuery("select ac from ArticleComment ac", ArticleComment.class)
            .getResultList();
    }

    public ArticleComment findOne(Long id) {
        return em.find(ArticleComment.class, id);
    }
}
