package com.spring.springwebapp.services;

import com.spring.springwebapp.commands.BookCommand;
import com.spring.springwebapp.entities.Book;
import java.util.Set;

public interface BookService {

    Set<Book> getBooks();

    Book findById(Long l);

    BookCommand saveBookCommand(BookCommand command);

    void deleteById(Long valueOf);

    BookCommand findCommandById(Long l);

}
