package project.onlinebookstore.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import project.onlinebookstore.dto.category.CategoryDto;
import project.onlinebookstore.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

         Category mapToEntity(CategoryDto dto);

        CategoryDto mapToDto(Category savedCategory);

        @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
        Category update(CategoryDto categoryDto, @MappingTarget Category category) ;

    }
