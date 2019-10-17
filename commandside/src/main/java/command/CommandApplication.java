package command;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.project.axon-demo")
public class CommandApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommandApplication.class, args);
    }
}
