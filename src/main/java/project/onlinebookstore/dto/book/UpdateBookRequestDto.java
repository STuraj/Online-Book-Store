package project.onlinebookstore.dto.book;

import lombok.Data;

@Data
public class UpdateBookRequestDto {

        private String title;
        private Double price;
        private Long categoryId;
}
