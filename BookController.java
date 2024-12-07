package com.klef.jfsd.exam.controller;

import com.klef.jfsd.exam.model.Book;
import com.klef.jfsd.exam.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Optional<Book> book = bookService.updateBook(id, updatedBook);
        return book.isPresent()
                ? ResponseEntity.ok("Book updated successfully!")
                : ResponseEntity.notFound().build();
    }
}