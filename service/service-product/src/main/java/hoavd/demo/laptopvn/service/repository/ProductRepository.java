package hoavd.demo.laptopvn.service.repository;

import hoavd.demo.laptopvn.service.entity.Category;
import hoavd.demo.laptopvn.service.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
  @Query(value = "select * from product p order by p.name desc", nativeQuery = true)
  Page<Product> getPageListProduct(Pageable pageable);

  Product findById(long id);

  Product findByName(String name);
}
