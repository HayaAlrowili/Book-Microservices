package com.example.Book.Repositories;
import com.example.Book.Entities.Book;
        import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
        @Query(value = "SELECT * FROM Book WHERE author= :author",nativeQuery = true)
        List<Book> findBooksByAuthor(@Param("author") String author);

}