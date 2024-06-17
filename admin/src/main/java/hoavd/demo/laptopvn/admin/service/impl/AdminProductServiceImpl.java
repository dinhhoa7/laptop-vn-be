package hoavd.demo.laptopvn.admin.service.impl;

import hoavd.demo.laptopvn.admin.model.request.ProductRequest;
import hoavd.demo.laptopvn.admin.model.request.ProductUpdateRequest;
import hoavd.demo.laptopvn.admin.model.response.ProductDetailResponse;
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

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminProductServiceImpl implements AdminProductService {
  private static final Logger logger = LoggerFactory.getLogger(AdminProductServiceImpl.class);

  @Autowired
  private ProductService productService;

  @Autowired
  private CategoryService categoryService;

  @Override
  public Product createProduct(ProductRequest request) throws Exception {
    Product productName = productService.getByName(request.getName());
    if (productName != null)
      throw new BusinessException(ResponseMessageConstants.PRODUCT_NAME_ALREADY_EXIST);
    Product product = new Product();
    product.setCode(request.getCode());
    product.setCategoryId(request.getCategoryId());
    product.setName(request.getName());
    product.setDescription(request.getDescription());
    product.setDeleted(false);
    product.setStatus(true);
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
    product.setDescription(request.getDescription());
    product.setStatus(request.isStatus());
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
  public ResponseDataPagination getPageListProduct(String name, long category, int page, int size) throws Exception {
    int pageReq = page >= 1 ? page - 1 : page;
    Pageable pageable = PageRequest.of(pageReq, size);
    Page<Product> productPage = productService.getPageListProduct(name, category, pageable);
    List<Product> productList = productPage.getContent();
    List<ProductDetailResponse> productDetailResponseList = new ArrayList<>();
    for (Product pr : productList){
      ProductDetailResponse res = new ProductDetailResponse();
      Category categoryObj = categoryService.getCategoryById(pr.getCategoryId());
      res.setId(pr.getId());
      res.setCode(pr.getCode());
      res.setCategoryId(pr.getCategoryId());
      res.setCategoryName(categoryObj.getName());
      res.setName(pr.getName());
      res.setDescription(pr.getDescription());
      res.setDeleted(pr.isDeleted());
      res.setStatus(pr.isStatus());
      productDetailResponseList.add(res);
    }
    ResponseDataPagination responseDataPagination = new ResponseDataPagination();
    Pagination pagination = new Pagination();
    responseDataPagination.setData(productDetailResponseList);
    pagination.setCurrentPage(page);
    pagination.setPageSize(size);
    pagination.setTotalPage(productPage.getTotalPages());
    pagination.setTotalRecords(productPage.getTotalElements());
    responseDataPagination.setStatus(Enums.ResponseStatus.SUCCESS.getStatus());
    responseDataPagination.setPagination(pagination);
    return responseDataPagination;
  }
}
