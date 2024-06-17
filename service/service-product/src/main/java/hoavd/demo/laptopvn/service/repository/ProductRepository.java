package hoavd.demo.laptopvn.service.repository;

import hoavd.demo.laptopvn.service.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
  @Query(value = "select * from product p where "
    + "(p.name like concat('%', :name, '%') or :name is null or :name='') "
    + "and (p.category_id = :category or 0 = :category) "
    + "and p.is_deleted = false order by p.created_at desc", nativeQuery = true)
  Page<Product> getPageListProduct(@Param("name") String name, @Param("category") long category, Pageable pageable);

  Product findById(long id);

  Product findByName(String name);
}
