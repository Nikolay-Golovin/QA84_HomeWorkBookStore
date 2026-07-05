import java.util.Objects;

public class Library implements Comparable<Library>{
    private String title;
    private String author;
    private String description;
    private int pages;
    private double price;

    public Library(String title, String author, String description, int pages, double price) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.pages = pages;
        this.price = price;
    }

    @Override
    public int compareTo(Library other) {
        return this.title.compareToIgnoreCase(other.title);
    }
    @Override
    public String toString() {
        return "Library{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                '}';
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
