package command.product;

import command.addproduct.AddProductCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
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

}
