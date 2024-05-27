package hoavd.demo.laptopvn.user.service;

import hoavd.demo.laptopvn.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
  Page<User> getPageListUser(Pageable pageable);

  User getUserById(long id);

  User getByEmail(String email);

  User save(User user);

  void delete(long id);
}
