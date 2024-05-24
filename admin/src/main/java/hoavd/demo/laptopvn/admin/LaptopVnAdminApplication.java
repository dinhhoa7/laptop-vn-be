package hoavd.demo.laptopvn.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "hoavd.demo.laptopvn.*" })
@EnableJpaRepositories(basePackages = { "hoavd.demo.laptopvn.*.repository" })
@ComponentScan(basePackages = { "hoavd.demo.laptopvn.*" })
@EntityScan("hoavd.demo.laptopvn.*")
public class LaptopVnAdminApplication {
  public static void main(String[] args) {
    SpringApplication.run(LaptopVnAdminApplication.class, args);
  }
}