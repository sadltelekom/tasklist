public class Categories {
    private long id;
    private String category;

    public Categories(long id, String category) {
        this.id = id;
        this.category = category;
    }

    public Categories(String category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", category='" + category + '\'' +
                '}';
    }
}
