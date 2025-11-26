package hust.soict.dsai.aims.media;
public class Track implements Playable {
    private String title;
    private int length;
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    public String getTitle() { return title; }
    public int getLength() { return length; }
    @Override
    public void play() {
        if (length <= 0) {
            System.out.println("Cannot play track: " + title + " - Invalid length");
            return;
        }
        System.out.println("Playing track: " + title);
        System.out.println("Track length: " + length + " seconds");
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Track)) return false;
        Track other = (Track) obj;
        boolean titleEqual;
        if (title == null) {
            titleEqual = (other.title == null);
        } else {
            titleEqual = title.equalsIgnoreCase(other.title);
        }
        return titleEqual && (length == other.length);
    }
    @Override
    public int hashCode() {
        int result = title != null ? title.toLowerCase().hashCode() : 0;
        result = 31 * result + length;
        return result;
    }
    @Override
    public String toString() {
        return "Track - " + title + " - " + length + " seconds";
    }
}