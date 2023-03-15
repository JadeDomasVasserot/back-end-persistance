package com.persistance.facturation.DATA.repositories;

import com.persistance.facturation.DATA.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}