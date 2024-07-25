package hoavd.demo.laptopvn.service.repository;

import hoavd.demo.laptopvn.service.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
  ProductDetail findByProductId(long productId);
}
