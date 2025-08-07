package com.ll.domain.noticeBoard.service;

import com.ll.AppContext;
import com.ll.domain.noticeBoard.entity.Article;
import com.ll.domain.noticeBoard.repository.NoticeBoardRepository;

import java.util.ArrayList;
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

    public void updateArticle(int id, String title, String content, String regDate){
        Article article = new Article(title, content, regDate);
        article.setId(id);
        noticeBoardRepository.updateArticle(id, article);
    }

    public void deleteArticle(int id){
        noticeBoardRepository.deleteArticle(id);
    }

    public List<Article> searchArticle(String param){
        ArrayList<Article> articles = noticeBoardRepository.getList();
        List<Article> result = new ArrayList<>();
        for (Article article : articles) {
            if ((article.getTitle() != null && article.getTitle().contains(param)) ||
                    (article.getContent() != null && article.getContent().contains(param))) {
                result.add(article);
            }
        }
        return result;
    }
}
