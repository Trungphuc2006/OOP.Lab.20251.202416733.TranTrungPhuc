import java.util.ArrayList;
import java.util.Collections;
import hust.soict.dsai.aims.media.Media;
public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    public static final int MAX_NUMBERS_ORDERED = 20;
    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
    public void addMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            System.out.println("The item is already in the cart.");
        } else {
            if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
                itemsOrdered.add(media);
                System.out.println("Added: " + media.getTitle());
            } else {
                System.out.println("The cart is full. Cannot add more items.");
            }
        }
    }
    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed: " + media.getTitle());
        } else {
            System.out.println("Item not found in the cart.");
        }
    }
    public void removeMedia(int index) {
        if (index >= 0 && index < itemsOrdered.size()) {
            Media removed = itemsOrdered.remove(index);
            System.out.println("Removed: " + removed.getTitle());
        } else {
            System.out.println("Invalid index.");
        }
    }
    public float totalCost() {
        float total = 0;
        for (Media m : itemsOrdered) {
            total += m.getCost();
        }
        return total;
    }
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int index = 1;
        for (Media m : itemsOrdered) {
            System.out.println(index + ". " + m.toString());
            index++;
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }
    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by title (alphabetical), then by cost (higher first)");
    }
    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by cost (decreasing), then by title (alphabetical)");
    }
    public void searchById(int id) {
        boolean found = false;
        for (Media m : itemsOrdered) {
            if (m.getId() == id) {
                System.out.println("Found: " + m.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No media found with ID " + id);
        }
    }
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media m : itemsOrdered) {
            if (m.isMatch(title)) {
                System.out.println("Found: " + m.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with title containing \"" + title + "\"");
        }
    }
    public void clear() {
        itemsOrdered.clear();
        System.out.println("Cart cleared. Order placed successfully!");
    }
    public int getQtyOrdered() {
        return itemsOrdered.size();
    }
    public Media getMedia(int index) {
        if (index >= 0 && index < itemsOrdered.size()) {
            return itemsOrdered.get(index);
        }
        return null;
    }
}