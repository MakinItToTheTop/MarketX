import java.io.Serializable;
import java.util.Random;

public class Product implements Serializable {

    private final int id;
    private final String name;
    private final Category category; 
    private final String description;
    private final float price;
    private Integer amount;
    private final Random r = new Random();

    public Product(int id, String name, Category category, String description,float price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.amount = r.nextInt(1,10);
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

    public Integer getAmount() {
        return amount;
    }

    public void decrementAmount() {
        if (amount>0){
            amount--;
        }
    }

    

    

}