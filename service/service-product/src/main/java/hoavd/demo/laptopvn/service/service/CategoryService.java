package hoavd.demo.laptopvn.service.service;

import hoavd.demo.laptopvn.service.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
  Page<Category> getPageListCategory(Pageable pageable);

  Category getCategoryById(long id);

  Category getByName(String name);


  Category save(Category category);

  void delete(long id);
}
