package ma.enset.inventoryqueryside.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.enums.ProductState;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private  String name;
    private Double price;
    private Integer quantity;
    private ProductState state;
    private String  catId ;
    @ManyToOne
    private Category category;
}
