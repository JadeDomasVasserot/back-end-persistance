package com.persistance.facturation.services;

import com.persistance.facturation.models.Article;
import com.persistance.facturation.models.Role;
import com.persistance.facturation.repositories.ArticleRepository;
import org.springframework.stereotype.Service;

import java.awt.geom.Arc2D;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private ArticleRepository articleRepository;

    public List<Article> findAll(){
        return this.articleRepository.findAll();
    }

    public Optional<Article> findById(Integer id){
        return this.articleRepository.findById(id);
    }

    public Article addArticle (Article article){
        return this.articleRepository.save(article);
    }

    public Article updateArticle (Article article){
        return this.articleRepository.save(article);
    }

    public void deleteArticle (int id){
        this.articleRepository.deleteById(id);
    }

    public void deleteAllArticle (){
        this.articleRepository.deleteAll();
    }

}
