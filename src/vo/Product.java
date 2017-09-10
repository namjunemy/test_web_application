package vo;

public class Product {
  private int no;
  private String name;
  private String size;
  private int price;
  private int quantity;
  private String description;

  public Product() {
  }

  public Product setNo(int no) {
    this.no = no;
    return this;
  }

  public Product setName(String name) {
    this.name = name;
    return this;
  }

  public Product setSize(String size) {
    this.size = size;
    return this;
  }

  public Product setPrice(int price) {
    this.price = price;
    return this;
  }

  public Product setQuantity(int quantity) {
    this.quantity = quantity;
    return this;
  }

  public Product setDescription(String description) {
    this.description = description;
    return this;
  }

  public int getNo() {
    return no;
  }

  public String getName() {
    return name;
  }

  public String getSize() {
    return size;
  }

  public int getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public String getDescription() {
    return description;
  }
}
