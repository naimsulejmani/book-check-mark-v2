package dev.naimsulejmani.bookcheckmarkv2.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListingBookDto {

    private long id;
    private String title;
    private String author;
    private String imageUrl;
    private boolean available;
}
