package com.example.project.command.addproduct;

public class AddProductEvent {

    public AddProductEvent(
            final Long id,
            final String name,
            final int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

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
