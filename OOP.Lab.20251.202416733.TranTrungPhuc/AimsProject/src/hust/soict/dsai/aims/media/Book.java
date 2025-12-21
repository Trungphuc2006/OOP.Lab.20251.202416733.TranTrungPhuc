package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;
public class Book extends Media {
    private List<String> authors = new ArrayList<>(); 
    public Book() {
        super();
    }
    public Book(String title) {
        super(title);
    }
    public Book(String title, String category) {
        super(title, category);
    }
    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }
    public Book(String title, String category, float cost, List<String> authors) {
        super(title, category, cost);
        if (authors != null) {
            this.authors = new ArrayList<>(authors);   
        if (authorName == null || authorName.trim().isEmpty()) {
            System.out.println("Author name cannot be empty!");
            return;
        }
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author \"" + authorName + "\" has been added.");
        } else {
            System.out.println("Author \"" + authorName + "\" is already in the list.");
        }
    }
    public void removeAuthor(String authorName) {
        if (authorName == null) {
            System.out.println("Author name cannot be null!");
            return;
        }
        if (authors.remove(authorName)) {
            System.out.println("Author \"" + authorName + "\" has been removed.");
        } else {
            System.out.println("Author \"" + authorName + "\" not found in the list.");
        }
    }
    public List<String> getAuthors() {
        return new ArrayList<>(authors);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Book - ").append(getTitle());
        if (getCategory() != null) sb.append(" - ").append(getCategory());
        sb.append(" - Authors: [");
        if (!authors.isEmpty()) {
            for (int i = 0; i < authors.size(); i++) {
                sb.append(authors.get(i));
                if (i < authors.size() - 1) sb.append(", ");
            }
        }
        sb.append("]");
        sb.append(" - ").append(getCost()).append(" $");
        return sb.toString();
    }
}