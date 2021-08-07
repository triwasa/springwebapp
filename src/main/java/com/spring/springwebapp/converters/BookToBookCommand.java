package com.spring.springwebapp.converters;

import com.spring.springwebapp.commands.BookCommand;
import com.spring.springwebapp.entities.Book;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class BookToBookCommand implements Converter<Book, BookCommand> {

    @Synchronized
    @Nullable
    @Override
    public BookCommand convert(Book source) {
        if (source == null) {
            return null;
        }

        final BookCommand command = new BookCommand();
        command.setId(source.getId());
        command.setTitle(source.getTitle());
        command.setAuthor(source.getAuthor());
        command.setDescritpion(source.getDescritpion());
        command.setPrice(source.getPrice());
        command.setEan(source.getEan());

        return command;

    }
}
