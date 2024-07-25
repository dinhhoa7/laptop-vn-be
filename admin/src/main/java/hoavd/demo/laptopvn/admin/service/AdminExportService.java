package hoavd.demo.laptopvn.admin.service;

import org.springframework.core.io.ByteArrayResource;

public interface AdminExportService {
  ByteArrayResource exportResourceProduct(String name) throws Exception;
}
