package hoavd.demo.laptopvn.service.service.impl;

import hoavd.demo.laptopvn.service.entity.Product;
import hoavd.demo.laptopvn.service.repository.ProductRepository;
import hoavd.demo.laptopvn.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
  private ProductRepository productRepository;

  @Override
  public Page<Product> getPageListProduct(String name, long category, Pageable pageable) {
    return productRepository.getPageListProduct(name, category, pageable);
  }

  @Override
  public List<Product> getList(String name) {
    return productRepository.getList(name);
  }

  @Override
  public Product getProductById(long id) {
    return productRepository.findById(id);
  }

  @Override
  public Product getByName(String name) {
    return productRepository.findByName(name);
  }

  @Override
  public Product save(Product product) {
    return productRepository.save(product);
  }

  @Override
  public void delete(long id) {
    productRepository.deleteById(id);
  }
}
