
public class Card {
    private String card_numb;
    private String exp_date;
    private String code;
    private Integer balance;
    

    public Card(String card_numb, String exp_date,String code, Integer balance) {
       
        this.card_numb = card_numb;
        this.exp_date = exp_date;
        this.code = code;
        this.balance = balance;
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
    





}