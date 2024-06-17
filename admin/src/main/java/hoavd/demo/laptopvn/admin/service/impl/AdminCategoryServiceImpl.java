package hoavd.demo.laptopvn.admin.service.impl;

import hoavd.demo.laptopvn.admin.model.request.CategoryRequest;
import hoavd.demo.laptopvn.admin.model.request.CategoryUpdateRequest;
import hoavd.demo.laptopvn.admin.service.AdminCategoryService;
import hoavd.demo.laptopvn.common.constants.ResponseMessageConstants;
import hoavd.demo.laptopvn.common.enums.Enums;
import hoavd.demo.laptopvn.common.exception.BusinessException;
import hoavd.demo.laptopvn.common.model.Pagination;
import hoavd.demo.laptopvn.common.model.ResponseDataPagination;
import hoavd.demo.laptopvn.service.entity.Category;
import hoavd.demo.laptopvn.service.service.CategoryService;
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
public class AdminCategoryServiceImpl implements AdminCategoryService {
  private static final Logger logger = LoggerFactory.getLogger(AdminCategoryServiceImpl.class);

  @Autowired
  private CategoryService categoryService;

  @Override
  public Category createCategory(CategoryRequest request) throws Exception {
    Category categoryName = categoryService.getByName(request.getName());
    if (categoryName != null)
      throw new BusinessException(ResponseMessageConstants.CATEGORY_NAME_ALREADY_EXIST);
    Category category = new Category();
    category.setName(request.getName());
    category.setDescription(request.getDescription());
    category.setDeleted(false);
    category.setStatus(true);
    category.create();
    return categoryService.save(category);
  }

  @Override
  public Category updateCategory(CategoryUpdateRequest request) throws Exception {
    logger.info(request.toString());
    Category category = categoryService.getCategoryById(request.getId());
    if (category == null)
      throw new BusinessException(ResponseMessageConstants.CATEGORY_DOES_NOT_EXIST);
    if (Strings.isBlank(request.getName())){
      throw new BusinessException(ResponseMessageConstants.INFORMATION_INVALID);
    }
    category.setName(request.getName());
    category.setDescription(request.getDescription());
    category.setStatus(request.isStatus());
    category.update();
    return categoryService.save(category);
  }

  @Override
  public void deleteCategory(long id) throws Exception {
    Category category = categoryService.getCategoryById(id);
    if (category == null)
      throw new BusinessException(ResponseMessageConstants.CATEGORY_DOES_NOT_EXIST);
    categoryService.delete(id);
  }

  @Override
  public ResponseDataPagination getPageListCategory(int page, int size) throws Exception {
    ResponseDataPagination responseDataPagination = new ResponseDataPagination();
    int pageReq = page >= 1 ? page - 1 : page;
    Pageable pageable = PageRequest.of(pageReq, size);
    Page<Category> categoryPage = categoryService.getPageListCategory(pageable);
    List<Category> categoryList = categoryPage.getContent();
    responseDataPagination.setData(categoryList);
    Pagination pagination = new Pagination();
    pagination.setCurrentPage(page);
    pagination.setPageSize(size);
    pagination.setTotalPage(categoryPage.getTotalPages());
    pagination.setTotalRecords(categoryPage.getTotalElements());
    responseDataPagination.setStatus(Enums.ResponseStatus.SUCCESS.getStatus());
    responseDataPagination.setPagination(pagination);
    return responseDataPagination;
  }
}
