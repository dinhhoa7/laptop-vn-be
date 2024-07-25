package hoavd.demo.laptopvn.service.entity;

import hoavd.demo.laptopvn.common.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "product_detail")
public class ProductDetail extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "product_id")
  private long productId;

  @Column(name = "date_of_manufacture")
  private long dateOfManufacture;

  @Column(name = "discount")
  private int discount;

  @Column(name = "is_deleted")
  private boolean isDeleted;

  public ProductDetail() {
  }

  public ProductDetail(long id, long productId, long dateOfManufacture, int discount, boolean isDeleted) {
    this.id = id;
    this.productId = productId;
    this.dateOfManufacture = dateOfManufacture;
    this.discount = discount;
    this.isDeleted = isDeleted;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }

  public long getDateOfManufacture() {
    return dateOfManufacture;
  }

  public void setDateOfManufacture(long dateOfManufacture) {
    this.dateOfManufacture = dateOfManufacture;
  }

  public int getDiscount() {
    return discount;
  }

  public void setDiscount(int discount) {
    this.discount = discount;
  }

  public boolean isDeleted() {
    return isDeleted;
  }

  public void setDeleted(boolean deleted) {
    isDeleted = deleted;
  }
}
