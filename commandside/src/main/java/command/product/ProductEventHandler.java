package command.product;

import command.addproduct.AddProductEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductEventHandler {

    @Autowired
    private ProductRepository productRepository;

    @EventHandler
    public void on(AddProductEvent event) {
        System.out.println("A product was added! " + event );

        Product product = new Product(event.getId(), event.getName(), event.getQuantity());

        this.productRepository.save(product);

    }
}
