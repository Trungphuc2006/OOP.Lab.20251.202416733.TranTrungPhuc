package hust.soict.dsai.aims.media;
import java.util.ArrayList;
public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks;
    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }
    public String getArtist() {
        return artist;
    }
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track is already in the list.");
        }
    }
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("Track not found in the list.");
        }
    }
    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("Artist: " + this.getArtist());
        System.out.println("CD length: " + this.getLength() + " minutes");
        for (Track track : tracks) {
            track.play(); 
        }
    }
}
