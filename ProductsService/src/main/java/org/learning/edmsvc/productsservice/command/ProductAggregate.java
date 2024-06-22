package org.learning.edmsvc.productsservice.command;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.learning.edmsvc.productsservice.core.events.ProductCreatedEvent;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {

    public ProductAggregate() {

    }

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand) {
        // Valid create product command.
        if (createProductCommand.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price cannot be less or equal than zero.");
        }

        if (createProductCommand.getTitle() == null ||
                createProductCommand.getTitle().isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }


        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();
        BeanUtils.copyProperties(createProductCommand, productCreatedEvent);

        AggregateLifecycle.apply(productCreatedEvent);

    }
}
