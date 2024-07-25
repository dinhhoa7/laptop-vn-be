package hoavd.demo.laptopvn.service.service;

import hoavd.demo.laptopvn.service.entity.Category;
import hoavd.demo.laptopvn.service.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
  Page<Product> getPageListProduct(String name, long category, Pageable pageable);

  List<Product> getList(String name);

  Product getProductById(long id);

  Product getByName(String name);

  Product save(Product product);

  void delete(long id);
}
