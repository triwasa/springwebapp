package com.spring.springwebapp.bootstrap;

import com.spring.springwebapp.entities.Book;
import com.spring.springwebapp.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;

    public BootStrapData(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Book book1 = new Book("Władysław Tatarkiewicz", "O szczęściu", "19.99", "Książka polskiego filozofa Władysława Tatarkiewicza poświęcona zagadnieniom szczęścia na gruncie etyki.", "2561197422627");
        bookRepository.save(book1);

        Book book2 = new Book("Jean-Paul Sartre", "Słowa", "59.99", "Antyromantyczna powieść autobiograficzna autorstwa Jean-Paula Sartre’a wydana w 1964.", "8732466723699");
        bookRepository.save(book2);

        Book book3 = new Book("Matthew Kirk", "Python w uczeniu maszynowym", "62.91", "Ten praktyczny przewodnik pozwoli osiągnąć biegłość w stosowaniu uczenia maszynowego w codziennej pracy. Autor, Matthew Kirk, bez akademickich rozważań pokazuje, jak integrować i testować algorytmy uczenia maszynowego w swoim kodzie.", "4809488869446");
        bookRepository.save(book3);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
    }
}
