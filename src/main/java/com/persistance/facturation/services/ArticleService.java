package com.persistance.facturation.services;

import com.persistance.facturation.data.models.Article;
import com.persistance.facturation.data.repositories.ArticleRepository;
import com.persistance.facturation.services.converters.ArticleConverter;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArticleService {
    private final ArticleRepository articleRepository;

    private final ArticleConverter articleConverter;

    public ArticleService(ArticleRepository articleRepository, ArticleConverter articleConverter){
        this.articleRepository = articleRepository;
        this.articleConverter = articleConverter;
    }

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
