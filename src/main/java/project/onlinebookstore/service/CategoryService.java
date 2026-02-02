package project.onlinebookstore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.onlinebookstore.dto.category.CategoryDto;
import project.onlinebookstore.entity.Category;
import project.onlinebookstore.exception.NotFoundException;
import project.onlinebookstore.mapper.CategoryMapper;
import project.onlinebookstore.repository.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

        private final CategoryRepository categoryRepository;
        private final CategoryMapper categoryMapper;

        public CategoryDto getById(Long id) {
            Category category = categoryRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException("Category not found!"));
            return categoryMapper.mapToDto(category);
        }

    public CategoryDto save(CategoryDto dto) {
        Category category = new Category();
        category.setName(dto.getName());
        Category saved = categoryRepository.save(category);
        return mapToDto(saved);
        
        }

    private CategoryDto mapToDto(Category category) {
        CategoryDto dto = new CategoryDto();
        dto.setName(category.getName());
                return dto;
    }

    public List<Category> getAll() {
            return categoryRepository.findAll();
        }

        public CategoryDto update(Long id, CategoryDto dto) {
            Category category = categoryRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException("Category not found!"));
            category.setName(dto.getName());
            Category updated = categoryRepository.save(category);
            return mapToDto(updated);
        }


    }
