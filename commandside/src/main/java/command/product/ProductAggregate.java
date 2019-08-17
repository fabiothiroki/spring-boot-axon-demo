package command.product;

import command.addproduct.AddProductCommand;
import command.addproduct.AddProductEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private Long id;
    private String name;
    private int quantity;

    @CommandHandler
    public ProductAggregate(AddProductCommand cmd) {
        apply(new AddProductEvent(cmd.getId(), cmd.getName(), cmd.getQuantity()));
    }

    @EventSourcingHandler
    public void on(AddProductEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.quantity = event.getQuantity();
    }

    protected ProductAggregate() { }
}
