package com.example.Book.Services;

import com.example.Book.Controllers.BookControllers;
import com.example.Book.Dto.BookDto;
import com.example.Book.Entities.Book;
import com.example.Book.Exception.GetAuthorException;
import com.example.Book.Mappers.BookMapper;
import com.example.Book.TestFeign.JSONPlaceHolderClient;
import com.example.Book.TestFeign.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.Book.Repositories.BookRepository;

import java.util.List;
import java.util.Optional;
@Service

public class BookService {
    private BookRepository bookRepository;
    private JSONPlaceHolderClient jsonPlaceHolderClient ;
    Logger logger = LoggerFactory.getLogger(BookControllers.class);

    @Autowired
    public BookService(BookRepository bookRepository , JSONPlaceHolderClient jsonPlaceHolderClient) {
        this.bookRepository = bookRepository;
        this.jsonPlaceHolderClient = jsonPlaceHolderClient ;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
    public Optional<Book> getBook(Integer bookId) {
        return bookRepository.findById(bookId);
    }
    public void addBook(Book book) {bookRepository.save(book);}
    public List<Post> getPostss() {
        return jsonPlaceHolderClient.getPosts();
    }

    public ResponseEntity<BookDto> deleteBook(Integer bookId) {


        Optional<Book> book = bookRepository.findById(bookId) ;
        BookDto bookDto = new BookDto() ;
        if(book.isPresent()){
            bookDto = BookMapper.mapper.bookToBookDTO(book.get()) ;
            bookRepository.deleteById(bookId);
            return new ResponseEntity<>(
                    bookDto,
                    HttpStatus.OK);
        }else{
            logger.error("Book doesnot exsit");
            return new ResponseEntity<>(
                    bookDto,
                    HttpStatus.NOT_FOUND);

        }
    }
    public ResponseEntity<BookDto> getAuthorBook(Integer bookId){
        BookDto bookDto = new BookDto() ;
        Optional<Book> b = bookRepository.findById(bookId) ;
        if(b.isPresent()){
            if(b.get().getAuthor().isEmpty() ==false) {
                bookDto = BookMapper.mapper.bookToBookDTO(b.get()) ;

                return new ResponseEntity<>(
                        bookDto ,
                        HttpStatus.OK);
            }else{
                logger.error("Book Exists but author doesn't exist");

                throw new GetAuthorException("Book Exists but author doesn't exist") ;

            }
        }else{
            logger.error("Book doesnot exsit");
            throw new GetAuthorException("Book Doesn't Exist") ;
        }
    }
    public List<Book> getBooksByAuthor(String author){
        return bookRepository.findBooksByAuthor(author) ;
    }
}
