package dev.naimsulejmani.bookcheckmarkv2.repositories;

import dev.naimsulejmani.bookcheckmarkv2.models.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DbInitializer implements Runnable {

    private final BookRepository bookRepository;

    @Override
    public void run() {
        if (bookRepository.count() == 0) {
            System.out.println("Initializing database with sample data");
            Book book = new Book();
            book.setTitle("The Great Gatsby");
            book.setAuthor("F. Scott Fitzgerald");
            book.setPublishedYear(1925);
            book.setPages(180);
            book.setCoverImageUrl("https://images-na.ssl-images-amazon.com/images/I/51Y3V5aX6oL._SX325_BO1,204,203,200_.jpg");
            book.setDiscontinued(false);
            bookRepository.save(book);
        }


    }
}
