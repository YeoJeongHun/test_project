package com.example.test_project.web.dto;

import com.example.test_project.domain.article.Article;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ArticleSaveRequestDto {
    private String title;
    private String content;
    private String writer;

    @Builder
    public ArticleSaveRequestDto(String title, String content, String writer){
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public Article toEntity() {
        return Article.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }
}
