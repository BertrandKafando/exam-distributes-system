package ma.enset.inventorycommandside.aggregate;

import lombok.extern.slf4j.Slf4j;
import ma.enset.commands.CreateProductCommand;
import ma.enset.enums.ProductState;
import ma.enset.events.CategoryCreatedEvent;
import ma.enset.events.ProductCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class ProductAggregate {
    @AggregateIdentifier
    private String id;
    private  String name;
    private Double price;
    private Integer quantity;
    private ProductState state;
    private String categoryId;

    public ProductAggregate() {
    }

    @CommandHandler
    public ProductAggregate(CreateProductCommand command) {
        log.info("******************");
        log.info("Command Received");
        //test
        AggregateLifecycle.apply(new ProductCreatedEvent(
                command.getId(),
                command.getName(),
                command.getPrice(),
                command.getQuantity(),
                command.getState(),
                command.getCategoryId()
        ));
    }

    @EventSourcingHandler
    public  void on(ProductCreatedEvent event){
        log.info("****************************");
        log.info("ProductCreatedEvent occured");
        this.id = event.getId();
        this.name = event.getName();
        this.price = event.getPrice();
        this.quantity = event.getQuantity();
        this.state = event.getState();
        this.categoryId = event.getCategoryId();
    }
}
