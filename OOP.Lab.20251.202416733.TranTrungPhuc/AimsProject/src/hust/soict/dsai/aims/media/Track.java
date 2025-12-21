package hust.soict.dsai.aims.media;
import hust.soict.dsai.aims.exception.PlayerException;
public class Track implements Playable{
	private String title;
	private int length;
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	public Track(String title) {
		super();
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	@Override
	public void play() throws PlayerException {
	    if (this.getLength() <= 0) {
	        throw new PlayerException("ERROR: Track length is non-positive!");
	    }
	    System.out.println("Playing track: " + this.getTitle());
	    System.out.println("Track length: " + this.getLength());
	}
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Track)) return false;
        return title.equals(other.getTitle()) && length == other.getLength();
    }
}