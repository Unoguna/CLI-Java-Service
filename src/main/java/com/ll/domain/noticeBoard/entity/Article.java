package com.ll.domain.noticeBoard.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString //toString 오버라이드를 대신 해줌
public class Article {
    int id;
    String title;
    String content;
    String regDate;

    public Article (String title, String content, String regDate){
        this.title = title;
        this.content = content;
        this.regDate = regDate;
    }

    public boolean isNew(){
        return id == 0;
    }
}