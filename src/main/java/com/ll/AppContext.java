package com.ll;

import com.ll.domain.noticeBoard.controller.NoticeBoardController;
import com.ll.domain.noticeBoard.repository.NoticeBoardRepository;
import com.ll.domain.noticeBoard.service.NoticeBoardService;
import com.ll.domain.system.controller.SystemController;

import java.util.Scanner;

public class AppContext {
    public static Scanner scanner;
    public static SystemController systemController;
    public static NoticeBoardController noticeBoardController;
    public static NoticeBoardService noticeBoardService;
    public static NoticeBoardRepository noticeBoardRepository;

    public static void renew (Scanner _scanner) {
        scanner = _scanner;
        systemController = new SystemController();
        noticeBoardRepository = new NoticeBoardRepository();
        noticeBoardService = new NoticeBoardService();
        noticeBoardController = new NoticeBoardController();
    }

    public static void renew () {
        renew(new Scanner(System.in));
    }

}
