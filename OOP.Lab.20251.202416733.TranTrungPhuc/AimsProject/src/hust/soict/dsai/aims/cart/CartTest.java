package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
public class CartTest {
	public static void main(String[] args) {
	    Cart cart = new Cart();
	    cart.addMedia(new Book("Harry Potter", "Fantasy", 29.99f));
	    cart.addMedia(new DigitalVideoDisc("Avengers", "Action", 39.99f));
	    cart.addMedia(new Book("Harry Potter", "Fantasy", 25.00f)); 
	    cart.addMedia(new DigitalVideoDisc("avengers", "Action", 39.99f)); 
	    cart.print();
	    System.out.println("\n=== Sort by Title → Cost descending ===");
	    cart.sortByTitleCost();
	    cart.print();
	    System.out.println("\n=== Sort by Cost descending → Title ===");
	    cart.sortByCostTitle();
	    cart.print();
	}
}