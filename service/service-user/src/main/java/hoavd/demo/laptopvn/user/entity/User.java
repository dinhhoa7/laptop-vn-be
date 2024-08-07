package hoavd.demo.laptopvn.user.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import hoavd.demo.laptopvn.common.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;

  @Column(name = "full_name")
  private String fullName;

  @Column(name = "dob")
  private long dob;

  @Column(name = "address")
  private String address;

  @Column(name = "phoneNumber")
  private String phoneNumber;

  public User() {
  }

  public User(long id, String email, String password, String fullName, long dob, String address, String phoneNumber) {
    this.id = id;
    this.email = email;
    this.password = password;
    this.fullName = fullName;
    this.dob = dob;
    this.address = address;
    this.phoneNumber = phoneNumber;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public long getDob() {
    return dob;
  }

  public void setDob(long dob) {
    this.dob = dob;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}
