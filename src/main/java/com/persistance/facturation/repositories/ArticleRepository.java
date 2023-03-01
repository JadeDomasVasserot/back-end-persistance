package com.persistance.facturation.repositories;

import com.persistance.facturation.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}