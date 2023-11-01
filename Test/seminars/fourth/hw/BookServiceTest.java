package seminars.fourth.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import seminars.fourth.book.Book;
import seminars.fourth.book.BookRepository;
import seminars.fourth.book.BookService;
import seminars.fourth.book.InMemoryBookRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    private BookService bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bookService = new BookService(bookRepository);
    }

    @Test
    public void testFindBookById() {
        String bookId = "1";
        Book expectedBook = new Book(bookId, "Тестовая книга", "Тестовый автор");
        when(bookRepository.findById(bookId)).thenReturn(expectedBook);

        Book foundBook = bookService.findBookById(bookId);

        assertEquals(expectedBook, foundBook);
    }

    @Test
    public void testFindAllBooks() {
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Book("1", "Книга 1", "Автор 1"));
        expectedBooks.add(new Book("2", "Книга 2", "Автор 2"));
        when(bookRepository.findAll()).thenReturn(expectedBooks);

        List<Book> foundBooks = bookService.findAllBooks();

        assertEquals(expectedBooks, foundBooks);
    }

    @Nested
    public class InMemoryBookRepositoryTest {

        private InMemoryBookRepository bookRepository;

        @BeforeEach
        public void setUp() {
            bookRepository = new InMemoryBookRepository();
        }

        @Test
        public void testFindById() {
            String bookId = "1";
            Book foundBook = bookRepository.findById(bookId);
            assertNotNull(foundBook);
            assertEquals(bookId, foundBook.getId());
        }

        @Test
        public void testFindAll() {
            List<Book> allBooks = bookRepository.findAll();
            assertEquals(2, allBooks.size());
        }
    }
}
