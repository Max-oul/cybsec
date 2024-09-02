package com.example.cybsec.repository;

import com.example.cybsec.entity.Article;
import com.example.cybsec.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByArticle(Article article);
}
