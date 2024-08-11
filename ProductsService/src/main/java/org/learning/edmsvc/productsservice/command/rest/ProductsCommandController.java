package org.learning.edmsvc.productsservice.command.rest;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.learning.edmsvc.productsservice.command.CreateProductCommand;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsCommandController {

    private final Environment environment;
    private final CommandGateway commandGateway;

    @PostMapping
    public String createProduct(@Valid @RequestBody CreateProductRestModel createProductRestModel) {
        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .price(createProductRestModel.getPrice())
                .title(createProductRestModel.getTitle())
                .quantity(createProductRestModel.getQuantity())
                .productId(UUID.randomUUID().toString()).build();

        String returnValue;

//        try {
//            returnValue = commandGateway.sendAndWait(createProductCommand);
//        } catch (Exception e) {
//            returnValue = e.getLocalizedMessage();
//        }
        returnValue = commandGateway.sendAndWait(createProductCommand);

        return returnValue;
    }
}
