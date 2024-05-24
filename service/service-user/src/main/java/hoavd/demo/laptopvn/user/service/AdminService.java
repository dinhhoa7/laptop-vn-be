package hoavd.demo.laptopvn.user.service;

import hoavd.demo.laptopvn.user.entity.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminService {
  Page<Admin> getPageListAdmin(Pageable pageable);

  Admin getByEmail(String email);

  Admin getByIdAndEmail(long id, String email);

  Admin save(Admin admin);
}
