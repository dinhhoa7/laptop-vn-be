package hoavd.demo.laptopvn.admin.controller;

import hoavd.demo.laptopvn.admin.config.security.JwtTokenProvider;
import hoavd.demo.laptopvn.admin.model.AdminRequest;
import hoavd.demo.laptopvn.admin.service.AdminUserService;
import hoavd.demo.laptopvn.common.constants.ResponseMessageConstants;
import hoavd.demo.laptopvn.common.enums.Enums;
import hoavd.demo.laptopvn.common.exception.BusinessException;
import hoavd.demo.laptopvn.common.model.ResponseData;
import hoavd.demo.laptopvn.common.utils.LogUtils;
import hoavd.demo.laptopvn.user.entity.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
  private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

  @Autowired
  private AdminUserService adminUserService;

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @PostMapping("/login")
  public ResponseData login(@RequestBody AdminRequest request){
    ResponseData responseData = new ResponseData();
    try {
      Admin admin = adminUserService.login(request);
      String jwt = jwtTokenProvider.generateToken(admin);
      Map<String, Object> authResponse = new HashMap<>();
      authResponse.put("access_token", jwt);
      responseData.setData(authResponse);
      responseData.setStatus(Enums.ResponseStatus.SUCCESS);
      responseData.setMessage(ResponseMessageConstants.LOGIN_SUCCESS);
    } catch (BusinessException be) {
      LOGGER.error(be.getMessage());
      responseData.setMessage(be.getMessage());
      responseData.setStatus(Enums.ResponseStatus.ERROR);
    } catch (Exception ex) {
      LOGGER.error(LogUtils.printLogStackTrace(ex));
      responseData.setMessage(ResponseMessageConstants.ERROR);
      responseData.setStatus(Enums.ResponseStatus.ERROR);
    }
    return responseData;
  }
}
