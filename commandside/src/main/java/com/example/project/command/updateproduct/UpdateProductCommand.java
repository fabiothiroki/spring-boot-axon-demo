package com.example.project.command.updateproduct;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class UpdateProductCommand {

    public UpdateProductCommand(Long id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    @TargetAggregateIdentifier
    private final Long id;
    private final int quantity;

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }
}
