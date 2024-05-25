package hoavd.demo.laptopvn.admin.service.impl;

import hoavd.demo.laptopvn.admin.model.AdminRequest;
import hoavd.demo.laptopvn.admin.model.AdminUpdateRequest;
import hoavd.demo.laptopvn.admin.model.UserRequest;
import hoavd.demo.laptopvn.admin.model.UserUpdateRequest;
import hoavd.demo.laptopvn.admin.service.AdminUserService;
import hoavd.demo.laptopvn.common.constants.ResponseMessageConstants;
import hoavd.demo.laptopvn.common.enums.Enums;
import hoavd.demo.laptopvn.common.exception.BusinessException;
import hoavd.demo.laptopvn.common.model.Pagination;
import hoavd.demo.laptopvn.common.model.ResponseDataPagination;
import hoavd.demo.laptopvn.user.entity.Admin;
import hoavd.demo.laptopvn.user.entity.User;
import hoavd.demo.laptopvn.user.service.AdminService;
import hoavd.demo.laptopvn.user.service.UserService;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {
  private static final Logger logger = LoggerFactory.getLogger(AdminUserServiceImpl.class);

  @Autowired
  private AdminService adminService;

  @Autowired
  private UserService userService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public Admin login(AdminRequest adminLoginRequest) throws BusinessException {
    Admin admin = adminService.getByEmail(adminLoginRequest.getEmail().toLowerCase());
    if (admin == null)
      throw new BusinessException(ResponseMessageConstants.ADMIN_DOES_NOT_EXIST);
    if (passwordEncoder.matches(adminLoginRequest.getPassword(), admin.getPassword()))
      return admin;
    throw new BusinessException(ResponseMessageConstants.ERROR);
  }

  @Override
  public Admin createAdmin(AdminRequest request) throws Exception {
    Admin adminEmail = adminService.getByEmail(request.getEmail().toLowerCase());
    if (adminEmail != null)
      throw new BusinessException(ResponseMessageConstants.EMAIL_ALREADY_EXIST);
    Admin admin = new Admin();
    admin.setEmail(request.getEmail().toLowerCase());
    admin.setPassword(passwordEncoder.encode(request.getPassword()));
    admin.create();
    return adminService.save(admin);
  }

  @Override
  public User createUser(UserRequest request) throws Exception {
    User userEmail = userService.getByEmail(request.getEmail().toLowerCase());
    if (userEmail != null)
      throw new BusinessException(ResponseMessageConstants.EMAIL_ALREADY_EXIST);
    User user = new User();
    user.setEmail(request.getEmail().toLowerCase());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    user.setFullName(request.getFullName());
    user.setAddress(request.getAddress());
    user.setPhoneNumber(request.getPhoneNumber());
    user.create();
    return userService.save(user);
  }

  @Override
  public Admin updateAdmin(AdminUpdateRequest request) throws Exception {
    logger.info(request.toString());
    Admin admin = adminService.getAdminById(request.getId());
    if (admin == null)
      throw new BusinessException(ResponseMessageConstants.ADMIN_DOES_NOT_EXIST);
    if (Strings.isBlank(request.getEmail()) || Strings.isBlank(request.getPassword())){
      throw new BusinessException(ResponseMessageConstants.INFORMATION_INVALID);
    }
    admin.setEmail(request.getEmail());
    admin.setPassword(passwordEncoder.encode(request.getPassword()));
    admin.update();
    return adminService.save(admin);
  }

  @Override
  public User updateUser(UserUpdateRequest request) throws Exception {
    logger.info(request.toString());
    User user = userService.getUserById(request.getId());
    if (user == null)
      throw new BusinessException(ResponseMessageConstants.ADMIN_DOES_NOT_EXIST);
    if (Strings.isBlank(request.getEmail()) || Strings.isBlank(request.getPassword()) || Strings.isBlank(request.getFullName()) ||
      Strings.isBlank(request.getAddress()) || Strings.isBlank(request.getPhoneNumber())) {
      throw new BusinessException(ResponseMessageConstants.INFORMATION_INVALID);
    }
    user.setEmail(request.getEmail());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    user.setFullName(request.getFullName());
    user.setAddress(request.getAddress());
    user.setPhoneNumber(request.getPhoneNumber());
    user.update();
    return userService.save(user);
  }

  @Override
  public ResponseDataPagination getPageListAdmin(int page, int size) throws Exception {
    ResponseDataPagination responseDataPagination = new ResponseDataPagination();
    int pageReq = page >= 1 ? page - 1 : page;
    Pageable pageable = PageRequest.of(pageReq, size);
    Page<Admin> adminPage = adminService.getPageListAdmin(pageable);
    List<Admin> adminList = adminPage.getContent();
    responseDataPagination.setData(adminList);
    Pagination pagination = new Pagination();
    pagination.setCurrentPage(page);
    pagination.setPageSize(size);
    pagination.setTotalPage(adminPage.getTotalPages());
    pagination.setTotalRecords(adminPage.getTotalElements());
    responseDataPagination.setStatus(Enums.ResponseStatus.SUCCESS.getStatus());
    responseDataPagination.setPagination(pagination);
    return responseDataPagination;
  }

  @Override
  public ResponseDataPagination getPageListUser(int page, int size) throws Exception {
    ResponseDataPagination responseDataPagination = new ResponseDataPagination();
    int pageReq = page >= 1 ? page - 1 : page;
    Pageable pageable = PageRequest.of(pageReq, size);
    Page<User> userPage = userService.getPageListUser(pageable);
    List<User> userList = userPage.getContent();
    responseDataPagination.setData(userList);
    Pagination pagination = new Pagination();
    pagination.setCurrentPage(page);
    pagination.setPageSize(size);
    pagination.setTotalPage(userPage.getTotalPages());
    pagination.setTotalRecords(userPage.getTotalElements());
    responseDataPagination.setStatus(Enums.ResponseStatus.SUCCESS.getStatus());
    responseDataPagination.setPagination(pagination);
    return responseDataPagination;
  }
}
