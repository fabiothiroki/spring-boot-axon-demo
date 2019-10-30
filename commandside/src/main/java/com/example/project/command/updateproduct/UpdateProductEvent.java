package com.example.project.command.updateproduct;

public class UpdateProductEvent {

    public UpdateProductEvent(Long id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    private final Long id;
    private final int quantity;

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }
}
