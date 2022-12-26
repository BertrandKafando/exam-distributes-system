package ma.enset.inventorycommandside.controllers;

import lombok.AllArgsConstructor;
import ma.enset.commands.CreateCategoryCommand;
import ma.enset.dtos.CategoryCommandDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/categories/command")
@AllArgsConstructor
public class CategoryCommandController {
    private CommandGateway commandGateway;

    @PostMapping("/create")
    public CompletableFuture<String> createCateg (@RequestBody CategoryCommandDTO ownerDTO){
        return  commandGateway.send(new CreateCategoryCommand(
                UUID.randomUUID().toString(),
                ownerDTO.getName(),
                ownerDTO.getDescription()
        ));
    }
}
