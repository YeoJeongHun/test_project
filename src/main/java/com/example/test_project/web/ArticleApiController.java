package com.example.test_project.web;

import com.example.test_project.service.article.ArticleService;
import com.example.test_project.web.dto.ArticleResponseDto;
import com.example.test_project.web.dto.ArticleSaveRequestDto;
import com.example.test_project.web.dto.ArticleUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ArticleApiController {

    private final ArticleService articleService;

    @PostMapping("/api/v1/article")
    public Long save(@RequestBody ArticleSaveRequestDto requestDto) {
        return articleService.save(requestDto);
    }

    @PutMapping("/api/v1/article/{id}")
    public Long update(@PathVariable Long id, @RequestBody ArticleUpdateRequestDto requestDto) {
        return articleService.update(id, requestDto);
    }

    @GetMapping("/api/v1/article/{id}")
    public ArticleResponseDto findById(@PathVariable Long id) {
        return articleService.findById(id);
    }
}
