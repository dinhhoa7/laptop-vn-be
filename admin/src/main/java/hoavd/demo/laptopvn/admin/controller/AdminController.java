package hoavd.demo.laptopvn.admin.controller;

import hoavd.demo.laptopvn.admin.model.request.AdminRequest;
import hoavd.demo.laptopvn.admin.model.request.AdminUpdateRequest;
import hoavd.demo.laptopvn.admin.model.request.UserRequest;
import hoavd.demo.laptopvn.admin.model.request.UserUpdateRequest;
import hoavd.demo.laptopvn.admin.service.AdminUserService;
import hoavd.demo.laptopvn.common.constants.PagingConstants;
import hoavd.demo.laptopvn.common.constants.ResponseMessageConstants;
import hoavd.demo.laptopvn.common.enums.Enums;
import hoavd.demo.laptopvn.common.exception.BusinessException;
import hoavd.demo.laptopvn.common.model.ResponseData;
import hoavd.demo.laptopvn.common.utils.LogUtils;
import hoavd.demo.laptopvn.user.entity.Admin;
import hoavd.demo.laptopvn.user.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
  private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

  @Autowired
  private AdminUserService adminUserService;

  @GetMapping("/get-list-admin")
  public ResponseData getListAdmin(@RequestParam(value = "page", required = false, defaultValue = PagingConstants.PAGING_STRING_PAGE_DEFAULT) int page,
    @RequestParam(value = "size", required = false, defaultValue = PagingConstants.PAGING_STRING_SIZE_DEFAULT) int size) {
    ResponseData responseData = new ResponseData();
    try {
      return adminUserService.getPageListAdmin(page, size);
    } catch (BusinessException be) {
      logger.error(LogUtils.printLogStackTrace(be));
      responseData.setStatus(Enums.ResponseStatus.ERROR);
      responseData.setMessage(be.getMessage());
    } catch (Exception ex) {
      logger.error(LogUtils.printLogStackTrace(ex));
      responseData.setStatus(Enums.ResponseStatus.ERROR.getStatus());
      responseData.setMessage(ResponseMessageConstants.ERR_SYSTEM);
    }
    return responseData;
  }

  @GetMapping("/get-list-user")
  public ResponseData getListUser(@RequestParam(value = "page", required = false, defaultValue = PagingConstants.PAGING_STRING_PAGE_DEFAULT) int page,
    @RequestParam(value = "size", required = false, defaultValue = PagingConstants.PAGING_STRING_SIZE_DEFAULT) int size) {
    ResponseData responseData = new ResponseData();
    try {
      return adminUserService.getPageListUser(page, size);
    } catch (BusinessException be) {
      logger.error(LogUtils.printLogStackTrace(be));
      responseData.setStatus(Enums.ResponseStatus.ERROR);
      responseData.setMessage(be.getMessage());
    } catch (Exception ex) {
      logger.error(LogUtils.printLogStackTrace(ex));
      responseData.setStatus(Enums.ResponseStatus.ERROR.getStatus());
      responseData.setMessage(ResponseMessageConstants.ERR_SYSTEM);
    }
    return responseData;
  }

  @PostMapping("/create-admin")
  public ResponseData createAdmin(@RequestBody AdminRequest request){
    ResponseData responseData = new ResponseData();
    try {
      Admin admin = adminUserService.createAdmin(request);
      responseData.setData(admin);
      responseData.setStatus(Enums.ResponseStatus.SUCCESS);
      responseData.setMessage(ResponseMessageConstants.CREATE_ACC_ADMIN_SUCCESS);
    } catch (BusinessException be) {
      logger.error(be.getMessage());
      responseData.setMessage(be.getMessage());
      responseData.setStatus(Enums.ResponseStatus.ERROR);
    } catch (Exception ex) {
      logger.error(LogUtils.printLogStackTrace(ex));
      responseData.setMessage(ResponseMessageConstants.ERROR);
      responseData.setStatus(Enums.ResponseStatus.ERROR);
    }
    return responseData;
  }

  @PostMapping("/create-user")
  public ResponseData createUser(@RequestBody UserRequest request){
    ResponseData responseData = new ResponseData();
    try {
      User user = adminUserService.createUser(request);
      responseData.setData(user);
      responseData.setStatus(Enums.ResponseStatus.SUCCESS);
      responseData.setMessage(ResponseMessageConstants.CREATE_ACC_USER_SUCCESS);
    } catch (BusinessException be) {
      logger.error(be.getMessage());
      responseData.setMessage(be.getMessage());
      responseData.setStatus(Enums.ResponseStatus.ERROR);
    } catch (Exception ex) {
      logger.error(LogUtils.printLogStackTrace(ex));
      responseData.setMessage(ResponseMessageConstants.ERROR);
      responseData.setStatus(Enums.ResponseStatus.ERROR);
    }
    return responseData;
  }

  @PutMapping("/update-admin")
  public ResponseData updateAdmin(@RequestBody AdminUpdateRequest request){
    ResponseData responseData = new ResponseData();
    try {
      Admin admin = adminUserService.updateAdmin(request);
      responseData.setData(admin);
      responseData.setStatus(Enums.ResponseStatus.SUCCESS);
      responseData.setMessage(ResponseMessageConstants.UPDATE_ACC_ADMIN_SUCCESS);
    } catch (BusinessException be) {
      logger.error(be.getMessage());
      responseData.setMessage(be.getMessage());
      responseData.setStatus(Enums.ResponseStatus.ERROR);
    } catch (Exception ex) {
      logger.error(LogUtils.printLogStackTrace(ex));
      responseData.setMessage(ResponseMessageConstants.ERROR);
      responseData.setStatus(Enums.ResponseStatus.ERROR);
    }
    return responseData;
  }

  @PutMapping("/update-user")
  public ResponseData updateUser(@RequestBody UserUpdateRequest request){
    ResponseData responseData = new ResponseData();
    try {
      User user = adminUserService.updateUser(request);
      responseData.setData(user);
      responseData.setStatus(Enums.ResponseStatus.SUCCESS);
      responseData.setMessage(ResponseMessageConstants.UPDATE_ACC_USER_SUCCESS);
    } catch (BusinessException be) {
      logger.error(be.getMessage());
      responseData.setMessage(be.getMessage());
      responseData.setStatus(Enums.ResponseStatus.ERROR);
    } catch (Exception ex) {
      logger.error(LogUtils.printLogStackTrace(ex));
      responseData.setMessage(ResponseMessageConstants.ERROR);
      responseData.setStatus(Enums.ResponseStatus.ERROR);
    }
    return responseData;
  }

  @DeleteMapping("/delete-admin/{id}")
  public ResponseData deleteAdmin(@PathVariable long id){
    ResponseData responseData = new ResponseData();
    try {
      adminUserService.deleteAdmin(id);
      responseData.setStatus(Enums.ResponseStatus.SUCCESS);
      responseData.setMessage(ResponseMessageConstants.DELETE_ACC_ADMIN_SUCCESS);
    } catch (BusinessException be) {
      logger.error(be.getMessage());
      responseData.setMessage(be.getMessage());
      responseData.setStatus(Enums.ResponseStatus.ERROR);
    } catch (Exception ex) {
      logger.error(LogUtils.printLogStackTrace(ex));
      responseData.setMessage(ResponseMessageConstants.ERROR);
      responseData.setStatus(Enums.ResponseStatus.ERROR);
    }
    return responseData;
  }

  @DeleteMapping("/delete-user/{id}")
  public ResponseData deleteUser(@PathVariable long id){
    ResponseData responseData = new ResponseData();
    try {
      adminUserService.deleteUser(id);
      responseData.setStatus(Enums.ResponseStatus.SUCCESS);
      responseData.setMessage(ResponseMessageConstants.DELETE_ACC_USER_SUCCESS);
    } catch (BusinessException be) {
      logger.error(be.getMessage());
      responseData.setMessage(be.getMessage());
      responseData.setStatus(Enums.ResponseStatus.ERROR);
    } catch (Exception ex) {
      logger.error(LogUtils.printLogStackTrace(ex));
      responseData.setMessage(ResponseMessageConstants.ERROR);
      responseData.setStatus(Enums.ResponseStatus.ERROR);
    }
    return responseData;
  }
}
