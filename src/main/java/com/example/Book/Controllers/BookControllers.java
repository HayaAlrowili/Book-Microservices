package com.example.Book.Controllers;
import com.example.Book.Entities.Book;
import com.example.Book.Mappers.BookMapper;
import com.example.Book.Responses.DeleteBookResponse;
import com.example.Book.Responses.GetAuthorResponse;
import com.example.Book.Services.BookService;
import com.example.Book.TestFeign.Post;
import org.json.JSONObject;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.example.Book.Dto.BookDto ;

import java.util.List;
        import java.util.Optional;

@RestController
@RequestMapping(path = "api/Book")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookControllers {
    private BookService bookService;
   //private BookMapper mapper = Mappers.getMapper(BookMapper.class);
//   Logger logger = LoggerFactory.getLogger(BookControllers.class);

    @Autowired
    public BookControllers( BookService bookService) {
        this.bookService = bookService;


    }
    @GetMapping(path = "/posts")
    public List<Post> getPosts() {
        return bookService.getPostss() ;
    }
    @GetMapping
    public List<Book> getBooks() {


//        logger.trace("A TRACE Message");
//        logger.debug("A DEBUG Message");
//        logger.info("An INFO Message");
//        logger.warn("A WARN Message");
//        logger.error("An ERROR Message");
        return bookService.getBooks();
    }

    @GetMapping(path = "{bookId}")

    public Optional<Book> getBook(@PathVariable(name = "bookId") Integer bookId) {
        return bookService.getBook(bookId);
    }

    @PostMapping
    public void registerNewBook(@RequestBody Book book) {
        bookService.addBook(book);
    }


    
    @DeleteMapping(path = "{bookId}",produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDto> deleteBook(@PathVariable ("bookId") Integer bookId){
       return bookService.deleteBook(bookId) ;

    }

    @PutMapping
    public void updateBook( @RequestBody Book book){
        bookService.addBook(book);
    }


    @GetMapping(path= "author/{bookId}" ,produces= MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<BookDto>  getAuthor(@PathVariable(name = "bookId") Integer bookId){
        return bookService.getAuthorBook(bookId) ;
        }

        @GetMapping (path = "booksbyauthor/{authorName}")
    public List<Book> getBooksByAuthor(@PathVariable(name = "authorName") String author){

        return bookService.getBooksByAuthor(author) ;
    }

}





















