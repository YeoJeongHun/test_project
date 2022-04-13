package com.example.test_project.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
//    void save(String title, String content, String author);
}
