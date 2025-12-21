package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.media.*;
public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();
        Media dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Media book = new Book("Harry Potter", "Fantasy", 29.99f);
        Media cd = new CompactDisc("1989", "Pop", "Taylor Swift", 50f, "Taylor Swift");
        store.addMedia(dvd);
        store.addMedia(book);
        store.addMedia(cd);
        store.addMedia(dvd); 
        store.print();
        store.removeMedia(book);
        store.print();
        store.searchByTitle("lion");
    }
}