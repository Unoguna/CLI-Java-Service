package com.ll.noticeBoard.controller;

import com.ll.AppTestRunner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NoticeBoardControllerTest {

    @Test
    @DisplayName("등록")
    void t1() {
        String rs = AppTestRunner.run("""
                write
                자바 공부
                자바 텍스트 게시판 만들기
                """);

        assertThat(rs).contains("제목: ").contains("내용: ");
    }

    @Test
    @DisplayName("등록시 등록완료 출력")
    void t2(){
        String rs = AppTestRunner.run("""
                write
                자바 공부
                자바 텍스트 게시판 만들기
                """);

        assertThat(rs).contains("=> 게시글이 등록되었습니다.");
    }

    @Test
    @DisplayName("목록")
    void t3(){
        String rs = AppTestRunner.run("""
                write
                자바 공부1
                자바 텍스트 게시판 만들기1
                write
                자바 공부2
                자바텍스트 게시판 만들기2
                list
                """);

        assertThat(rs)
                .contains("번호 | 제목 | 등록일")
                .contains("-----------------------------")
                .contains("1 | 자바 공부1 | 2025-08-06")
                .contains("2 | 자바 공부2 | 2025-08-06");
    }

    @Test
    @DisplayName("게시글 세부정보")
    void t4(){
        String rs = AppTestRunner.run("""
                write
                자바 공부1
                자바 텍스트 게시판 만들기1
                write
                자바 공부2
                자바텍스트 게시판 만들기2
                detail 1
        """);

        assertThat(rs)
                .contains("번호: 1")
                .contains("제목: 자바 공부1")
                .contains("내용: 자바 텍스트 게시파 만들기")
                .contains("등록일: 2025-08-06");
    }
}
