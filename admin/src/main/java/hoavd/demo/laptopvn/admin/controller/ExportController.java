package hoavd.demo.laptopvn.admin.controller;

import hoavd.demo.laptopvn.admin.service.AdminExportService;
import hoavd.demo.laptopvn.common.exception.BusinessException;
import hoavd.demo.laptopvn.common.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/export")
public class ExportController {
  private static final Logger logger = LoggerFactory.getLogger(ExportController.class);

  @Autowired
  private AdminExportService adminExportService;

  @GetMapping(value = "/export-to-product")
  public ResponseEntity<Resource> exportProduct(
    @RequestParam(value = "name", required = false, defaultValue = "") String name){
    try {
      ByteArrayResource resource = adminExportService.exportResourceProduct(name);
      return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=export-product.xlsx")
        .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
        .body(resource);
    } catch (BusinessException e) {
      String msg = LogUtils.printLogStackTrace(e);
      logger.error(msg);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    } catch (Exception e) {
      String msg = LogUtils.printLogStackTrace(e);
      logger.error(msg);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
