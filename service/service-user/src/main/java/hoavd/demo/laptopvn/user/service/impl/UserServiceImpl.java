package hoavd.demo.laptopvn.user.service.impl;

import hoavd.demo.laptopvn.user.entity.User;
import hoavd.demo.laptopvn.user.repository.UserRepository;
import hoavd.demo.laptopvn.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public Page<User> getPageListUser(Pageable pageable) {
    return userRepository.getPageListUser(pageable);
  }

  @Override
  public User getUserById(long id) {
    return userRepository.findById(id);
  }

  @Override
  public User getByEmail(String email) {
    return userRepository.getByEmail(email);
  }

  @Override
  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  public void delete(long id) {
    userRepository.deleteById(id);
  }
}
