package com.spring.springwebapp.services;

import com.spring.springwebapp.commands.BookCommand;
import com.spring.springwebapp.converters.BookCommandToBook;
import com.spring.springwebapp.converters.BookToBookCommand;
import com.spring.springwebapp.entities.Book;
import com.spring.springwebapp.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookCommandToBook bookCommandToBook;
    private final BookToBookCommand bookToBookCommand;

    public BookServiceImpl(BookRepository bookRepository, BookCommandToBook bookCommandToBook, BookToBookCommand bookToBookCommand) {
        this.bookRepository = bookRepository;
        this.bookCommandToBook = bookCommandToBook;
        this.bookToBookCommand = bookToBookCommand;
    }

    @Override
    public Set<Book> getBooks() {
        log.debug("I'm in the service");
        Set<Book> bookSet = new HashSet<>();
        bookRepository.findAll().iterator().forEachRemaining(bookSet::add);
        return bookSet;
    }

    @Override
    public Book findById(Long l) {

        Optional<Book> bookOptional = bookRepository.findById(l);

        if (!bookOptional.isPresent()) {
            throw new RuntimeException("Książka nie została znaleziona");
        }
        return bookOptional.get();
    }

    @Override
    @Transactional
    public BookCommand saveBookCommand(BookCommand command) {
        Book detachedBook = bookCommandToBook.convert(command);

        Book savedBook = bookRepository.save(detachedBook);
        log.debug("Saved RecipeId:" + savedBook.getId());
        return bookToBookCommand.convert(savedBook);
    }

    @Override
    public void deleteById(Long idToDelate) {
        bookRepository.deleteById(idToDelate);
    }


    @Override
    @Transactional
    public BookCommand findCommandById(Long l) {
        return bookToBookCommand.convert(findById(l));
    }
}
