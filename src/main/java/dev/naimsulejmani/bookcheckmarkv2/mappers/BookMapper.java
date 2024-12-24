package dev.naimsulejmani.bookcheckmarkv2.mappers;

import dev.naimsulejmani.bookcheckmarkv2.dtos.BookDto;
import dev.naimsulejmani.bookcheckmarkv2.dtos.ListingBookDto;
import dev.naimsulejmani.bookcheckmarkv2.models.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper extends SimpleMapper<Book, BookDto> {
    @Mapping(source = "coverImageUrl", target = "imageUrl")
//    @Mapping(source="author.name", target = "authorName")
    @Mapping(source = "discontinued", target = "available", qualifiedByName = "discontinuedToAvailable")
    ListingBookDto toListingBookDto(Book book);

    @Named("discontinuedToAvailable")
    default boolean discontinuedToAvailable(boolean discontinued) {
        return !discontinued;
    }

    List<ListingBookDto> toListingBookDtoList(List<Book> books);
}








