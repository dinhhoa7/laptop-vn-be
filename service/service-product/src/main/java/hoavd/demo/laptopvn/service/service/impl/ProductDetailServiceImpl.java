package hoavd.demo.laptopvn.service.service.impl;

import hoavd.demo.laptopvn.service.entity.ProductDetail;
import hoavd.demo.laptopvn.service.repository.ProductDetailRepository;
import hoavd.demo.laptopvn.service.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {
  @Autowired
  private ProductDetailRepository productDetailRepository;

  @Override
  public ProductDetail getProductDetailByProductId(long productId) {
    return productDetailRepository.findByProductId(productId);
  }
}
