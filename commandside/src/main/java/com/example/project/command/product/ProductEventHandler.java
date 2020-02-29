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

//    @Autowired
//    private ProductAggregateRepository productAggregateRepository;

    @EventHandler
    public void on(AddProductEvent event) {
        System.out.println("A product was added! " + event );

//        ProductAggregate product = new ProductAggregate(event);
//
//        this.productAggregateRepository.save(product);

    }

    @EventHandler
    public void on(UpdateProductEvent event) {
        System.out.println("A product was updated! " + event );
    }
}
