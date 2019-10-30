package com.example.project.command.product;

import com.example.project.command.addproduct.AddProductEvent;
import com.example.project.command.updateproduct.UpdateProductEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
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

    @EventHandler
    public void on(UpdateProductEvent event) {
        System.out.println("A product was updated! " + event );

//        Product product = new Product(event.getId(), event.getName(), event.getQuantity());
//        this.productRepository.save(product);

    }
}
