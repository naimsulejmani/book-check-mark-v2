package dev.naimsulejmani.bookcheckmarkv2.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 200)
    private String author;

    @Column(nullable = false)
    private int publishedYear;

    @Column(nullable = false)
    private int pages;

    @Column(nullable = false, length = 2000)
    private String coverImageUrl;

    public boolean discontinued;

}





















