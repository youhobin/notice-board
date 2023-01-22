package com.example.noticeboard.repository;

import com.example.noticeboard.domain.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ArticleRepository {

    private final EntityManager em;

    public Long save(Article article) {
        em.persist(article);
        return article.getId();
    }

    public Article findOne(Long id) {
        return em.find(Article.class, id);
    }

    public List<Article> findAll() {
        return em.createQuery("select a from Article a", Article.class)
            .getResultList();
    }
}
