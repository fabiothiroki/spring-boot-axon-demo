package command.product;

import command.addproduct.AddProductEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class ProductEventHandler {

    @EventHandler
    public void on(AddProductEvent event) {
        System.out.println("A product was added! " + event );
    }
}
