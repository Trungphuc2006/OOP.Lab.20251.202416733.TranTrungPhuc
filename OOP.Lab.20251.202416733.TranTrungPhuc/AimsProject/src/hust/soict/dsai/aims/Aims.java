package hust.soict.dsai.aims;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        store.addMedia(new Book("Harry Potter", "Fantasy", 29.99f));
        store.addMedia(new Book("The Hobbit", "Fantasy", 25.50f));
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f));
        store.addMedia(new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 29.99f));
        store.addMedia(new CompactDisc("1989", "Pop", "Taylor Swift", 50f, "Taylor Swift"));
        store.addMedia(new CompactDisc("Abbey Road", "Rock", "The Beatles", 45f, "The Beatles"));
        store.addMedia(new CompactDisc("Thriller", "Pop", "Michael Jackson", 60f, "Michael Jackson"));
        cart.addMedia(store.getItemsInStore().get(0)); 
        cart.addMedia(store.getItemsInStore().get(2)); 
        cart.addMedia(store.getItemsInStore().get(5)); 
        while (true) {
            showMenu();
            int choice = getChoice(0, 4);
            switch (choice) {
                case 1 -> viewStore();
                case 2 -> updateStore();
                case 3 -> seeCurrentCart();
                case 0 -> {
                    System.out.println("Goodbye! See you again!");
                    scanner.close();
                    return;
                }
            }
        }
    }
    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }
    public static void viewStore() {
        while (true) {
            store.print();
            storeMenu();
            int choice = getChoice(0, 4);
            switch (choice) {
                case 1 -> seeMediaDetails();
                case 2 -> addToCart();
                case 3 -> {
                    try {
                        playMedia();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Cannot play media", JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();
                    }
                }
                case 4 -> seeCurrentCart();
                case 0 -> { return; }
            }
        }
    }
    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }
    public static void seeMediaDetails() {
        System.out.println("Id to display: ");
        String s = scanner.nextLine();
        int id = Integer.parseInt(s);
        if (id > 0 && id <= store.getItemsInStore().size()) {
            System.out.println(store.getItemsInStore().get(id - 1));
        } else {
            System.out.println("Invalid Id.");
        }
    }
    public static void addToCart() {
        System.out.println("Id to add to cart: ");
        String s = scanner.nextLine();
        int id = Integer.parseInt(s);
        if (id > 0 && id <= store.getItemsInStore().size()) {
            cart.addMedia(store.getItemsInStore().get(id - 1));
        } else {
            System.out.println("Invalid Id.");
        }
    }
    public static void playMedia() {
        Media selectedMedia = media;

        if (selectedMedia == null) {
            JOptionPane.showMessageDialog(null, "No media selected!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (selectedMedia instanceof Playable) {
            try {
                ((Playable) selectedMedia).play();
            } catch (PlayerException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
                JOptionPane.showMessageDialog(
                    null,
                    "Error: " + e.getMessage(),
                    "Illegal DVD Length",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        } else {
            JOptionPane.showMessageDialog(null, "This media cannot be played!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static void updateStore() {
        while (true) {
            System.out.println("\nUpdate store:");
            System.out.println("1. Add a media");
            System.out.println("2. Remove a media");
            System.out.println("0. Back");
            System.out.print("Choose: ");
            int choice = getChoice(0, 2);
            if (choice == 0) return;

            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            List<Media> results = store.searchByTitle(title);

            if (choice == 1) {
                System.out.println("\nChoose type:");
                System.out.println("1. DVD");
                System.out.println("2. CD");
                System.out.println("3. Book");
                System.out.println("0. Back");
                int choice2 = getChoice(0, 3);
                if (choice2 == 0) return;
                switch (choice2) {
                    case 1 -> store.addMedia(new DigitalVideoDisc(title, "Unknown", "Unknown", 0, 20.0f));
                    case 2 -> store.addMedia(new CompactDisc(title, "Unknown", "Unknown", 0, 30.0f, "Unknown"));
                    case 3 -> store.addMedia(new Book(title, "Unknown", 25.0f));
                }
                System.out.println("Media added successfully!");
            } else if (choice == 2) {
                if (!results.isEmpty()) {
                    store.removeMedia(results.get(0));
                } else {
                    System.out.println("Media not found.");
                }
            }
        }
    }
    public static void seeCurrentCart() {
        while (true) {
            cart.print();
            cartMenu();
            int choice = getChoice(0, 5);
            switch (choice) {
                case 1 -> filterMediaInCart();
                case 2 -> sortCartMenu();
                case 3 -> removeFromCart();
                case 4 -> playMediaInCart();
                case 5 -> placeOrder();
                case 0 -> { return; }
            }
        }
    }
    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    public static void filterMediaInCart() {
        System.out.println("Enter type: ");
        String type = scanner.nextLine().trim();
        type = type.toLowerCase();
        boolean found = false;

        for (Media media : cart.getItemsOrdered()) {
            if (type.contains("dvd") || type.contains("digital")) {
                if (media instanceof DigitalVideoDisc) {
                    System.out.println("Found DVD: " + media);
                    found = true;
                }
            } else if (type.contains("cd") || type.contains("compact")) {
                if (media instanceof CompactDisc) {
                    System.out.println("Found CD: " + media);
                    found = true;
                }
            } else if (type.contains("book")) {
                if (media instanceof Book) {
                    System.out.println("Found Book: " + media);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No media found for type: " + type);
        }
    }

    public static void sortCartMenu() {
        System.out.println("1. Sort by title-cost");
        System.out.println("2. Sort by cost-title");
        int c = getChoice(1, 2);
        if (c == 1) cart.sortByTitleCost();
        else cart.sortByCostTitle();
        cart.print();
    }

    public static void removeFromCart() {
        System.out.println("Id to remove: ");
        String s = scanner.nextLine();
        int id = Integer.parseInt(s);
        if (id > 0 && id <= cart.getItemsOrdered().size()) {
            cart.removeMedia(cart.getItemsOrdered().get(id - 1));
        } else {
            System.out.println("Invalid Id.");
        }
    }

    public static void playMediaInCart() throws PlayerException {
        System.out.println("Id to play: ");
        String s = scanner.nextLine();
        int id = Integer.parseInt(s);
        if (id > 0 && id <= cart.getItemsOrdered().size()) {
            Media media = cart.getItemsOrdered().get(id - 1);
            if (media instanceof Playable) {
                ((Playable) media).play();
            } else {
                System.out.println("This media cannot be played.");
            }
        } else {
            System.out.println("Invalid ID.");
        }
    }

    public static void placeOrder() {
        System.out.println("Order placed! Total cost: " + cart.totalCost() + " $");
        cart = new Cart(); 
    }
    private static int getChoice(int min, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= min && choice <= max) return choice;
                System.out.print("Invalid choice. Please try again: ");
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}