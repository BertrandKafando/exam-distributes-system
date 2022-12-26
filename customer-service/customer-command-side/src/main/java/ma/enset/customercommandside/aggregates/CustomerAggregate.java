package ma.enset.customercommandside.aggregates;

import lombok.extern.slf4j.Slf4j;
import ma.enset.commands.CreateCustomerCommand;
import ma.enset.commands.UpdateCustomerCommand;
import ma.enset.events.CustomerCreatedEvent;
import ma.enset.events.CustomerUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class CustomerAggregate {
    @AggregateIdentifier
    private String id;
    private  String name;
    private String email;
    private String phone;

    public CustomerAggregate() {
    }

    @CommandHandler
    public CustomerAggregate(CreateCustomerCommand command){
        log.info("*******************************");
        log.info("CreateCustomerCommand Received");

        AggregateLifecycle.apply(new CustomerCreatedEvent (
                command.getId(),
                command.getName(),
                command.getEmail(),
                command.getPhone()
        ));
    }

    //evolution

    @EventSourcingHandler
    public void on (CustomerCreatedEvent event){
        log.info("****************************");
        log.info("CustomerCreatedEvent occured");

        this.id = event.getId();
        this.name = event.getName();
        this.email = event.getEmail();
        this.phone = event.getPhone();
    }

    @CommandHandler
    public CustomerAggregate(UpdateCustomerCommand command){
        log.info("*******************************");
        log.info("UpdateCustomerCommand Received");

        AggregateLifecycle.apply(new CustomerUpdatedEvent(
                command.getId(),
                command.getName(),
                command.getEmail(),
                command.getPhone()
        ));
    }

    //evolution

    @EventSourcingHandler
    public void on (CustomerUpdatedEvent event){
        log.info("****************************");
        log.info("CustomerUpdatedEvent occured");

        this.id = event.getId();
        this.name = event.getName();
        this.email = event.getEmail();
        this.phone = event.getPhone();
    }
}
