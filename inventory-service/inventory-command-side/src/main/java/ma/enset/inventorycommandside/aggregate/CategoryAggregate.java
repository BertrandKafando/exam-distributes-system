package ma.enset.inventorycommandside.aggregate;

import lombok.extern.slf4j.Slf4j;
import ma.enset.commands.CreateCategoryCommand;
import ma.enset.commands.CreateCustomerCommand;
import ma.enset.events.CategoryCreatedEvent;
import ma.enset.events.ProductCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class CategoryAggregate {
    @AggregateIdentifier
    private String id;
    private  String name;
    private String description;

    public CategoryAggregate() {
    }

    @CommandHandler
    public CategoryAggregate(CreateCategoryCommand command) {
        log.info("******************");
        log.info("Command Received");
        //test
        AggregateLifecycle.apply(new CategoryCreatedEvent(
                command.getId(),
                command.getName(),
                command.getDescription()
        ));
    }
}
