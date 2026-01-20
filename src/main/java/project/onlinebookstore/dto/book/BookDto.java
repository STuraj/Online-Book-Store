package project.onlinebookstore.dto.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDto {

        private Long id;
        private String title;
        private String author;
        private Double price;
        private String categoryName;
}
