package command.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    public Product() {}

    public Product(
            final Long id,
            final String name,
            final int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    @Id
    public Long id;

    @Column
    public String name;

    @Column
    public int quantity;

}
