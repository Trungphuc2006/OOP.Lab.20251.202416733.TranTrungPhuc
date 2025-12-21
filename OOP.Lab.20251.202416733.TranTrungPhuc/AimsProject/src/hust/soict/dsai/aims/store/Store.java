package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import java.util.List;
import hust.soict.dsai.aims.media.Media;
public class Store {
    private List<Media> itemsInStore = new ArrayList<>();
    public void addMedia(Media media) {
        if (media == null) {
            System.out.println("Cannot add null media to store.");
            return;
        } 
        if (itemsInStore.contains(media)) {
            System.out.println("Media \"" + media.getTitle() + "\" is already in the store.");
        } else {
            itemsInStore.add(media);
            System.out.println("Media \"" + media.getTitle() + "\" has been added to the store.");
        }
    }
    public void removeMedia(Media media) {
        if (media == null) {
            System.out.println("Cannot remove null media from store.");
            return;
        }
        if (itemsInStore.remove(media)) {
            System.out.println("Media \"" + media.getTitle() + "\" has been removed from the store.");
        } else {
            System.out.println("Media \"" + media.getTitle() + "\" not found in the store.");
        }
    }
    public void print() {
        System.out.println("*********************** STORE ***********************");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        } else {
            System.out.println("Items in store:");
            for (int i = 0; i < itemsInStore.size(); i++) {
                System.out.println((i + 1) + ". " + itemsInStore.get(i));
            }
        }
        System.out.println("***************************************************");
    }
    public List<Media> searchByTitle(String title) {
        List<Media> results = new ArrayList<>();
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Search title cannot be empty.");
            return results;
        }
        String keyword = title.toLowerCase();
        for (Media media : itemsInStore) {
            if (media.getTitle() != null && media.getTitle().toLowerCase().contains(keyword)) {
                results.add(media);
            }
        }
        if (results.isEmpty()) {
            System.out.println("No media found with title containing: \"" + title + "\"");
        } else {
            System.out.println("Found " + results.size() + " media(s):");
            for (int i = 0; i < results.size(); i++) {
                System.out.println((i + 1) + ". " + results.get(i));
            }
        }
        return results;
    }
    public List<Media> getItemsInStore() {
        return itemsInStore;
    }
}