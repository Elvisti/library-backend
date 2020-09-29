package com.library.books.adapter.web;

import com.library.books.application.exception.BookNotFound;
import com.library.books.domain.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BooksRestController.class);


    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        LOGGER.info("Received request to GET All books");
//        final List<Book> books = booksRepository.getAll();
//
//        LOGGER.info("Book list: ", Book.books);
        return new ResponseEntity<>(Book.books, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getBookById(@PathVariable("id") int id) {
        LOGGER.info("Searching book {id}", id);
        Book book = new Book();
        book.setId(id);

        int index = Book.books.indexOf(book);
        if (index == -1) {
            LOGGER.info("Book not found");
            return new ResponseEntity<>(new BookNotFound("Book not found"), HttpStatus.NOT_FOUND);
        }
        LOGGER.info("Book found");
        return new ResponseEntity<>(Book.books.get(index), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createBook() {
        LOGGER.info("Received request to create book");
        return null;
    }

}
