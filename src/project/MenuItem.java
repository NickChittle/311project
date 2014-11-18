package project;

public class MenuItem {
  private int id;
  private String name;
  private double price;
  private String description;
  private String category;

  public MenuItem(int id, String name, double price, String description, String category) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.description = description;
    this.category = category;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public String getDescription() {
    return description;
  }

  public String getCategory() {
    return category;
  }

  public String toString() {
    return name;
  }
}
