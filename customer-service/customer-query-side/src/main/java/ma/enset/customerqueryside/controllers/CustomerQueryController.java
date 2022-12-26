package ma.enset.customerqueryside.controllers;

import lombok.AllArgsConstructor;
import ma.enset.customerqueryside.entities.Customer;
import ma.enset.queries.GetAllCustomersQuery;
import ma.enset.queries.GetCustomerByIdQuery;
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
@RequestMapping("/customer/query/")
public class CustomerQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/all")
    public CompletableFuture<List<Customer>> getAllOwners (){
        return  queryGateway.query(new GetAllCustomersQuery(),  ResponseTypes.multipleInstancesOf(Customer.class));
    }

    @GetMapping("/byId/{id}")
    public CompletableFuture<Customer> getOwner(@PathVariable String id){
        return  queryGateway.query(new GetCustomerByIdQuery(id),ResponseTypes.instanceOf(Customer.class));
    }

}
