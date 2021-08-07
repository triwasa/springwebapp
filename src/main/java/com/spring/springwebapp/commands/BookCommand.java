package com.spring.springwebapp.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookCommand {
    private Long id;
    private String title;
    private String author;
    private String price;
    private String descritpion;
    private String ean;
}
