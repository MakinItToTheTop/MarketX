public class Product {

    private final int id;
    private final String name;
    private final Category category; 
    private final String description;
    private final float price;

    public Product(int id, String name, Category category, String description,float price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    

    

}