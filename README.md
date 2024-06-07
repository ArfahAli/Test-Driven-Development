# Test Driven Development
 Book Service Test Project

This project demonstrates the implementation of a simple book service with unit tests using Test Driven Development (TDD) principles. The book service provides methods to retrieve books by author, title, and both title and author.
Project Structure

The project consists of the following main components:

    BookService: The service class that provides methods to retrieve books based on various criteria.
    IBookRepository: The repository interface that defines the method to retrieve all books.
    FakeRepositoryForTest: A fake repository implementation used for testing purposes.
    Book: A simple model class representing a book.
    BookServiceTest: The test class containing unit tests for the BookService.

Prerequisites

    Java 8 or higher
    JUnit 5

Project Setup

    Clone the repository:

    bash

    git clone https://github.com/your-username/book-service-tdd.git
    cd book-service-tdd

    Open the project in your IDE: Import the project as a Maven project if you are using an IDE like IntelliJ IDEA or Eclipse.

Running the Tests

To run the tests, execute the following command in the root directory of the project:

bash

mvn test

Classes Overview
BookService

The BookService class provides three main methods to retrieve books:

    getBooksByAuthor(String author): Retrieves a list of books by the specified author.
    getBooksByTitle(String title): Retrieves a list of books by the specified title.
    getBooksByTitleAndAuthor(String title, String author): Retrieves a list of books by the specified title and author.

IBookRepository

The IBookRepository interface defines a method to retrieve all books:

    List<Book> findAllBooks(): Returns a list of all books.

FakeRepositoryForTest

The FakeRepositoryForTest class is a fake implementation of IBookRepository used for testing purposes. It contains a static list of books that can be modified during tests.
Book

The Book class is a simple model representing a book with the following fields:

    id: The unique identifier of the book.
    title: The title of the book.
    author: The author of the book.

BookServiceTest

The BookServiceTest class contains unit tests for the BookService class. The tests cover the following scenarios:

    Retrieving books by author with a single book.
    Retrieving books by author with multiple books.
    Retrieving books by author with no books found.
    Retrieving books by author with an empty author string.
    Retrieving books by title with a single book.
    Retrieving books by title with multiple books.
    Retrieving books by title with no books found.
    Retrieving books by title with an empty title string.
    Retrieving books by both title and author with a single book.
    Retrieving books by both title and author with multiple books.
    Retrieving books by both title and author with no books found.
    Retrieving books by both title and author with empty title and author strings.

Example Usage

The BookService can be used as follows:

java

IBookRepository bookRepository = new FakeRepositoryForTest();
BookService bookService = new BookService(bookRepository);

List<Book> booksByAuthor = bookService.getBooksByAuthor("Kent Beck");
List<Book> booksByTitle = bookService.getBooksByTitle("Clean Code");
List<Book> booksByTitleAndAuthor = bookService.getBooksByTitleAndAuthor("Refactoring", "Martin Fowler");

Contributing

Feel free to fork the repository and submit pull requests. For major changes, please open an issue first to discuss what you would like to change.
License

This project is licensed under the MIT License. See the LICENSE file for details.
