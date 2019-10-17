package command.product;

import command.addproduct.AddProductCommand;
import command.updateproduct.UpdateProductCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    public ProductController(final CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    private CommandGateway commandGateway;

    @PostMapping
    public CompletableFuture<String> create(@RequestBody ProductDTO dto) {
        AddProductCommand command = new AddProductCommand(
                dto.getId(),
                dto.getName(),
                dto.getQuantity());
        return commandGateway.send(command);
    }

    @PutMapping
    public CompletableFuture<String> update(@RequestBody ProductDTO dto) {
        UpdateProductCommand command = new UpdateProductCommand(
                dto.getId(),
                dto.getQuantity());
        return commandGateway.send(command);
    }

    @GetMapping
    public String get() {
        return "It works!";
    }

}
