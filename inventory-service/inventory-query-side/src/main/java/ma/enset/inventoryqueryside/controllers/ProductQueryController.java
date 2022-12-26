package ma.enset.inventoryqueryside.controllers;

import lombok.AllArgsConstructor;
import ma.enset.dtos.CategoryResponseDTO;
import ma.enset.dtos.ProductResponseDTO;
import ma.enset.inventoryqueryside.entities.Product;
import ma.enset.queries.GetAllCategoryQuery;
import ma.enset.queries.GetAllProductsQuery;
import ma.enset.queries.GetCategoryByIdQuery;
import ma.enset.queries.GetProductByIdQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("/products/query/")
public class ProductQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/all")
    public CompletableFuture<List<Product>> getAll(){
        return  queryGateway.query(new GetAllProductsQuery(),  ResponseTypes.multipleInstancesOf(Product.class));
    }

    @GetMapping("/byId/{id}")
    public CompletableFuture<Product> get(@PathVariable String id){
        return  queryGateway.query(new GetProductByIdQuery(id),ResponseTypes.instanceOf(Product.class));
    }
}
