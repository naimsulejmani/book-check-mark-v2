package dev.naimsulejmani.bookcheckmarkv2.controllers.api.v1;

import dev.naimsulejmani.bookcheckmarkv2.dtos.BookDto;
import dev.naimsulejmani.bookcheckmarkv2.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookApiController {
    private final BookService service;

    @GetMapping
    public List<BookDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public BookDto findById(@PathVariable long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public BookDto add(@RequestBody BookDto bookDto) {
        return service.add(bookDto);//url to newly added book
    }

    @PutMapping("/{id}")
    public BookDto modify(@PathVariable long id, @RequestBody BookDto bookDto) {
        return service.modify(id, bookDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        service.deleteById(id);
    }

    @GetMapping("/default")
    public BookDto defaultBook() {
        return new BookDto();
    }

}












