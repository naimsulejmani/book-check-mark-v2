package dev.naimsulejmani.bookcheckmarkv2.services.impls;

import dev.naimsulejmani.bookcheckmarkv2.dtos.BookDto;
import dev.naimsulejmani.bookcheckmarkv2.mappers.BookMapper;
import dev.naimsulejmani.bookcheckmarkv2.repositories.BookRepository;
import dev.naimsulejmani.bookcheckmarkv2.services.BookService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository repository;
    private final BookMapper mapper;

    @Override
    public List<BookDto> findAll() {
        var books = repository.findAll();
        // return books.stream().map(mapper::toDto).toList();
        return mapper.toDtoList(books);
    }

    @Override
    public BookDto findById(Long id) {
        var optionalBook = repository.findById(id);
        if (optionalBook.isEmpty()) {
            throw new EntityNotFoundException("Book with id " + id + " not found");
        }

        return mapper.toDto(optionalBook.get());
//
//        var optionalBook = repository.findById(id).orElse(null);
//        if (optionalBook == null) {
//            throw new EntityNotFoundException("Book with id " + id + " not found");
//        }
//
//        return mapper.toDto(optionalBook);

    }

    @Override
    public BookDto add(BookDto dto) {
        var entity = mapper.toEntity(dto);
        var savedEntity = repository.save(entity);
        return mapper.toDto(savedEntity);
    }

    @Override
    public BookDto modify(Long id, BookDto dto) {

        if (id != dto.getId()) {
            throw new IllegalArgumentException("Id in path and body must be the same");
        }

        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Book with id " + id + " not found");
        }

        var entity = mapper.toEntity(dto);
        var savedEntity = repository.save(entity);

        return mapper.toDto(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Book with id " + id + " not found");
        }

        repository.deleteById(id);
    }
}





