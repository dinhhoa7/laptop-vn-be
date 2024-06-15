package hoavd.demo.laptopvn.admin.service;

import hoavd.demo.laptopvn.admin.model.*;
import hoavd.demo.laptopvn.common.model.ResponseDataPagination;
import hoavd.demo.laptopvn.service.entity.Category;
import hoavd.demo.laptopvn.user.entity.Admin;
import hoavd.demo.laptopvn.user.entity.User;

public interface AdminCategoryService {
  Category createCategory(CategoryRequest request) throws Exception;

  Category updateCategory(CategoryUpdateRequest request) throws Exception;

  void deleteCategory(long id) throws Exception;

  ResponseDataPagination getPageListCategory(int page, int size) throws Exception;
}
