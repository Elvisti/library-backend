package com.library.books.domain.repository;

import com.library.books.domain.model.Book;

import java.util.List;

public interface BooksRepository {

    List<Book> getAll();
}
