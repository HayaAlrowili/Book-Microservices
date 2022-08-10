package com.example.Book.Responses;

public class DeleteBookResponse {
    private String message ;
    private Integer status ;

    public DeleteBookResponse() {
    }

    public DeleteBookResponse(String message, Integer status) {
        this.message = message;
        this.status = status;
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
}