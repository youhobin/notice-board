package com.example.noticeboard.controller;

import com.example.noticeboard.controller.dto.ArticleForm;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleService articleService;
    private final ArticleCommentService articleCommentService;

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
        model.addAttribute("article", article);

        return "articles/article";
    }

    @GetMapping("/articles/new")
    public String createArticleForm(Model model) {
        model.addAttribute("form", new ArticleForm());
        return "articles/createArticleForm";
    }

    @PostMapping("/articles/new")
    public String createArticle(@ModelAttribute ArticleForm form) {

        Article article = Article.of(form.getTitle(), form.getContent(), form.getHashtag());
        articleService.saveArticle(article);

        return "redirect:/";
    }

    @PostMapping("/articles/{articleId}/articleComment/new")
    public String createArticleComment(
        @PathVariable("articleId") Long articleId,
        @ModelAttribute ArticleCommentForm articleCommentForm,
        Model model,
        RedirectAttributes redirectAttributes
    ) {
        Article article = articleService.findOne(articleId);
        model.addAttribute("article", article);

        ArticleComment articleComment = ArticleComment.of(article, articleCommentForm.getContent());
        articleCommentService.saveArticleComment(articleComment);
        redirectAttributes.addAttribute("articleId", articleId);

        return "redirect:/articles/{articleId}";
    }
}
