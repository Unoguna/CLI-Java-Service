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
                .contains("내용: 자바 텍스트 게시판 만들기1")
                .contains("등록일: 2025-08-06");
    }

    @Test
    @DisplayName("게시글 수정 처리")
    void t5(){
        String rs = AppTestRunner.run("""
                write
                자바 공부
                자바 텍스트 게시판 만들기
                update 1
                Java 게시판
                콘솔 기반으로 구현
                detail 1
                """);

        assertThat(rs)
                .contains("제목 (현재: 자바 공부): ")
                .contains("내용 (현재: 자바 텍스트 게시판 만들기): ")
                .contains("=> 게시글이 수정되었습니다.")
                .contains("번호: 1")
                .contains("제목: Java 게시판")
                .contains("내용: 콘솔 기반으로 구현")
                .contains("등록일: 2025-08-06");
    }

    @Test
    @DisplayName("게시글 삭제")
    void t6(){
        String rs = AppTestRunner.run("""
                write
                자바 공부1
                자바 텍스트 게시판 만들기1
                write
                자바 공부2
                자바텍스트 게시판 만들기2
                delete 1
                list
                """);

        assertThat(rs)
                .contains("=> 게시글이 삭제되었습니다.")
                .contains("자바 공부2")
                .doesNotContain("자바 공부1");
    }

    @Test
    @DisplayName("게시글 조회수 기능")
    void t7(){
        String rs = AppTestRunner.run("""
                write
                자바 공부
                자바 텍스트 게시판 만들기
                detail 1
                update 1
                Java 게시판
                콘솔 기반으로 구현
                detail 1
                """);

        assertThat(rs)
                .contains("조회수: 2");
    }

    @Test
    @DisplayName("게시글 검색 기능")
    void t8(){
        String rs = AppTestRunner.run("""
                write
                자바 공부
                자바 텍스트 게시판 만들기
                write
                C언어 공부
                C언어 텍스트 게시판 만들기
                write
                파이썬 공부
                파이썬 텍스트 게시판 만들기
                write
                자바 프로젝트
                자바 프로젝트 팀원 구해요.
                write
                테스트
                자바 테스트
                search 자바
                """);
        assertThat(rs)
                .contains("1 | 자바 공부 | 2025-08-06")
                .contains("4 | 자바 프로젝트 | 2025-08-06")
                .contains("5 | 테스트 | 2025-08-06");
    }
}
