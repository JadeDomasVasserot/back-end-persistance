package com.persistance.facturation.controllers;

import com.persistance.facturation.data.models.Article;
import com.persistance.facturation.services.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/article")
@RestController
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @GetMapping("/all")
    //@Operation(summary = "récupère tous les articles")
    public ResponseEntity<List<Article>> getAllArticle() {
        try {
            List<Article> articles = articleService.findAll();
            if (articles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(articles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/id/{idArticle}")
    //@Operation(summary = "récupère un article")
    public ResponseEntity<Optional<Article>> getArticleById(@PathVariable("idArticle") int idArticle) {
        try {
            Optional<Article> article = articleService.findById(idArticle);
            if (article.isPresent()) {
                return new ResponseEntity<>(article, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    //@Operation(summary = "ajoute un article")
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        try {
            return new ResponseEntity<>(articleService.addArticle(article), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    //@Operation(summary = "modifie un article")
    public ResponseEntity<Article> updateArticle(@RequestBody Article newArticle, @PathVariable("id") int id) {
        Article updatedArticle = articleService.findById(id).map(article -> {
            article.setNom(newArticle.getNom());
            article.setPrix(newArticle.getPrix());
            article.setDescription(newArticle.getDescription());
            return articleService.updateArticle(article);

        }).orElseGet(() -> {
            newArticle.setId(id);
            return articleService.addArticle(newArticle);
        });

        if (updatedArticle != null) {
            return new ResponseEntity<>(updatedArticle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    //@Operation(summary = "supprime un article")
    public ResponseEntity<HttpStatus> deletePersonne(@PathVariable("id") int id) {
        try {
            articleService.deleteArticle(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/all")
    //@Operation(summary = "supprimer tous les articles")
    public ResponseEntity<HttpStatus> deleteAllPersonnes() {
        try {
            articleService.deleteAllArticle();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}