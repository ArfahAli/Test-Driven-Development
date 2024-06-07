package com.example.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BookServiceTest {

    private BookService bookService;

    @BeforeEach
    public void setUp() {
        FakeRepositoryForTest.booksList = Arrays.asList(
                new Book("1", "Test Driven Development", "Kent Beck"),
                new Book("2", "Clean Code", "Robert C. Martin"),
                new Book("3", "Effective Java", "Joshua Bloch"),
                new Book("4", "Refactoring", "Martin Fowler"),
                new Book("5", "Clean Architecture", "Robert C. Martin")
        );
        IBookRepository bookRepository = new FakeRepositoryForTest();
        bookService = new BookService(bookRepository);
    }

    // Tests for getBooksByAuthor
    @Test
    public void testGetBooksByAuthor() {
        List<Book> books = bookService.getBooksByAuthor("Kent Beck");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Test Driven Development", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByAuthor_MultipleBooks() {
        List<Book> books = bookService.getBooksByAuthor("Martin Fowler");
        Assertions.assertTrue(books.size() > 1);

    }

    @Test
    public void testGetBooksByAuthor_NoBooksFound() {
        List<Book> books = bookService.getBooksByAuthor("Unknown Author");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthor_SingleBook() {
        List<Book> books = bookService.getBooksByAuthor("Martin Fowler");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Refactoring", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByAuthor_EmptyAuthor() {
        List<Book> books = bookService.getBooksByAuthor("");
        Assertions.assertEquals(0, books.size());
    }

    // Tests for getBooksByTitle
    @Test
    public void testGetBooksByTitle() {
        List<Book> books = bookService.getBooksByTitle("Clean Code");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Robert C. Martin", books.get(0).getAuthor());
    }

    @Test
    public void testGetBooksByTitle_MultipleAuthors() {
        FakeRepositoryForTest.booksList = Arrays.asList(
                new Book("1", "Effective Java", "Joshua Bloch"),
                new Book("2", "Effective Java", "Unknown Author")
        );

        List<Book> books = bookService.getBooksByTitle("Effective Java");
        Assertions.assertEquals(2, books.size());
        Assertions.assertTrue(books.stream().anyMatch(book -> book.getAuthor().equals("Joshua Bloch")));
        Assertions.assertTrue(books.stream().anyMatch(book -> book.getAuthor().equals("Unknown Author")));

    }

    @Test
    public void testGetBooksByTitle_NoBooksFound() {
        List<Book> books = bookService.getBooksByTitle("Unknown Title");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByTitle_SingleBook() {
        List<Book> books = bookService.getBooksByTitle("Refactoring");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Martin Fowler", books.get(0).getAuthor());
    }

    @Test
    public void testGetBooksByTitle_EmptyTitle() {
        List<Book> books = bookService.getBooksByTitle("");
        Assertions.assertEquals(0, books.size());
    }

    // Tests for getBooksByTitleAndAuthor
    @Test
    public void testGetBooksByTitleAndAuthor() {
        List<Book> books = bookService.getBooksByTitleAndAuthor("Clean Code", "Robert C. Martin");
        Assertions.assertEquals(1, books.size());
    }

    @Test
    public void testGetBooksByTitleAndAuthor_MultipleBooks() {
        FakeRepositoryForTest.booksList = Arrays.asList(
                new Book("1", "Test Driven Development", "Kent Beck"),
                new Book("2", "Clean Code", "Robert C. Martin"),
                new Book("3", "Clean Code", "Some Other Author"),
                new Book("4", "Refactoring", "Martin Fowler")
        );
        List<Book> books = bookService.getBooksByTitleAndAuthor("Clean Code", "Robert C. Martin");
        Assertions.assertEquals(1, books.size());
    }

    @Test
    public void testGetBooksByTitleAndAuthor_NoBooksFound() {
        List<Book> books = bookService.getBooksByTitleAndAuthor("Unknown Title", "Unknown Author");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByTitleAndAuthor_SingleBook() {
        List<Book> books = bookService.getBooksByTitleAndAuthor("Refactoring", "Martin Fowler");
        Assertions.assertEquals(1, books.size());
    }

    @Test
    public void testGetBooksByTitleAndAuthor_EmptyTitleAndAuthor() {
        List<Book> books = bookService.getBooksByTitleAndAuthor("", "");
        Assertions.assertEquals(0, books.size());
    }
}