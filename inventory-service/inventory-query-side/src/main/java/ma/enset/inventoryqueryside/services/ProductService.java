package ma.enset.inventoryqueryside.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.dtos.CategoryResponseDTO;
import ma.enset.dtos.ProductResponseDTO;
import ma.enset.events.CategoryCreatedEvent;
import ma.enset.events.ProductCreatedEvent;
import ma.enset.inventoryqueryside.entities.Category;
import ma.enset.inventoryqueryside.entities.Product;
import ma.enset.inventoryqueryside.mappers.ProductMapper;
import ma.enset.inventoryqueryside.repositories.ProductRepository;
import ma.enset.queries.GetAllCategoryQuery;
import ma.enset.queries.GetAllProductsQuery;
import ma.enset.queries.GetCustomerByIdQuery;
import ma.enset.queries.GetProductByIdQuery;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
public class ProductService {
    private ProductRepository productRepository;

    @EventHandler
    public void on (ProductCreatedEvent event){
        log.info("********************");
        log.info("ProductCreatedEvent received");
        Product product = new Product();
        product.setId(event.getId());
        product.setName(event.getName());
        product.setPrice(event.getPrice());
        product.setQuantity(event.getQuantity());
        product.setState(event.getState());
        product.setCatId(event.getCategoryId());
        productRepository.save(product);
    }
    @QueryHandler
    public List<Product> getAll(GetAllProductsQuery query){
        List<Product> products= productRepository.findAll();
        return products;
    }

    @QueryHandler
    public Product get (GetProductByIdQuery query){
        Product category=  productRepository.findById(query.getId())
                .orElseThrow(()->new RuntimeException("Product not found"));
        return category;
    }
}
