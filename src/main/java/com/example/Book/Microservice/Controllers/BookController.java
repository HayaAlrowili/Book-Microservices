package com.example.Book.Microservice.Controllers;
import com.example.Book.Microservice.Entites.Book;
import com.example.Book.Microservice.Services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(path = "api/book")
public class BookController {
    private BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    @Operation(summary = "Get All books")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }@GetMapping(path = "{bookId}")
    @Operation(summary = "Get a book by its id")
    public Optional<Book> getBook(@PathVariable(name = "bookId") Integer employeeId) {
        Optional<Book> book = bookService.getBook(employeeId);
        if(book.isPresent()){
            return book ;
        }else{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND , "the book is not found"
            );
        }
      //  return bookService.getBook(employeeId);
    }
    @PostMapping
    @Operation(summary = "Save a book")
    ResponseEntity<String> registerNewEmployee(@RequestBody Book book){

        Optional <Book> b =  bookService.getBook(book.getId()) ;
        if(b.isPresent()) {
            return new ResponseEntity<>("Book already exists!! " , HttpStatus.BAD_REQUEST) ;
        }else{
            bookService.addBook(book);
            return new ResponseEntity<>("Book Saved " , HttpStatus.OK) ;
        }
    }
    @DeleteMapping(path = "{bookId}")
    @Operation(summary = "Delete a book by its id")
    public void deleteBook(@PathVariable ("bookId") Integer bookId){
        bookService.deleteBook(bookId);
    }
    @GetMapping(path ="author/{bookId}")
    @Operation(summary = "Get an author by book id")
    public String getAuthor(@PathVariable ("bookId") Integer bookId) {
        return bookService.getAuthor(bookId) ;
    }
    @PutMapping
    public  ResponseEntity<String> updateBook(@RequestBody Book book) {
        Optional <Book> b =  bookService.getBook(book.getId()) ;
        if(b.isPresent()) {
            bookService.updateBook(book);
            return new ResponseEntity<>("Book updated " , HttpStatus.OK) ;
        }else{
            return new ResponseEntity<>("Book Doesn't exist " , HttpStatus.BAD_REQUEST) ;
        }

    }
}