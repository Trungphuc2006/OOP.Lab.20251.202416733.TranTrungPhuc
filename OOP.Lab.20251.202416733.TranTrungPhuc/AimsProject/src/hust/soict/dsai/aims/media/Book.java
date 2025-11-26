package hust.soict.dsai.aims.media;
import java.util.ArrayList;
public class Book extends Media {
    private ArrayList<String> authors;
    public Book(int id, String title, String category, float cost) {
    	super(id, title, category, cost);
        this.authors = new ArrayList<>();
    }
    public ArrayList<String> getAuthors() {
        return authors;
    }
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        } else {
            System.out.println("Author already exists in the list.");
        }
    }
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        } else {
            System.out.println("Author not found in the list.");
        }
    }
}
