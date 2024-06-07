package com.example.tdd;

import java.util.List;

public class FakeRepositoryForTest implements IBookRepository{
    public static List<Book> booksList = List.of(
            new Book("1", "Test Driven Development", "Kent Beck"),
            new Book("3", "Effective Java", "Joshua Bloch"),
            new Book("4", "Refactoring", "Martin Fowler")
    );

    @Override
    public List<Book> findAllBooks() {
        return booksList;
    }
}
