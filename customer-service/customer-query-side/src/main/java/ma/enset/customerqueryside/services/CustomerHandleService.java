package ma.enset.customerqueryside.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.customerqueryside.entities.Customer;
import ma.enset.customerqueryside.repositories.CustomerRepository;
import ma.enset.events.CustomerCreatedEvent;
import ma.enset.events.CustomerUpdatedEvent;
import ma.enset.queries.GetAllCustomersQuery;
import ma.enset.queries.GetCustomerByIdQuery;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class CustomerHandleService {
    private CustomerRepository customerRepository;

    @EventHandler
    public void on (CustomerCreatedEvent event){
        log.info("********************");
        log.info("CustomerCreatedEvent  received");
        Customer customer = new Customer();
        customer.setId(event.getId());
        customer.setName(event.getName());
        customer.setEmail(event.getEmail());
        customer.setPhone(event.getPhone());
        customerRepository.save(customer);
    }

    @EventHandler
    public void on (CustomerUpdatedEvent event){
        log.info("********************");
        log.info("CustomerUpdatedEvent  received");
        Customer customer = new Customer();
        customer.setId(event.getId());
        customer.setName(event.getName());
        customer.setEmail(event.getEmail());
        customer.setPhone(event.getPhone());
        customerRepository.save(customer);
    }

    @QueryHandler
    public List<Customer> getAllCustomers(GetAllCustomersQuery query){
        return customerRepository.findAll();
    }

    @QueryHandler
    public Customer getCustomer (GetCustomerByIdQuery query){
        return customerRepository.findById(query.getId())
                .orElseThrow(()->new RuntimeException("Customer not found"));
    }
}
