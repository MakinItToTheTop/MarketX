
import java.io.Serializable;
import java.util.Random;


public class Card implements Serializable {
    private String card_numb;
    private String exp_date;
    private String code;
    private Integer balance;
    private final Random r = new Random();
    

    public Card(String card_numb, String exp_date,String code) {
       
        this.card_numb = card_numb;
        this.exp_date = exp_date;
        this.code = code;
        this.balance = r.nextInt(1000);
    }

    public String getCardNumb() {
        return card_numb;
    }

    public String getExpDate() {
        return exp_date;
    }

    public String getCode() {
        return code;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setCardNumb(String cardNumb) {
        card_numb = cardNumb;
    }

    public void setExpDate(String date) {
        exp_date = date;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void decrementBalance(Integer price) {
        balance = balance - price;
    }

    
    





}