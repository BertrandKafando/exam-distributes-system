package ma.enset.inventoryqueryside.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.dtos.CategoryResponseDTO;
import ma.enset.events.CategoryCreatedEvent;
import ma.enset.inventoryqueryside.entities.Category;
import ma.enset.inventoryqueryside.mappers.CategoryMapper;
import ma.enset.inventoryqueryside.repositories.CategoryRepository;
import ma.enset.queries.GetAllCategoryQuery;
import ma.enset.queries.GetCategoryByIdQuery;
import ma.enset.queries.GetCustomerByIdQuery;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
public class CategoryService {
    private CategoryRepository categoryRepository;

    @EventHandler
    public void on (CategoryCreatedEvent event){
        log.info("********************");
        log.info("CategoryCreatedEvent received");
        Category category = new Category();
        category.setId(event.getId());
        category.setName(event.getName());
        category.setDescription(event.getDescription());
        categoryRepository.save(category);
    }
    @QueryHandler
    public List<Category> getAll(GetAllCategoryQuery query){
        List<Category> categories= categoryRepository.findAll();
        return categories;
    }

    @QueryHandler
    public Category get (GetCategoryByIdQuery query){
        Category  category=  categoryRepository.findById(query.getId())
                .orElseThrow(()->new RuntimeException("Owner not found"));
        return category;
    }
}
