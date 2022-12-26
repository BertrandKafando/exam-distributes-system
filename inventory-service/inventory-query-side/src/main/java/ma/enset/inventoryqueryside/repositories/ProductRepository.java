package ma.enset.inventoryqueryside.repositories;

import jdk.nashorn.internal.ir.annotations.Reference;
import ma.enset.inventoryqueryside.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
}
