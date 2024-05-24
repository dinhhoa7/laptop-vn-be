package hoavd.demo.laptopvn.common.model;

public class UserTokenModel {
  private String email;
  private long userId;
  private String provider;
  private String activeMode;

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getProvider() {
    return provider;
  }

  public void setProvider(String provider) {
    this.provider = provider;
  }

  public String getActiveMode() {
    return activeMode;
  }

  public void setActiveMode(String activeMode) {
    this.activeMode = activeMode;
  }
}
