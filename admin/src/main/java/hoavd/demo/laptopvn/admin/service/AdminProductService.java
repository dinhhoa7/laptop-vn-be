package hoavd.demo.laptopvn.admin.service;

import hoavd.demo.laptopvn.admin.model.request.ProductRequest;
import hoavd.demo.laptopvn.admin.model.request.ProductUpdateRequest;
import hoavd.demo.laptopvn.admin.model.response.ProductResponse;
import hoavd.demo.laptopvn.common.model.ResponseDataPagination;
import hoavd.demo.laptopvn.common.model.response.ExportProductResponse;
import hoavd.demo.laptopvn.service.entity.Product;

import java.util.List;

public interface AdminProductService {
  Product createProduct(ProductRequest request) throws Exception;

  Product updateProduct(ProductUpdateRequest request) throws Exception;

  void deleteProduct(long id) throws Exception;

  ResponseDataPagination getPageListProduct(String name, long categoryId, int page, int size) throws Exception;

  List<ExportProductResponse> getListProduct(String name) throws Exception;
}
