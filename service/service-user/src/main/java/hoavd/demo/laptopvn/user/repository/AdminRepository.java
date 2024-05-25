package hoavd.demo.laptopvn.user.repository;

import hoavd.demo.laptopvn.user.entity.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
  @Query(value = "select * from admin a order by a.created_at desc", nativeQuery = true)
  Page<Admin> getPageListAdmin(Pageable pageable);

  Admin findById(long id);

  Admin getByEmail(String email);

  Admin getByIdAndEmail(long id, String email);
}
