package com.example.Book.Services;

import com.example.Book.Entites.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Book.Repositories.BookRepository;
import java.util.List;
import java.util.Optional;
@Service

public class BookService {
    private BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
    public Optional<Book> getBook(Integer bookId) {
        return bookRepository.findById(bookId);
    }
    public void addBook(Book book) {bookRepository.save(book);}
    public void deleteBook(Integer bookId) {bookRepository.deleteById(bookId);}
    public String getAuthorBook(Integer bookId){
        Optional<Book>  b = bookRepository.findById(bookId) ;
        if(b.isPresent()){
            return b.get().getAuthor() ;
        }else{
            return "Author book doesn't exist" ;
        }
    }
}
