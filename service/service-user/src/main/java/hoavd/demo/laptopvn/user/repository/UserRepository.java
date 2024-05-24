package hoavd.demo.laptopvn.user.repository;

import hoavd.demo.laptopvn.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
  @Query(value = "select * from users u order by u.created_at desc", nativeQuery = true)
  Page<User> getPageListUser(Pageable pageable);

  User getByEmail(String email);
}
