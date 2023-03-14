package com.persistance.facturation.data.repositories;

import com.persistance.facturation.data.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}