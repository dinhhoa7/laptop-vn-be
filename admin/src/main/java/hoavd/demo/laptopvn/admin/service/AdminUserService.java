package hoavd.demo.laptopvn.admin.service;

import hoavd.demo.laptopvn.admin.model.AdminRequest;
import hoavd.demo.laptopvn.admin.model.UserRequest;
import hoavd.demo.laptopvn.common.model.ResponseDataPagination;
import hoavd.demo.laptopvn.user.entity.Admin;
import hoavd.demo.laptopvn.user.entity.User;

public interface AdminUserService {
  Admin login(AdminRequest request) throws Exception;

  Admin createAdmin(AdminRequest request) throws Exception;

  User createUser(UserRequest request) throws Exception;

  ResponseDataPagination getPageListAdmin(int page, int size) throws Exception;

  ResponseDataPagination getPageListUser(int page, int size) throws Exception;
}
