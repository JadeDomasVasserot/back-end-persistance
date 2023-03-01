package com.persistance.facturation.controllers;

import com.persistance.facturation.models.Article;
import com.persistance.facturation.services.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = {"http://127.0.0.1:8081", "http://127.0.0.1:3000"})
@RequestMapping("/article")
@RestController
//@Tag(name = "Personne ")
public class ArticleController {

    private ArticleService articleService;

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
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/id/{idArticlee}")
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
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    //@Operation(summary = "ajoute un article")
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        try {
            return new ResponseEntity<>(articleService.addArticle(article), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    //@Operation(summary = "modifie un article")
    public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
        if (article != null) {
            return new ResponseEntity<>(articleService.updateArticle(article), HttpStatus.OK);
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