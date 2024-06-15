package hoavd.demo.laptopvn.service.repository;

import hoavd.demo.laptopvn.service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
