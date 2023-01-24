package com.example.noticeboard.controller;

import com.example.noticeboard.domain.Article;
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
