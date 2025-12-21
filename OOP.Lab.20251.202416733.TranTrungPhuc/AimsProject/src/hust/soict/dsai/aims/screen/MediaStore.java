package hust.soict.dsai.aims.screen;
import java.awt.*;
import javax.swing.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
public class MediaStore extends JPanel {
    private static final long serialVersionUID = 1L;
    private Media media;
    private Cart cart;
    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel container = new JPanel(new FlowLayout());
        JButton addBtn = new JButton("Add to Cart");
        addBtn.addActionListener(e -> {
            cart.addMedia(media);
            JOptionPane.showMessageDialog(this, 
                "\"" + media.getTitle() + "\" added to cart!");
        });
        container.add(addBtn);
        if (media instanceof Playable playable) {
            JButton playBtn = new JButton("Play");
            playBtn.addActionListener(e -> {
                try {
                    playable.play(); 
                } catch (PlayerException ex) {
                    JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage(),
                        "Cannot play media",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
                new PlayMediaDialog(playable);
            });
            container.add(playBtn);
        }
        add(Box.createVerticalStrut(10));
        add(title);
        add(cost);
        add(Box.createVerticalStrut(10));
        add(container);
        add(Box.createVerticalGlue());
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    }
}