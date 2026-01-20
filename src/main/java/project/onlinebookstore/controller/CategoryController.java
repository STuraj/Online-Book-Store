package project.onlinebookstore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.onlinebookstore.dto.category.CategoryDto;
import project.onlinebookstore.entity.Category;
import project.onlinebookstore.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

        private final CategoryService categoryService;

        @GetMapping("/{id}")
        public CategoryDto getCategoryById(@PathVariable Long id) {
            return categoryService.getById(id);
        }

        @PostMapping("/save")
        public CategoryDto save(@RequestBody CategoryDto categoryRequestDto) {
            return categoryService.save(categoryRequestDto);
        }
        @GetMapping("/all")
        public List<Category> getAll() {
            return categoryService.getAll();
        }
        @PutMapping("/{id}")
        public CategoryDto update(@PathVariable Long id,
                                  @RequestBody CategoryDto categoryRequestDto) {
            return categoryService.update(id, categoryRequestDto);

        }
}
