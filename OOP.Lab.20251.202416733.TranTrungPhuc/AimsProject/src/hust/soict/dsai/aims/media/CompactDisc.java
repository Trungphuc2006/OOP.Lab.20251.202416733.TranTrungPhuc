package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;
import hust.soict.dsai.aims.exception.PlayerException;
public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<>();
    public CompactDisc(String title, String category, float cost, String artist) {
        super(title, category, cost);
        this.artist = artist;
    }
    public CompactDisc(String title, String category, String director, 
                       float cost, String artist) {
        super(title, category, director, cost);
        this.artist = artist;
    }
    public CompactDisc(String title, String category, String director, 
                       int length, float cost, String artist) {
        super(title, category, director, length, cost);
        this.artist = artist;
    }
    public CompactDisc(String title)
    {
    	super(title);
    }
    public String getArtist() {
        return artist;
    }
    public void addTrack(Track track) {
        if (track == null) {
            System.out.println("Cannot add null track.");
            return;
        }
        if (tracks.contains(track)) {
            System.out.println("Track \"" + track.getTitle() + "\" is already in the CD.");
        } else {
            tracks.add(track);
            System.out.println("Track \"" + track.getTitle() + "\" has been added to the CD.");
        }
    }
    public void removeTrack(Track track) {
        if (track == null) {
            System.out.println("Cannot remove null track.");
            return;
        }
        if (tracks.remove(track)) {
            System.out.println("Track \"" + track.getTitle() + "\" has been removed from the CD.");
        } else {
            System.out.println("Track \"" + track.getTitle() + "\" is not in the CD.");
        }
    }
    @Override
    public String toString() {
        return "CD - " + getTitle() + 
               " - " + (getCategory() != null ? getCategory() : "") +
               " - " + (getDirector() != null ? getDirector() : "") +
               " - " + artist +
               " - " + getLength() + " min: " + getCost() + " $";
    }
    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());

        for (Track track : tracks) {
            try {
                track.play();
            } catch (PlayerException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }
    }
}