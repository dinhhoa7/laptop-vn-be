package hoavd.demo.laptopvn.admin.service;

import hoavd.demo.laptopvn.admin.model.request.AdminRequest;
import hoavd.demo.laptopvn.admin.model.request.AdminUpdateRequest;
import hoavd.demo.laptopvn.admin.model.request.UserRequest;
import hoavd.demo.laptopvn.admin.model.request.UserUpdateRequest;
import hoavd.demo.laptopvn.common.model.ResponseDataPagination;
import hoavd.demo.laptopvn.user.entity.Admin;
import hoavd.demo.laptopvn.user.entity.User;

public interface AdminUserService {
  Admin login(AdminRequest request) throws Exception;

  Admin createAdmin(AdminRequest request) throws Exception;

  User createUser(UserRequest request) throws Exception;

  Admin updateAdmin(AdminUpdateRequest request) throws Exception;

  User updateUser(UserUpdateRequest request) throws Exception;

  void deleteAdmin(long id) throws Exception;

  void  deleteUser(long id) throws Exception;

  ResponseDataPagination getPageListAdmin(int page, int size) throws Exception;

  ResponseDataPagination getPageListUser(int page, int size) throws Exception;
}
