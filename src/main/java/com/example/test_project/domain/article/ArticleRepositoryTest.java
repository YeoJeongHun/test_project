package com.example.test_project.domain.article;

import com.example.test_project.domain.posts.Posts;
import com.example.test_project.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleRepositoryTest {

    @Autowired
    ArticleRepository articleRepository;

    @After
    public void cleanup() {
        articleRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        String title = "테스트 게시글";
        String content = "테스트 본문";

        articleRepository.save(Article.builder()
                .title(title)
                .content(content)
                .writer("여정훈")
                .build());

        List<Article> postsList = articleRepository.findAll();

        Article article = postsList.get(0);
        assertThat(article.getTitle()).isEqualTo(title);
        assertThat(article.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록() {
        LocalDateTime now = LocalDateTime.of(2022,4,14,23,23,0);
        articleRepository.save(Article.builder()
                .title("title")
                .content("content")
                .writer("writer")
                .build());

        List<Article> articleList = articleRepository.findAll();

        Article article = articleList.get(0);

        System.out.println(">>>>>createDate=" + article.getCreatedDate()+", modifiedDate= " + article.getModifiedDate());
        assertThat(article.getCreatedDate()).isAfter(now);
        assertThat(article.getModifiedDate()).isAfter(now);
    }
}
