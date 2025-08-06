package com.ll.domain.noticeBoard.controller;

import com.ll.AppContext;
import com.ll.domain.noticeBoard.entity.Article;
import com.ll.domain.noticeBoard.service.NoticeBoardService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class NoticeBoardController {
    private final Scanner scanner;
    private final NoticeBoardService noticeBoardService;

    public NoticeBoardController() {
        this.scanner = AppContext.scanner;
        this.noticeBoardService = AppContext.noticeBoardService;
    }

    public String getCurrentDate() {
        LocalDate today = LocalDate.now();  // 현재 날짜
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return today.format(formatter);
    }

    public void writeArticle(){
        System.out.print("제목: ");
        String title = scanner.nextLine();

        System.out.print("내용: ");
        String content = scanner.nextLine();

        Article article = noticeBoardService.write(title, content, getCurrentDate());

        System.out.println("=> 게시글이 등록되었습니다.");
        System.out.println();
    }

    public void listArticles(){
        System.out.println("번호 | 제목 | 등록일");
        System.out.println("-----------------------------");

        for(Article article : noticeBoardService.getList()){
            System.out.println(article.getId() + " | " + article.getTitle() + " | " + article.getRegDate());
        }
        System.out.println();

    }

    public void showDetail(int id){
        Article article = noticeBoardService.getArticle(id);
        article.setCount(article.getCount() + 1);

        System.out.println("번호: " +  article.getId());
        System.out.println("제목: " +  article.getTitle());
        System.out.println("내용: " +   article.getContent());
        System.out.println("조회수: " + article.getCount());
        System.out.println("등록일: " + article.getRegDate());
        System.out.println();
    }

    public void updateArticle(int id){
        Article article = noticeBoardService.getArticle(id);

        System.out.print("제목 (현재: " + article.getTitle() + "): ");
        String title = scanner.nextLine();

        System.out.print("내용 (현재: " +  article.getContent() + "): ");
        String content = scanner.nextLine();

        noticeBoardService.updateArticle(id, title, content, getCurrentDate());

        System.out.println("=> 게시글이 수정되었습니다.");
        System.out.println();
    }

    public void deleteArticle(int id){
        noticeBoardService.deleteArticle(id);
        System.out.println("=> 게시글이 삭제되었습니다.");
        System.out.println();
    }
}
