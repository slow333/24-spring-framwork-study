package spfw;

public class Book {
  private int price;
  private String title;

  public Book(){}

  public Book(int price, String title) {
    this.price = price;
    this.title = title;
  }

  public int getPrice() {
    return price;
  }

  public String getTitle() {
    return title;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
