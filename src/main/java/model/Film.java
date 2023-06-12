package model;

public class Film {

    private int id;
    private String name;
    private String description;
    private double rating;
    private String category;

    public Film() {
    }

    public Film(int id, String name, String description, double rating, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.category = category;
    }

    public Film(String name, String description, double rating, String category) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.category = category;
    }

    public Film(String name, double rating, String category) {
        this.name = name;
        this.rating = rating;
        this.category = category;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", category='" + category + '\'' +
                '}';
    }
}
