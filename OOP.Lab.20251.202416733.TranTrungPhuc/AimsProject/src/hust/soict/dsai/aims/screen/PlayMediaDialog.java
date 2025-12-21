package hust.soict.dsai.aims.screen;
import javax.swing.*;
import java.awt.*;
import hust.soict.dsai.aims.media.Playable;
public class PlayMediaDialog extends JDialog {
    public PlayMediaDialog(Playable media) {
        setTitle("Playing Media");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setModal(true); 
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        c.fill = GridBagConstraints.HORIZONTAL;
        JLabel titleLabel = new JLabel("<html><h2>Now playing:</h2></html>", JLabel.CENTER);
        JLabel mediaInfo = new JLabel("", JLabel.CENTER);
        mediaInfo.setFont(new Font("Arial", Font.BOLD, 16));
        if (media instanceof hust.soict.dsai.aims.media.CompactDisc) {
            hust.soict.dsai.aims.media.CompactDisc cd = (hust.soict.dsai.aims.media.CompactDisc) media;
            mediaInfo.setText(cd.getTitle() + " - " + cd.getLength() + " minutes");
        } else if (media instanceof hust.soict.dsai.aims.media.DigitalVideoDisc) {
            hust.soict.dsai.aims.media.DigitalVideoDisc dvd = (hust.soict.dsai.aims.media.DigitalVideoDisc) media;
            mediaInfo.setText(dvd.getTitle() + " by " + dvd.getDirector() + " - " + dvd.getLength() + " minutes");
        }
        panel.add(titleLabel, c);
        c.gridy = 1;
        panel.add(mediaInfo, c);
        add(panel);
        setVisible(true);
    }
}