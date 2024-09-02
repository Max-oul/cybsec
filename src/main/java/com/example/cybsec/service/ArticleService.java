package com.example.cybsec.service;

import com.example.cybsec.entity.Article;
import com.example.cybsec.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Article findById(Long id){
        return articleRepository.findById(id).orElse(null);
    }
}
