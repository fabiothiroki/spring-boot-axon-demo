package command.product;

import com.example.project.command.addproduct.AddProductCommand;
import com.example.project.command.addproduct.AddProductEvent;
import com.example.project.command.updateproduct.UpdateProductCommand;
import com.example.project.command.updateproduct.UpdateProductEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Slf4j
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

    @CommandHandler
    public void handle(UpdateProductCommand cmd) {
        log.info("Handling command {}: {}", cmd.getClass().getSimpleName(), cmd);
        apply(new UpdateProductEvent(cmd.getId(), cmd.getQuantity()));
        log.info("Done handling command {}: {}", cmd.getClass().getSimpleName(), cmd);
    }

    @EventSourcingHandler
    public void on(AddProductEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.quantity = event.getQuantity();
    }

    @EventSourcingHandler
    public void on(UpdateProductEvent event) {
        this.quantity = event.getQuantity();
    }

    protected ProductAggregate() { }
}
