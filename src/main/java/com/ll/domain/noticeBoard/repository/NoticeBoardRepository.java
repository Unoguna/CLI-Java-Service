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
}
