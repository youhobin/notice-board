package com.example.noticeboard.controller;

import com.example.noticeboard.domain.Article;
import com.example.noticeboard.domain.ArticleComment;
import com.example.noticeboard.service.ArticleCommentService;
import com.example.noticeboard.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ArticleController {
    
    private final ArticleService articleService;

    @GetMapping("/articles")
    public String articleList(Model model) {
        List<Article> articles = articleService.findAll();

        model.addAttribute("articles", articles);

        return "articles/articleList";
    }

    //게시글에 글과 댓글 둘다 나와야하므로, 글의 id로 댓글을 찾는 로직 구현해야할듯.
    @GetMapping("/articles/{articleId}")
    public String article(@PathVariable("articleId") Long articleId, Model model) {
        Article article = articleService.findOne(articleId);
        model.addAttribute("title", article.getTitle());
        model.addAttribute("content", article.getContent());

        return "articles/article";
    }

    @GetMapping("/articles/new")
    public String createArticleForm(Model model) {
        model.addAttribute("form", new ArticleForm());
        return "articles/createArticleForm";
    }

}
