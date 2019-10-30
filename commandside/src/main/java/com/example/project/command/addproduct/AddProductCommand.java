package com.example.project.command.addproduct;


import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class AddProductCommand {

    public AddProductCommand(
            final Long id,
            final String name,
            final int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    @TargetAggregateIdentifier
    private final Long id;
    private final String name;
    private final int quantity;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
