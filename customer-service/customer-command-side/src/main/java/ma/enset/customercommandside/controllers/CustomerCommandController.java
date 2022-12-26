package ma.enset.customercommandside.controllers;

import lombok.AllArgsConstructor;
import ma.enset.commands.CreateCustomerCommand;
import ma.enset.commands.UpdateCustomerCommand;
import ma.enset.dtos.CustomerCommandDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("/customer/command")
public class CustomerCommandController {
    private CommandGateway commandGateway;


//push command on bus
    @PostMapping("/create")
    public CompletableFuture<String> createCustomer(@RequestBody CustomerCommandDTO command){
         return commandGateway.send(new CreateCustomerCommand(
                 UUID.randomUUID().toString(),
                 command.getName(),
                 command.getEmail(),
                 command.getPhone()
         ));
    }

    @PutMapping("/update/{id}")
    public CompletableFuture<String> updateCustomer(@RequestBody CustomerCommandDTO command, @PathVariable String id ){
        return commandGateway.send(new UpdateCustomerCommand(
                id,
                command.getName(),
                command.getEmail(),
                command.getPhone()
        ));
    }
}
