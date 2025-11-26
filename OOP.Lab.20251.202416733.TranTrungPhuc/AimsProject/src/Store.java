import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;
public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("The media \"" + media.getTitle() + "\" is already in the store.");
        } else {
            itemsInStore.add(media);
            System.out.println("The media \"" + media.getTitle() + "\" has been added to the store.");
        }
    }
    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("The media \"" + media.getTitle() + "\" has been removed from the store.");
        } else {
            System.out.println("The media was not found in the store.");
        }
    }
    public void removeMedia(int index) {
        if (index >= 0 && index < itemsInStore.size()) {
            Media removed = itemsInStore.remove(index);
            System.out.println("The media \"" + removed.getTitle() + "\" has been removed from the store.");
        } else {
            System.out.println("Invalid index.");
        }
    }
    public void printStore() {
        System.out.println("\n***********************STORE***********************");
        System.out.println("Available Items:");
        int index = 1;
        for (Media media : itemsInStore) {
            System.out.println((index) + ". " + media.toString());
            index++;
        }
        System.out.println("Total items: " + itemsInStore.size());
        System.out.println("***************************************************");
    }
    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
    public Media getMedia(int index) {
        if (index >= 0 && index < itemsInStore.size()) {
            return itemsInStore.get(index);
        }
        return null;
    }
    public boolean isEmpty() {
        return itemsInStore.isEmpty();
    }
    public int getNumberOfItems() {
        return itemsInStore.size();
    }
}