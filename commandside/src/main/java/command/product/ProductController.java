package command.product;

import command.addproduct.AddProductCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    public ProductController(final CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    private CommandGateway commandGateway;

    @PostMapping
    public CompletableFuture<String> create() {
        AddProductCommand command = new AddProductCommand(
                UUID.randomUUID().toString(),
                "name",
                1);
        return commandGateway.send(command);
    }

}