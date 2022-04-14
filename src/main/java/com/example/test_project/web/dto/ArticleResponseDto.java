package com.example.test_project.web.dto;

import com.example.test_project.domain.article.Article;
import lombok.Getter;

@Getter
public class ArticleResponseDto {
    private Long id;
    private String title;
    private String content;
    private String writer;

    public ArticleResponseDto(Article entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.writer = entity.getWriter();
    }
}
