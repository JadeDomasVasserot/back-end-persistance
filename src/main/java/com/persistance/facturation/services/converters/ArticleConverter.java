package com.persistance.facturation.services.converters;

import com.persistance.facturation.data.dto.ArticleDto;
import com.persistance.facturation.data.models.Article;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ArticleConverter {
    private final ModelMapper modelMapper = new ModelMapper();

    public ArticleDto convertArticleToArticleDto(Article article) {
        return modelMapper.map(article, ArticleDto.class);
    }
    public Article convertArticleDtoToArticle(ArticleDto articleDto) {
        return modelMapper.map(articleDto, Article.class);
    }
}
