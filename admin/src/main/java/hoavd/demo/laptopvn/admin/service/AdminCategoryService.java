package hoavd.demo.laptopvn.admin.service;

import hoavd.demo.laptopvn.admin.model.request.CategoryRequest;
import hoavd.demo.laptopvn.admin.model.request.CategoryUpdateRequest;
import hoavd.demo.laptopvn.common.model.ResponseDataPagination;
import hoavd.demo.laptopvn.service.entity.Category;

public interface AdminCategoryService {
  Category createCategory(CategoryRequest request) throws Exception;

  Category updateCategory(CategoryUpdateRequest request) throws Exception;

  void deleteCategory(long id) throws Exception;

  ResponseDataPagination getPageListCategory(int page, int size) throws Exception;
}
