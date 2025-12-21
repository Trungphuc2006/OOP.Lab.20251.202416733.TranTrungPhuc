package hust.soict.dsai.aims.media;
import java.util.Comparator;
public abstract class Media{
    protected int id;
    protected String title;
    protected String category;
    protected float cost;
    public Media() {
    }
    public Media(String title) { this.title = title; }
    public Media(String title, String category) { this(title); this.category = category; }
    public Media(String title, String category, float cost) { this(title, category); this.cost = cost; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public float getCost() { return cost; }
    public void setCost(float cost) { this.cost = cost; }
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = 
            new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = 
            new MediaComparatorByCostTitle();
    @Override
    public String toString() {
        return String.format("%s - %s: %.2f $", 
            title != null ? title : "Unknown",
            category != null ? category : "Unknown",
            cost);
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Media)) {
            return false;
        }
        Media other = (Media) obj;
        if (this.getTitle() == null) {
            return other.getTitle() == null;
        }
        return this.getTitle().equals(other.getTitle());
    }
}