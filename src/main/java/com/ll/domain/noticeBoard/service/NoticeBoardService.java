package com.ll.domain.noticeBoard.service;

import com.ll.domain.noticeBoard.entity.Article;
import com.ll.domain.noticeBoard.repository.NoticeBoardRepository;

public class NoticeBoardService {
    private final NoticeBoardRepository noticeBoardRepository;

    public  NoticeBoardService() {
        noticeBoardRepository = new NoticeBoardRepository();
    }

    public Article write(String title, String  content){
        Article article = new Article(title, content);
        noticeBoardRepository.save(article);

        return article;
    }

}
