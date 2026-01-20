package project.onlinebookstore.dto.book;

import lombok.Data;

@Data
public class BookRequestDto {
    private String title;
    private String author;
    private Double price;
    private Long categoryId;
}