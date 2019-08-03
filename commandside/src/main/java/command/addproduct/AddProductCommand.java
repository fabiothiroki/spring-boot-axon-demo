package command.addproduct;


import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class AddProductCommand {

    public AddProductCommand(
            final String id,
            final String name,
            final int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    @TargetAggregateIdentifier
    private final String id;
    private final String name;
    private final int quantity;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
