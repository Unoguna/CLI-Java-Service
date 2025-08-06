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
}
