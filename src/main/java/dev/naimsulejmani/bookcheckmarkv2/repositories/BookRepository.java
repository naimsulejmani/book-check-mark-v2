package dev.naimsulejmani.bookcheckmarkv2.repositories;

import dev.naimsulejmani.bookcheckmarkv2.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByPagesGreaterThan(int pages);

    List<Book> findAllByDiscontinued(boolean discontinued);
}












