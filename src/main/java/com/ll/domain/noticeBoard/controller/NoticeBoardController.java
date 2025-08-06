package com.ll.domain.noticeBoard.controller;

import com.ll.AppContext;
import com.ll.domain.noticeBoard.entity.Article;
import com.ll.domain.noticeBoard.service.NoticeBoardService;

import java.util.Scanner;

public class NoticeBoardController {
    private final Scanner scanner;
    private final NoticeBoardService noticeBoardService;

    public NoticeBoardController() {
        this.scanner = AppContext.scanner;
        this.noticeBoardService = AppContext.noticeBoardService;
    }

    public void writeArticle(){
        System.out.print("제목: ");
        String title = scanner.nextLine();

        System.out.print("내용: ");
        String content = scanner.nextLine();

        Article article = noticeBoardService.write(title, content);

        System.out.println("=> 게시글이 등록되었습니다.");
    }
}
