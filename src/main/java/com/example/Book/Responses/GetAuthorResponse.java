package com.example.Book.Responses;

public class GetAuthorResponse {
    private String message ;
    private Integer status ;
    private String AuthorName ;

    public GetAuthorResponse(String message, Integer status, String authorName) {
        this.message = message;
        this.status = status;
        AuthorName = authorName;
    }

    public GetAuthorResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }
}
