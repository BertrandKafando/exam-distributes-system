package ma.enset.inventoryqueryside.repositories;

import ma.enset.inventoryqueryside.entities.Category;
import ma.enset.inventoryqueryside.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {
}
