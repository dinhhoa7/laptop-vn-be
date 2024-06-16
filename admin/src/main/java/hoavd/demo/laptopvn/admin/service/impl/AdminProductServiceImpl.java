package hoavd.demo.laptopvn.admin.service.impl;

import hoavd.demo.laptopvn.admin.model.CategoryRequest;
import hoavd.demo.laptopvn.admin.model.CategoryUpdateRequest;
import hoavd.demo.laptopvn.admin.model.ProductRequest;
import hoavd.demo.laptopvn.admin.model.ProductUpdateRequest;
import hoavd.demo.laptopvn.admin.service.AdminProductService;
import hoavd.demo.laptopvn.common.constants.ResponseMessageConstants;
import hoavd.demo.laptopvn.common.enums.Enums;
import hoavd.demo.laptopvn.common.exception.BusinessException;
import hoavd.demo.laptopvn.common.model.Pagination;
import hoavd.demo.laptopvn.common.model.ResponseDataPagination;
import hoavd.demo.laptopvn.service.entity.Category;
import hoavd.demo.laptopvn.service.entity.Product;
import hoavd.demo.laptopvn.service.service.CategoryService;
import hoavd.demo.laptopvn.service.service.ProductService;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminProductServiceImpl implements AdminProductService {
  private static final Logger logger = LoggerFactory.getLogger(AdminProductServiceImpl.class);

  @Autowired
  private ProductService productService;

  @Override
  public Product createProduct(ProductRequest request) throws Exception {
    Product productName = productService.getByName(request.getName());
    if (productName != null)
      throw new BusinessException(ResponseMessageConstants.PRODUCT_NAME_ALREADY_EXIST);
    Product product = new Product();
    product.setCode(request.getCode());
    product.setCategoryId(request.getCategoryId());
    product.setName(request.getName());
    product.setStatus(request.isStatus());
    product.setPrice(request.getPrice());
    product.create();
    return productService.save(product);
  }

  @Override
  public Product updateProduct(ProductUpdateRequest request) throws Exception {
    logger.info(request.toString());
    Product product = productService.getProductById(request.getId());
    if (product == null)
      throw new BusinessException(ResponseMessageConstants.PRODUCT_DOES_NOT_EXIST);
    if (Strings.isBlank(request.getName())){
      throw new BusinessException(ResponseMessageConstants.INFORMATION_INVALID);
    }
    product.setCode(request.getCode());
    product.setCategoryId(request.getCategoryId());
    product.setName(request.getName());
    product.setStatus(request.isStatus());
    product.setPrice(request.getPrice());
    product.update();
    return productService.save(product);
  }

  @Override
  public void deleteProduct(long id) throws Exception {
    Product product = productService.getProductById(id);
    if (product == null)
      throw new BusinessException(ResponseMessageConstants.PRODUCT_DOES_NOT_EXIST);
    productService.delete(id);
  }

  @Override
  public ResponseDataPagination getPageListProduct(int page, int size) throws Exception {
    ResponseDataPagination responseDataPagination = new ResponseDataPagination();
    int pageReq = page >= 1 ? page - 1 : page;
    Pageable pageable = PageRequest.of(pageReq, size);
    Page<Product> productPage = productService.getPageListProduct(pageable);
    List<Product> productList = productPage.getContent();
    responseDataPagination.setData(productList);
    Pagination pagination = new Pagination();
    pagination.setCurrentPage(page);
    pagination.setPageSize(size);
    pagination.setTotalPage(productPage.getTotalPages());
    pagination.setTotalRecords(productPage.getTotalElements());
    responseDataPagination.setStatus(Enums.ResponseStatus.SUCCESS.getStatus());
    responseDataPagination.setPagination(pagination);
    return responseDataPagination;
  }
}
