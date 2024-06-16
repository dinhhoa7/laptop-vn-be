package hoavd.demo.laptopvn.admin.service;

import hoavd.demo.laptopvn.admin.model.ProductRequest;
import hoavd.demo.laptopvn.admin.model.ProductUpdateRequest;
import hoavd.demo.laptopvn.common.model.ResponseDataPagination;
import hoavd.demo.laptopvn.service.entity.Product;

public interface AdminProductService {
  Product createProduct(ProductRequest request) throws Exception;

  Product updateProduct(ProductUpdateRequest request) throws Exception;

  void deleteProduct(long id) throws Exception;

  ResponseDataPagination getPageListProduct(int page, int size) throws Exception;
}
