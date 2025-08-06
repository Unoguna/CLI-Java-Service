package com.ll.domain.noticeBoard.repository;

import com.ll.domain.noticeBoard.entity.Article;

import java.util.ArrayList;
import java.util.List;

public class NoticeBoardRepository {

    private final List<Article> articleList = new ArrayList<>();
    private int lastId = 0;

    public Article save (Article article){
        if(article.isNew()){
            article.setId(++lastId);
            articleList.add(article);
        }

        return article;
    }

    public List<Article> getList (){
        return articleList;
    }

    public Article getArticle(int id){
        return articleList
                .stream()
                .filter(article -> article.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void updateArticle(int id, Article article){
        articleList
                .stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .ifPresent(a -> {
                    a.setTitle(article.getTitle());
                    a.setContent(article.getContent());
                });
    }

    public void deleteArticle(int id){
        articleList.remove(id - 1);
    }
}
