package com.example.Book.Controllers;
import com.example.Book.Entites.Book;
        import com.example.Book.Services.BookService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;
        import java.util.Optional;

@RestController
@RequestMapping(path = "api/Book")
public class BookControllers {
    private BookService bookService;
    @Autowired
    public BookControllers( BookService bookService) {
        this.bookService = bookService;


    }


    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }
    @GetMapping(path = "{bookId}")
    public Optional<Book> getEmployee(@PathVariable(name = "bookId") Integer bookId) {
        return bookService.getBook(bookId);
    }
    @PostMapping(path= "add")
    public void registerNewBook(@RequestBody Book book){
        bookService.addBook(book);
    }
    @DeleteMapping(path = "delete/{bookId}")
    public void deleteBook(@PathVariable ("bookId") Integer bookId){
        bookService.deleteBook(bookId);
    }
    @PutMapping(path = "update/{bookId}")
    public void updateBook(@PathVariable("bookId") Integer bookId , @RequestBody Book book){
        bookService.addBook(book);
    }
    @GetMapping(path= "author/{bookId}")
    public String getAuthor(@PathVariable(name = "bookId") Integer bookId){
       return bookService.getAuthorBook(bookId) ;
    }

}