package com.ll.domain.noticeBoard.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString //toString 오버라이드를 대신 해줌
public class Article {
    int id;
    String title;
    String content;
    String regDate;

    public Article (String title, String content){
        this.title = title;
        this.content = content;
        this.regDate = String.valueOf(new Date());
    }

    public boolean isNew(){
        return id == 0;
    }
}