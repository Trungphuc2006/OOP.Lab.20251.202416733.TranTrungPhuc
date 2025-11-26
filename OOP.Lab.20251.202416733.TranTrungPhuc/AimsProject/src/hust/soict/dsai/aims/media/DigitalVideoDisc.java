package hust.soict.dsai.aims.media;
public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;
    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }
    public DigitalVideoDisc(String title, String category, float cost, int length, String director) {
        super(++nbDigitalVideoDiscs, title, category, cost, length, director);
    }
    public DigitalVideoDisc(String title) {
        super(++nbDigitalVideoDiscs, title, "Unknown", 0.0f, 0, "Unknown");
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, 0, "Unknown");
    }
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, 0, director);
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, length, director);
    }
    @Override
    public void play() {
        if (this.getLength() <= 0) {
            System.out.println("Cannot play DVD: " + this.getTitle() + " - Invalid length");
            return;
        }
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength() + " minutes");
    }
    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + 
               getDirector() + " - " + getLength() + "min: " + getCost() + " $";
    }    
    public boolean isMatch(String title) {
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }
}