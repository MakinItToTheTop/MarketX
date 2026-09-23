
import java.util.HashMap;

public class Bag {
    public static HashMap<Product,Integer> bag = new HashMap<>();
    
    public Bag() {

    }

    public void addProduct(Product p) {
        bag.put(p, p.getId());
    }

    public void removeProduct(Product p) {
        bag.remove(p,p.getId());
    }

    public String showProduct() {
        Integer i = 1;
        for (Product a : bag.keySet()) {
            System.out.println("*" +i+"*"+" "+ a.getName() +"--- $"+a.getPrice() + "\n");
            i++;
        }
        return "";
    }

    public int getSizeBag() {
        return bag.size();
    }

    public HashMap<Product, Integer> getBag() {
        return bag;
    }

    

    public boolean Product_Is_Not_In(Product p) {
        for (Integer i : bag.values()) {
            if (p.getId() == i) {
                return false;
            }
        }

        return true;
    }

    public void removeAllProducts() {
        bag = new HashMap<>();
    }

    public float getFullPrice() {
        float sum = 0;
        for (Product p : bag.keySet()) {
            sum +=p.getPrice();
        }

        return sum;
    }

    public Product findProductById(int id) {
        for (Product a : bag.keySet()) {
            if (a.getId() == id) {
                return a;
            }
        }
        
        return new Product(0,"",Category.NONE,"",0);
    }
}