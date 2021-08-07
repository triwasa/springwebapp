package com.spring.springwebapp.converters;

import com.spring.springwebapp.commands.BookCommand;
import com.spring.springwebapp.entities.Book;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class BookCommandToBook implements Converter<BookCommand, Book> {


    @Synchronized
    @Nullable
    @Override
    public Book convert(BookCommand source) {
        if (source == null) {
            return null;
        }

        final Book book = new Book();
        book.setId(source.getId());
        book.setAuthor(source.getAuthor());
        book.setTitle(source.getTitle());
        book.setPrice(source.getPrice());
        book.setDescritpion(source.getDescritpion());
        book.setEan(source.getEan());

        return book;

    }
}
