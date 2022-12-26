package ma.enset.inventoryqueryside.mappers;

import ma.enset.dtos.CategoryResponseDTO;
import ma.enset.events.CategoryCreatedEvent;
import ma.enset.inventoryqueryside.entities.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
   public CategoryResponseDTO todto( Category category);


}
