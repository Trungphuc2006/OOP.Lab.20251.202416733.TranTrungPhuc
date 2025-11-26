import java.util.Scanner;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        initializeSampleMedia();
        showMainMenu();
    }
    private static void initializeSampleMedia() {
        Media dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        Media dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, 121, "George Lucas");
        Media dvd3 = new DigitalVideoDisc(3, "Aladdin", "Animation", 18.99f, 90, "John Musker");
        Book book1 = new Book(4, "Java Programming", "Education", 29.99f);
        book1.addAuthor("John Doe");
        Book book2 = new Book(5, "Design Patterns", "Education", 39.99f);
        book2.addAuthor("Erich Gamma");
        CompactDisc cd1 = new CompactDisc(6, "Greatest Hits", "Music", 15.99f, 0, "Various", "Queen");
        cd1.addTrack(new Track("Bohemian Rhapsody", 355));
        cd1.addTrack(new Track("We Will Rock You", 122));
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(cd1);
    }
    public static void showMainMenu() {
        while (true) {
            System.out.println("\nAIMS: ");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3: ");
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Thank you for using AIMS. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static void viewStore() {
        while (true) {
            System.out.println("\n=== STORE ===");
            store.printStore();
            System.out.println("\nOptions: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4: ");
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine().trim();
        Media media = store.searchByTitle(title);
        if (media == null) {
            System.out.println("No media found with title: " + title);
            return;
        }
        System.out.println("\n=== MEDIA DETAILS ===");
        System.out.println(media.toString());
        if (media instanceof Playable) {
            mediaDetailsMenu(media);
        } else {
            System.out.println("This media cannot be played.");
        }
    }
    public static void mediaDetailsMenu(Media media) {
        while (true) {
            System.out.println("\nOptions: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            if (media instanceof Playable) {
                System.out.println("2. Play");
            }
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1" + (media instanceof Playable ? "-2" : "") + ": ");
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static void addMediaToCart() {
        System.out.print("Enter the title of the media to add to cart: ");
        String title = scanner.nextLine().trim();
        Media media = store.searchByTitle(title);
        if (media == null) {
            System.out.println("No media found with title: " + title);
            return;
        }
        cart.addMedia(media);
        if (media instanceof DigitalVideoDisc) {
            int dvdCount = countDVDsInCart();
            System.out.println("Number of DVDs in cart: " + dvdCount);
        }
    }
    private static int countDVDsInCart() {
        int count = 0;
        for (Media media : cart.getItemsOrdered()) {
            if (media instanceof DigitalVideoDisc) {
                count++;
            }
        }
        return count;
    }
    public static void playMedia() {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine().trim();
        Media media = store.searchByTitle(title);
        if (media == null) {
            System.out.println("No media found with title: " + title);
            return;
        }
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }
    public static void updateStore() {
        while (true) {
            System.out.println("\n=== UPDATE STORE ===");
            System.out.println("1. Add media to store");
            System.out.println("2. Remove media from store");
            System.out.println("0. Back");
            System.out.print("Please choose a number: 0-1-2: ");
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    addMediaToStore();
                    break;
                case 2:
                    removeMediaFromStore();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static void addMediaToStore() {
        System.out.println("\nSelect media type to add:");
        System.out.println("1. DVD");
        System.out.println("2. Book");
        System.out.println("3. CD");
        System.out.print("Choose type (1-3): ");
        int type = getIntInput();
        scanner.nextLine(); 
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter cost: ");
        float cost = getFloatInput();
        Media media = null;
        switch (type) {
            case 1:
                System.out.print("Enter director: ");
                String director = scanner.nextLine();
                System.out.print("Enter length (minutes): ");
                int length = getIntInput();
                media = new DigitalVideoDisc(store.getNumberOfItems() + 1, title, category, cost, length, director);
                break;
            case 2: 
                media = new Book(store.getNumberOfItems() + 1, title, category, cost);
                System.out.print("Enter author (or 'done' to finish): ");
                while (true) {
                    String author = scanner.nextLine();
                    if (author.equalsIgnoreCase("done")) break;
                    ((Book) media).addAuthor(author);
                    System.out.print("Add another author? (or 'done' to finish): ");
                }
                break;
            case 3:
                System.out.print("Enter artist: ");
                String artist = scanner.nextLine();
                System.out.print("Enter director: ");
                String cdDirector = scanner.nextLine();
                media = new CompactDisc(store.getNumberOfItems() + 1, title, category, cost, 0, cdDirector, artist);
                break;
            default:
                System.out.println("Invalid media type.");
                return;
        }
        store.addMedia(media);
        System.out.println("Media added successfully!");
    }
    public static void removeMediaFromStore() {
        store.printStore();
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine().trim();
        Media media = store.searchByTitle(title);
        if (media == null) {
            System.out.println("No media found with title: " + title);
            return;
        }
        store.removeMedia(media);
    }

    public static void seeCurrentCart() {
        while (true) {
            System.out.println("\n=== CURRENT CART ===");
            cart.print();
            System.out.println("\nOptions: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4-5: ");
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    filterMediasInCart();
                    break;
                case 2:
                    sortMediasInCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMediaFromCart();
                    break;
                case 5:
                    placeOrder();
                    return;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static void filterMediasInCart() {
        System.out.println("\nFilter by:");
        System.out.println("1. ID");
        System.out.println("2. Title");
        System.out.print("Choose option (1-2): ");
        int choice = getIntInput();
        scanner.nextLine(); 
        switch (choice) {
            case 1:
                System.out.print("Enter ID: ");
                int id = getIntInput();
                cart.searchById(id);
                break;
            case 2:
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                cart.searchByTitle(title);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
    public static void sortMediasInCart() {
        System.out.println("\nSort by:");
        System.out.println("1. Title");
        System.out.println("2. Cost");
        System.out.print("Choose option (1-2): ");
        int choice = getIntInput();
        switch (choice) {
            case 1:
                cart.sortByTitle();
                break;
            case 2:
                cart.sortByCost();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
    public static void removeMediaFromCart() {
        cart.print();
        System.out.print("Enter the number of the media to remove: ");
        int index = getIntInput() - 1;
        if (index >= 0 && index < cart.getItemsOrdered().size()) {
            cart.removeMedia(index);
        } else {
            System.out.println("Invalid media number.");
        }
    }
    public static void playMediaFromCart() {
        cart.print();
        System.out.print("Enter the number of the media to play: ");
        int index = getIntInput() - 1; 
        if (index >= 0 && index < cart.getItemsOrdered().size()) {
            Media media = cart.getItemsOrdered().get(index);
            if (media instanceof Playable) {
                ((Playable) media).play();
            } else {
                System.out.println("This media cannot be played.");
            }
        } else {
            System.out.println("Invalid media number.");
        }
    }
    public static void placeOrder() {
        System.out.println("\n=== PLACE ORDER ===");
        System.out.println("Order created successfully!");
        System.out.println("Total cost: $" + cart.totalCost());
        cart.clear();
        System.out.println("Your cart has been cleared. Thank you for your order!");
    }
    private static int getIntInput() {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine(); 
                return input;
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.nextLine(); 
            }
        }
    }
    private static float getFloatInput() {
        while (true) {
            try {
                float input = scanner.nextFloat();
                scanner.nextLine(); 
                return input;
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.nextLine(); 
            }
        }
    }
}