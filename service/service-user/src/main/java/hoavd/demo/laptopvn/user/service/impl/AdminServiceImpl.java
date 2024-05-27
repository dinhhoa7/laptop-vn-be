package hoavd.demo.laptopvn.user.service.impl;

import hoavd.demo.laptopvn.user.entity.Admin;
import hoavd.demo.laptopvn.user.repository.AdminRepository;
import hoavd.demo.laptopvn.user.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
  @Autowired
  private AdminRepository adminRepository;

  @Override
  public Page<Admin> getPageListAdmin(Pageable pageable) {
    return adminRepository.getPageListAdmin(pageable);
  }

  @Override
  public Admin getAdminById(long id) {
    return adminRepository.findById(id);
  }

  @Override
  public Admin getByEmail(String email) {
    return adminRepository.getByEmail(email);
  }

  @Override
  public Admin getByIdAndEmail(long id, String email) {
    return adminRepository.getByIdAndEmail(id, email);
  }

  @Override
  public Admin save(Admin admin) {
    return adminRepository.save(admin);
  }

  @Override
  public void delete(long id) {
    adminRepository.deleteById(id);
  }
}
