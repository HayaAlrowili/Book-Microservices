package com.example.Book.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GetAuthorException extends RuntimeException {

    public GetAuthorException (){
        super() ;
    }
    public GetAuthorException (String message , Throwable cause){
        super(message, cause) ;
    }
    public GetAuthorException (String message){
        super(message) ;
    }
    public GetAuthorException (Throwable cause){
        super(cause) ;
    }
}
