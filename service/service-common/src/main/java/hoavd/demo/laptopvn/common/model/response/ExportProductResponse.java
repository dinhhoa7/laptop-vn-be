package hoavd.demo.laptopvn.common.model.response;

public class ExportProductResponse {
  private long id;

  private String code;

  private long categoryId;

  private String categoryName;

  private String name;

  private String description;

  private String dateOfManufacture;

  private String discount;

  private String createdDate;

  private String updatedDate;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(long categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDateOfManufacture() {
    return dateOfManufacture;
  }

  public void setDateOfManufacture(String dateOfManufacture) {
    this.dateOfManufacture = dateOfManufacture;
  }

  public String getDiscount() {
    return discount;
  }

  public void setDiscount(String discount) {
    this.discount = discount;
  }

  public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  public String getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(String updatedDate) {
    this.updatedDate = updatedDate;
  }
}
