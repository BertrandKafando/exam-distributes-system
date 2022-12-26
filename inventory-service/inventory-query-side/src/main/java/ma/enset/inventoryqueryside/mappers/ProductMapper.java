package ma.enset.inventoryqueryside.mappers;

import ma.enset.dtos.CategoryResponseDTO;
import ma.enset.dtos.ProductResponseDTO;
import ma.enset.inventoryqueryside.entities.Category;
import ma.enset.inventoryqueryside.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    public ProductResponseDTO todto(Product product);
}
