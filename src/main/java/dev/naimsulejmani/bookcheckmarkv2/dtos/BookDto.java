package dev.naimsulejmani.bookcheckmarkv2.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    @PositiveOrZero(message = "Id must be positive or zero")
    private long id;

    @NotNull(message = "Title must not be null")
    @NotBlank(message = "Title must not be blank")
    @Size(min=1, max = 200, message = "Title must be between 1 and 200 characters")
    private String title;


    private String coverImageUrl;

    @NotNull(message = "Author must not be null")
    @NotBlank(message = "Author must not be blank")
    @Size(max = 200, message = "Author must be between 0 and 200 characters")
    private String author;

    @PositiveOrZero(message = "Published year must be positive or zero")
    private int publishedYear;

    @PositiveOrZero(message = "Pages must be positive or zero")
    private int pages;


    public boolean discontinued;
}
