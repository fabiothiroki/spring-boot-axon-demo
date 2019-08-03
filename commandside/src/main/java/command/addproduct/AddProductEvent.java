package command.addproduct;

public class AddProductEvent {

    public AddProductEvent(
            final String id,
            final String name,
            final int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

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
