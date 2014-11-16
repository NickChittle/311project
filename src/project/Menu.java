package project;

import project.database.DatabaseManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
  private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();;
  private Map<String, Category> categorizedMenuItems = new HashMap<String, Category>();

  public Menu() {
    readMenuItems();
    categorizeMenuItem();
  }

  private void readMenuItems() {
    DatabaseManager db = new DatabaseManager();
    menuItems.addAll(db.getItems());
  }

  private void categorizeMenuItem() {
    for (MenuItem item : menuItems) {
      if (!categorizedMenuItems.containsKey(item.getCategory())) {
        categorizedMenuItems.put(item.getCategory(), new Category(item.getCategory()));
      }
      categorizedMenuItems.get(item.getCategory()).addMenuItem(item);
    }
  }

  public List<MenuItem> getMenuItems() {
    return menuItems;
  }

  public Collection<String> getCategoriesStringList() {
    return categorizedMenuItems.keySet();
  }

  public Collection<Category> getCategoriesList() {
    return categorizedMenuItems.values();
  }
}
