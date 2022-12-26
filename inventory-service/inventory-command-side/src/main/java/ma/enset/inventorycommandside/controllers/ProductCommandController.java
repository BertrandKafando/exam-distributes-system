package ma.enset.inventorycommandside.controllers;

import lombok.AllArgsConstructor;
import ma.enset.commands.CreateProductCommand;
import ma.enset.dtos.ProductCommandDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/inventory/products/command")
@AllArgsConstructor
public class ProductCommandController {
    private CommandGateway commandGateway;

    @PostMapping("/create")
    public CompletableFuture<String> createPr (@RequestBody ProductCommandDTO ownerDTO){
        return  commandGateway.send(new CreateProductCommand(
                UUID.randomUUID().toString(),
                ownerDTO.getName(),
                ownerDTO.getPrice(),
                ownerDTO.getQuantity(),
                ownerDTO.getState(),
                ownerDTO.getCategoryId()
        ));
    }

}
