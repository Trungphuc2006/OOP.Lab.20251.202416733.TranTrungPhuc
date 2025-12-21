package hust.soict.dsai.aims.media;
import hust.soict.dsai.aims.exception.PlayerException;
public class DigitalVideoDisc extends Disc implements Playable{
    private static int nbDigitalVideoDiscs = 0;
    public DigitalVideoDisc(String title) {
        super(title);
        this.id = ++nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
        this.id = ++nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);   
        this.id = ++nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost); 
    }
    public boolean isMatch(String title) {
        if (title == null || this.getTitle() == null) return false;
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }
    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}