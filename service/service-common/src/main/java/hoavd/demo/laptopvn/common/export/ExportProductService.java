package hoavd.demo.laptopvn.common.export;

import hoavd.demo.laptopvn.common.model.response.ExportProductResponse;
import hoavd.demo.laptopvn.common.utils.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;

@Service
public class ExportProductService {
  public ExportExcelToListProduct exportExcelToListProduct() {
    return new ExportExcelToListProduct();
  }

  public class ExportExcelToListProduct extends ExcelUtil<ExportProductResponse> {

    @Override
    protected void fillData(Sheet sheet, List<ExportProductResponse> dataList) throws ParseException {
      CellStyle normalStyle = getNormalStyle();
      CellStyle numberStyle = getCellNumberStyle();
      DecimalFormat decimalFormat = new DecimalFormat("#,###");
      int rowNum = getStartDataRow();
      int no = 0;
      for (ExportProductResponse productResponse : dataList){
        Row row = sheet.createRow(rowNum);

        //number
        Cell cell_0 = row.createCell(0, CellType.NUMERIC);
        cell_0.setCellStyle(numberStyle);
        cell_0.setCellValue(++no);

        //name
        Cell cell_1 = row.createCell(1, CellType.STRING);
        cell_1.setCellStyle(normalStyle);
        cell_1.setCellValue(productResponse.getName());
        sheet.setDefaultColumnWidth(20);

        //code
        Cell cell_2 = row.createCell(2, CellType.STRING);
        cell_2.setCellStyle(normalStyle);
        cell_2.setCellValue(productResponse.getCode());
        sheet.setDefaultColumnWidth(20);

        //category
        Cell cell_3 = row.createCell(3, CellType.STRING);
        cell_3.setCellStyle(normalStyle);
        cell_3.setCellValue(productResponse.getCategoryName());
        sheet.setDefaultColumnWidth(20);

        //description
        Cell cell_4 = row.createCell(4, CellType.STRING);
        cell_4.setCellStyle(normalStyle);
        cell_4.setCellValue(productResponse.getDescription());
        sheet.setDefaultColumnWidth(20);

        //dom
        Cell cell_5 = row.createCell(5, CellType.STRING);
        cell_5.setCellStyle(normalStyle);
        cell_5.setCellValue(productResponse.getDateOfManufacture());
        sheet.setDefaultColumnWidth(20);

        //discount
        Cell cell_6 = row.createCell(6, CellType.STRING);
        cell_6.setCellStyle(normalStyle);
        cell_6.setCellValue(productResponse.getDiscount());
        sheet.setDefaultColumnWidth(20);

        //created
        Cell cell_7 = row.createCell(7, CellType.STRING);
        cell_7.setCellStyle(normalStyle);
        cell_7.setCellValue(productResponse.getCreatedDate());
        sheet.setDefaultColumnWidth(20);

        //updated
        Cell cell_8 = row.createCell(8, CellType.STRING);
        cell_8.setCellStyle(normalStyle);
        cell_8.setCellValue(productResponse.getUpdatedDate());
        sheet.setDefaultColumnWidth(20);

        rowNum++;
      }
    }

    @Override
    protected void fillData(Sheet sheet, List<ExportProductResponse> dataList, Object object) {

    }

    @Override
    protected void fillData(Sheet sheet, Object object) {

    }
  }
}
