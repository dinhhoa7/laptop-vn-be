package hoavd.demo.laptopvn.admin.service.impl;

import hoavd.demo.laptopvn.admin.service.AdminExportService;
import hoavd.demo.laptopvn.admin.service.AdminProductService;
import hoavd.demo.laptopvn.common.export.ExportProductService;
import hoavd.demo.laptopvn.common.model.response.ExportProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AdminExportServiceImpl implements AdminExportService {
  @Autowired
  private AdminProductService adminProductService;

  @Autowired
  private ExportProductService exportProductService;

  @Override
  public ByteArrayResource exportResourceProduct(String name)
    throws Exception {
    List<String> headers = Arrays.asList("NO.", "NAME", "CODE", "CATEGORY", "DESCRIPTION", "DOM", "DISCOUNT", "CREATED DATE", "UPDATED DATE");
    List<ExportProductResponse> productResponseList = adminProductService.getListProduct(name);
    ExportProductService.ExportExcelToListProduct exporter = exportProductService.exportExcelToListProduct();
    exporter.createSheet("PRODUCT", headers.toArray(new String[0]), productResponseList);
    return new ByteArrayResource(exporter.export());
  }
}
