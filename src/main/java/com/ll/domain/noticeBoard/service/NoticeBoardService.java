package com.ll.domain.noticeBoard.service;

import com.ll.AppContext;
import com.ll.domain.noticeBoard.entity.Article;
import com.ll.domain.noticeBoard.repository.NoticeBoardRepository;

import java.util.List;

public class NoticeBoardService {
    private final NoticeBoardRepository noticeBoardRepository;

    public  NoticeBoardService() {
        noticeBoardRepository = AppContext.noticeBoardRepository;
    }

    public Article write(String title, String  content, String regDate){
        Article article = new Article(title, content, regDate);
        noticeBoardRepository.save(article);

        return article;
    }

    public List<Article> getList(){
        return noticeBoardRepository.getList();
    }

    public Article getArticle(int id){
        return noticeBoardRepository.getArticle(id);
    }

}
