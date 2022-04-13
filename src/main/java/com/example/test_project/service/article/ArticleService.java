package com.example.test_project.service.article;

import com.example.test_project.domain.posts.Article;
import com.example.test_project.domain.posts.ArticleRepository;
import com.example.test_project.web.dto.ArticleResponseDto;
import com.example.test_project.web.dto.ArticleSaveRequestDto;
import com.example.test_project.web.dto.ArticleUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional
    public Long save(ArticleSaveRequestDto requestDto) {
        return articleRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, ArticleUpdateRequestDto requestDto) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        article.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public ArticleResponseDto findById(Long id) {
        Article entity = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        return new ArticleResponseDto(entity);
    }
}
