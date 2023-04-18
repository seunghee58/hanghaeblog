package com.sparta.hanghaeblog.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String title;
    private String username;
    private String contents;
    private String password;

    public PostRequestDto(String title, String username, String contents, String password) {
        this.title = title;
        this.username = username;
        this.contents = contents;
        this.password = password;
    }
}
