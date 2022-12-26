package ma.enset.inventoryqueryside.controllers;

import lombok.AllArgsConstructor;
import ma.enset.dtos.CategoryResponseDTO;
import ma.enset.inventoryqueryside.entities.Category;
import ma.enset.queries.GetAllCategoryQuery;
import ma.enset.queries.GetCategoryByIdQuery;
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
@RequestMapping("/categories/query/")
public class CategoryQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/all")
    public CompletableFuture<List<Category>> getAll(){
        return  queryGateway.query(new GetAllCategoryQuery(),  ResponseTypes.multipleInstancesOf(Category.class));
    }

    @GetMapping("/byId/{id}")
    public CompletableFuture<Category> get(@PathVariable String id){
        return  queryGateway.query(new GetCategoryByIdQuery(id),ResponseTypes.instanceOf(Category.class));
    }
}
