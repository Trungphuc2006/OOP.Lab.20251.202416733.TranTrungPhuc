package hust.soict.dsai.aims.screen;
import java.awt.*;
import java.awt.event.*; 
import java.util.ArrayList;
import javax.swing.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import java.util.ArrayList;
import javax.swing.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
public class StoreScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private Store store;
    private Cart cart;
    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;    
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        setTitle("Store");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }
    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));
        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);
        JButton cartButton = new JButton("View Cart");
        cartButton.setPreferredSize(new Dimension(100, 50));
        cartButton.setMaximumSize(new Dimension(100, 50));
        cartButton.addActionListener(e -> new CartScreen(cart));
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartButton);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));
        ArrayList<Media> mediaInStore = (ArrayList<Media>) store.getItemsInStore();
        for (int i = 0; i < Math.min(9, mediaInStore.size()); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i), cart); 
            center.add(cell);
        }
        for (int i = mediaInStore.size(); i < 9; i++) {
            center.add(new JPanel());
        }
        return center;
    }
    public static void main(String[] args) {
        Store store = new Store();
        Cart testCart = new Cart(); 
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 120, 24.95f));
        store.addMedia(new DigitalVideoDisc("Aladdin", "Animation", 90));
        store.addMedia(new Book("Harry Potter", "Fantasy", 29.99f));
        store.addMedia(new Book("The Lord of the Rings", "Fantasy", 35.99f));
        store.addMedia(new CompactDisc("Thriller", "Pop", 15.99f, "Michael Jackson"));
        store.addMedia(new CompactDisc("Back in Black", "Rock", 17.99f, "AC/DC"));
        store.addMedia(new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 22.95f));
        store.addMedia(new Book("Clean Code", "Technology", 45.00f));
        testCart.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        testCart.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 120, 24.95f));
        testCart.addMedia(new Book("Harry Potter", "Fantasy", 29.99f));
        testCart.addMedia(new CompactDisc("Thriller", "Pop", 15.99f, "Michael Jackson"));
        testCart.addMedia(new Book("Clean Code", "Technology", 45.00f));
        SwingUtilities.invokeLater(() -> {
            new StoreScreen(store, testCart); 
        });
    }
}