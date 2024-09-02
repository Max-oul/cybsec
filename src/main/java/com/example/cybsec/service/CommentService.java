package com.example.cybsec.service;

import com.example.cybsec.entity.Article;
import com.example.cybsec.entity.Comment;
import com.example.cybsec.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> findByArticle(Article article){
        return commentRepository.findByArticle(article);
    }
    public Comment save(Comment comment){
        return commentRepository.save(comment);
    }


}
