package com.example.cybsec.repository;

import com.example.cybsec.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long>{
}
