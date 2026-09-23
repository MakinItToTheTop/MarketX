import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;



public class Main implements Serializable {

    private static Pattern exp_pattern = Pattern.compile("^[0-9][0-9][/][0-9][0-9]$");
    private static Pattern card_pattern = Pattern.compile("^[0-9]{16,20}$");
    private static Pattern code_pattern = Pattern.compile("^[0-9]{3}$");
    private static Pattern balance_pattern = Pattern.compile("^[0-9]+$");
    private static Pattern user_pattern = Pattern.compile("^[a-zA-Z0-9]{5,20}$");
    private static Pattern pass_pattern = Pattern.compile("^[a-zA-Z]+[0-9]+[*.?!]+$");
    private static HashMap<Card,Integer> registered_cards = new HashMap<>();
    private static ArrayList<Username> registered_users = new ArrayList<>();
    private static ObjectOutputStream oou;
    private static Integer saveUserId;
    private static boolean logged = false;
     

    public static void main(String[] args) throws IOException {

        try(ObjectInputStream ooi = new ObjectInputStream(new FileInputStream("cards.ser"))){
            registered_cards = (HashMap<Card,Integer>) ooi.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream ooi1 = new ObjectInputStream(new FileInputStream("users.ser"))){
            registered_users = (ArrayList<Username>) ooi1.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        

       // 1234123412341234  09/29  123
       // 1900190019001900 12/29 982

        //ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cards.ser"));
        Product p1 = new Product(1,"Slender : the arrival",Category.HORROR,"Slender Man est de retour, et encore plus terrifiant. Personne pour vous aider. Personne pour vous entendre crier. Replongez-vous dans l'horreur et découvrez des graphismes améliorés de survival-horror à l'occasion des 10 ans du jeu.",20);
        Product p2 = new Product(2,"Minecraft",Category.ADVENTURE,"Construisez tout ce que vous pouvez imaginer, découvrez des mystères étranges et survivez à la nuit dans ce jeu de bac à sable d’aventure ultime. Dans Minecraft, chaque partie est différente et des aventures inoubliables vous attendent à chaque coin. Explorez et fabriquez votre chemin dans un monde infini que vous pouvez façonner, un bloc à la fois.",10);
        Product p3 = new Product(3,"GTA VI",Category.ADVENTURE,"Jason Duval et Lucia Caminos ont toujours baigné dans le milieu criminel et la vie ne leur a jamais été facile, malgré le soleil de la Leonida. Ils découvrent d'ailleurs la face obscure de cette région lorsque les choses tournent mal, en se retrouvant au cœur d'un complot criminel qui s'étend dans tout l'État, ce qui les obligera à compter plus que jamais l'un sur l'autre pour survivre",100);
        Product p4 = new Product(4,"Resident Evil : Village Edition",Category.HORROR,"Survie et épouvante atteignent des sommets dans le 8e titre de la franchise Resident Evil : Resident Evil Village. Graphismes ultra-détaillés, action intense en vue subjective et récit palpitant : la peur n'a jamais été aussi palpable.",39.99f);
        Product p5 = new Product(5,"Call Of Duty : Black Ops VI",Category.WARFARE,"Nous revenons aux racines de Black Ops avec Call of Duty : Black Ops 6, proposant une campagne solo cinématique, une expérience multijoueur de premier ordre et le légendaire mode® zombie par tours !",67);
        Product p6 = new Product(6,"Sons Of The Forest",Category.HORROR,"Envoyé à la recherche d’un milliardaire disparu sur une île isolée, vous vous retrouvez dans un enfer infesté de cannibales. Fabriquez, construisez et luttez pour survivre, seul ou avec des amis, dans ce nouveau simulateur terrifiant de survival horror en monde ouvert.",200);
        while (true) {
        
        Scanner sc = new Scanner(System.in);
        Bag bagg = new Bag();
        registered_cards.put(new Card("4242424242424242","09/12","000"),1);
        
        
        while (logged == false) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("----------Register/Login----------");
            System.out.println("[1] Login");
            System.out.println("[2] Register");
            System.out.println("----------------------------------");
            int regChoice = sc.nextInt();
            sc.nextLine();

            if (regChoice == 1) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("--------------Login-------------\n");
            
                
                System.out.println("Enter username: ");
                String username = sc.nextLine();
                while (!user_pattern.matcher(username).matches()) {
                    System.out.println("Incorrect format ! Re-enter username: ");
                    username = sc.nextLine();
                }

                System.out.println("Enter password: ");
                char[] passwordChars = System.console().readPassword();
                String password = new String(passwordChars);

                while(!pass_pattern.matcher(password).matches()) {
                    System.out.println("Incorrect format ! Re-enter password: ");
                    passwordChars = System.console().readPassword();
                    password = new String(passwordChars);
                }

                for (Username u : registered_users) {
                    if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("Login successful ! Redirecting to MarketX...");
                        try {
                            Thread.sleep(2000);
                            logged=!logged;
                            
                            if (u.IsRegistered() == false) {
                                saveUserId = u.getId();
                                u.setRegistered();
                                oou = new ObjectOutputStream(new FileOutputStream(u.getId()+".ser"));
                            } else {
                                saveUserId = u.getId();
                                try (ObjectInputStream ooui = new ObjectInputStream(new FileInputStream(u.getId()+".ser"))) {
                                    bagg.bag = (HashMap<Product, Integer>) ooui.readObject();
                                    oou = new ObjectOutputStream(new FileOutputStream(saveUserId +".ser")); 
                                } catch (IOException | ClassNotFoundException e) {
                                    e.getStackTrace();
                                }
                                
                                
                            }


                            break;
                        } catch (InterruptedException e) {
                            e.getStackTrace();
                        }

                    } 
                }
                
            }

            if (regChoice == 2) {
                // 1/10000 chances de tomber sur le même chiffre
                Integer id = new Random().nextInt(10000);
                boolean registered_already = false;
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("--------------Register-------------\n");

                
                System.out.println("Enter username: ");
                String username = sc.nextLine();
                while (!user_pattern.matcher(username).matches()) {
                    System.out.println("Incorrect format ! Re-enter username: ");
                    username = sc.nextLine();
                }

                System.out.println("Enter password: ");
                char[] passwordChars = System.console().readPassword();
                String password = new String(passwordChars);

                while(!pass_pattern.matcher(password).matches()) {
                    System.out.println("Incorrect format ! Re-enter password: ");
                    passwordChars = System.console().readPassword();
                    password = new String(passwordChars);
                }

                for (Username u : registered_users) {
                    if (u.getPassword().equals(password) && u.getUsername().equals(username)) {
                        registered_already = true;
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("This account has already been registered...");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.getStackTrace();
                        }
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    } else {
                        registered_already = false;
                        
                    }
                }

                if (registered_already) {
                    continue;
                } else {
                    registered_users.add(new Username(username,password,id));
                    ObjectOutputStream ooi1 = new ObjectOutputStream(new FileOutputStream("users.ser"));
                    ooi1.writeObject(registered_users);
                }
                
                
    
                System.out.println("Register successful ! Now login...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.getStackTrace();
                }
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                
            }
            
        }
        
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("--------------------------------");
        System.out.println("      Welcome to MarketX        ");
        System.out.println("--------------------------------");

        System.out.println("[1] Product Page");
        System.out.println("[2] Shopping Bag & Checkout");
        System.err.println("[3] Exit");

        
        int menuChoice = sc.nextInt();
        sc.nextLine();
        if (menuChoice == 1) {    
            while (true) {
                

                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("-----------------------------------------------");
                System.out.println("      Choose a product you want to buy !       ");
                System.out.println("-----------------------------------------------");

                if (p1.getAmount()>0) {
                    System.out.println("[1] Slender : the arrival "+"("+p1.getAmount()+" stock left!)");
                }
                
                if (p2.getAmount()>0) {
                    System.out.println("[2] Minecraft " + "("+p2.getAmount()+" stock left!)");
                }

                if (p3.getAmount()>0) {
                    System.out.println("[3] GTA VI "+"("+p3.getAmount()+" stock left!)");
                }

                if (p4.getAmount()>0) {
                    System.out.println("[4] Resident Evil : Village Edition " + "("+p4.getAmount()+" stock left!)");
                }

                if (p5.getAmount()>0) {
                    System.out.println("[5] Call Of Duty : Black Ops VI " + "(" +p5.getAmount()+" stock left!)");
                }

                if (p6.getAmount()>0) {
                    System.out.println("[6] Sons of the Forest " + "("+p6.getAmount()+" stock left!)");
                }

                System.out.println("*************************************");
                System.out.println("[0] Go back");
                
                int mainChoice = sc.nextInt();
                sc.nextLine();
                
                if (mainChoice == 0) {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    break;
                }

                else if (mainChoice == 1) {
                    while (true) {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        
                        System.out.println("---------" + p1.getName() + "---------");
                        System.out.println("Category: " + p1.getCategory());
                        System.out.println("Description: " + p1.getDescription());
                        System.out.println("Price: $" + p1.getPrice());

                        System.out.println("[0] Go back ---- [1] Add to Bag");
                        int checkoutChoice = sc.nextInt();
                        sc.nextLine();
                       
                        if (checkoutChoice == 0) {
                            
                            break;
                        }

                        else if (checkoutChoice == 1) {
                            while (true) {
                                if (bagg.Product_Is_Not_In(p1)) {
                                    bagg.addProduct(p1);
                                    oou = new ObjectOutputStream(new FileOutputStream(saveUserId+".ser"));
                                    oou.writeObject(bagg.getBag());
                                } else {
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("Product: " +p1.getName() + " is already in the bag!");
                                    try {
                                        Thread.sleep(2000);
                                    } catch (InterruptedException e) {
                                        Thread.currentThread().interrupt();
                                    }
                                    
                                    break;
                                }
                                
                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                System.out.println("Product: " +p1.getName() + " has been added!");
                                p1.decrementAmount();
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }
                                
                                break;
                            }
                            

                            
                        }
                    }
                }

                else if (mainChoice == 2) {
                    while (true) {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        
                        System.out.println("---------" + p2.getName() + "---------");
                        System.out.println("Category: " + p2.getCategory());
                        System.out.println("Description: " + p2.getDescription());
                        System.out.println("Price: $" + p2.getPrice());

                        System.out.println("[0] Go back ---- [1] Buy");
                        int buyChoice = sc.nextInt();
                        sc.nextLine();
                        if (buyChoice == 0) {
                            
                            break;
                        }

                        else if (buyChoice == 1) {
                            while (true) {
                                if (bagg.Product_Is_Not_In(p2)) {
                                    bagg.addProduct(p2);
                                    oou = new ObjectOutputStream(new FileOutputStream(saveUserId+".ser"));
                                    oou.writeObject(bagg.getBag());
                                } else {
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("Product: " +p2.getName() + " is already in the bag!");
                                    try {
                                        Thread.sleep(2000);
                                    } catch (InterruptedException e) {
                                        Thread.currentThread().interrupt();
                                    }
                                    
                                    break;
                                }

                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                System.out.println("Product: " +p2.getName() + " has been added!");
                                p2.decrementAmount();
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }
                                
                                break;

                            }
                            

                            
                        }

                        
                    }
                }

                else if (mainChoice == 3) {
                    while (true) {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        
                        System.out.println("---------" + p3.getName() + "---------");
                        System.out.println("Category: " + p3.getCategory());
                        System.out.println("Description: " + p3.getDescription());
                        System.out.println("Price: $" + p3.getPrice());

                        System.out.println("[0] Go back ---- [1] Buy");
                        int buyChoice = sc.nextInt();
                        sc.nextLine();
                        if (buyChoice == 0) {
                            
                            break;
                        }

                        else if (buyChoice == 1) {
                            while (true) {
                                if (bagg.Product_Is_Not_In(p3)) {
                                    bagg.addProduct(p3);
                                    oou = new ObjectOutputStream(new FileOutputStream(saveUserId+".ser"));
                                    oou.writeObject(bagg.getBag());
                                } else {
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("Product: " +p3.getName() + " is already in the bag!");
                                    try {
                                        Thread.sleep(2000);
                                    } catch (InterruptedException e) {
                                        Thread.currentThread().interrupt();
                                    }
                                    
                                    break;
                                }

                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                System.out.println("Product: " +p3.getName() + " has been added!");
                                p3.decrementAmount();
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }
                                
                                break;

                            }
                            

                            
                        }

                        
                    }
                }


                else if (mainChoice == 4) {
                    while (true) {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        
                        System.out.println("---------" + p4.getName() + "---------");
                        System.out.println("Category: " + p4.getCategory());
                        System.out.println("Description: " + p4.getDescription());
                        System.out.println("Price: $" + p4.getPrice());

                        System.out.println("[0] Go back ---- [1] Buy");
                        int buyChoice = sc.nextInt();
                        sc.nextLine();
                        if (buyChoice == 0) {
                            
                            break;
                        }

                        else if (buyChoice == 1) {
                            while (true) {
                                if (bagg.Product_Is_Not_In(p4)) {
                                    bagg.addProduct(p4);
                                    oou = new ObjectOutputStream(new FileOutputStream(saveUserId+".ser"));
                                    oou.writeObject(bagg.getBag());
                                } else {
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("Product: " +p4.getName() + " is already in the bag!");
                                    try {
                                        Thread.sleep(2000);
                                    } catch (InterruptedException e) {
                                        Thread.currentThread().interrupt();
                                    }
                                    
                                    break;
                                }

                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                System.out.println("Product: " +p4.getName() + " has been added!");
                                p4.decrementAmount();
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }
                                
                                break;

                            }
                            

                            
                        }

                        
                    }
                }

                else if (mainChoice == 5) {
                    while (true) {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("---------" + p5.getName() + "---------");
                        System.out.println("Category: " + p5.getCategory());
                        System.out.println("Description: " + p5.getDescription());
                        System.out.println("Price: $" + p5.getPrice());

                        System.out.println("[0] Go back ---- [1] Buy");
                        int buyChoice = sc.nextInt();
                        sc.nextLine();
                        if (buyChoice == 0) {
                            
                            break;
                        }

                        else if (buyChoice == 1) {
                            while (true) {
                                if (bagg.Product_Is_Not_In(p5)) {
                                    bagg.addProduct(p5);
                                    oou = new ObjectOutputStream(new FileOutputStream(saveUserId+".ser"));
                                    oou.writeObject(bagg.getBag());
                                } else {
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("Product: " +p5.getName() + " is already in the bag!");
                                    try {
                                        Thread.sleep(2000);
                                    } catch (InterruptedException e) {
                                        Thread.currentThread().interrupt();
                                    }
                                    
                                    break;
                                }

                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                System.out.println("Product: " +p5.getName() + " has been added!");
                                p5.decrementAmount();
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }
                                
                                break;

                            }
                            

                            
                        }

                        
                    }
                }

                else if (mainChoice == 6) {
                    while (true) {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        
                        System.out.println("---------" + p6.getName() + "---------");
                        System.out.println("Category: " + p6.getCategory());
                        System.out.println("Description: " + p6.getDescription());
                        System.out.println("Price: $" + p6.getPrice());

                        System.out.println("[0] Go back ---- [1] Buy");
                        int buyChoice = sc.nextInt();
                        sc.nextLine();
                        if (buyChoice == 0) {
                            
                            break;
                        }

                        else if (buyChoice == 1) {
                            while (true) {
                                if (bagg.Product_Is_Not_In(p6)) {
                                    bagg.addProduct(p6);
                                    oou = new ObjectOutputStream(new FileOutputStream(saveUserId+".ser"));
                                    oou.writeObject(bagg.getBag());
                                } else {
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("Product: " +p6.getName() + " is already in the bag!");
                                    try {
                                        Thread.sleep(2000);
                                    } catch (InterruptedException e) {
                                        Thread.currentThread().interrupt();
                                    }
                                    
                                    break;
                                }

                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                System.out.println("Product: " +p6.getName() + " has been added!");
                                p6.decrementAmount();
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }
                                
                                break;

                            }
                            

                            
                        }

                        
                    }
                }

                


            }
        } 

        else if (menuChoice == 2) {
            while (true) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("--------Shopping bag---------\n");
                
                System.out.println(bagg.showProduct());

                System.out.println("Total: $" + bagg.getFullPrice());
                
                System.out.println("[0] Go back ---- [1] Checkout ---- [2] Remove ---- [3] Register a new card");
                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 0) {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    break;
                }

                else if (choice == 1) {
                    
                    System.out.println("-------Checkout-------");
                    
                    System.out.println("Enter your card number: ");
                    String cardNumber = sc.nextLine();
                    while (!card_pattern.matcher(cardNumber).matches()) {
                        System.out.println("Enter your card number: ");
                        cardNumber = sc.nextLine();
                    }
                    
                    System.out.println("Enter your expiry date in the ../.. format: ");
                    String expiryDate = sc.nextLine();
                    while (!exp_pattern.matcher(expiryDate).matches()) {
                        System.out.println("Enter your expiry date in the ../.. format: ");
                        expiryDate = sc.nextLine();
                    }
                    
                    System.out.println("Enter your three-digit code: ");
                    String code = sc.nextLine();
                    while (!code_pattern.matcher(code).matches()) {
                        System.out.println("Enter your three-digit code: ");
                        code = sc.nextLine();
                    }

                    boolean found = false;
                
                    for (Card n : registered_cards.keySet()) {
                        if (n.getCardNumb().equals(cardNumber) && n.getExpDate().equals(expiryDate) && n.getCode().equals(code)) {
                            if (bagg.getFullPrice() != 0 && n.getBalance() >= bagg.getFullPrice()) {
                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                System.out.println("You just bought..." );
                                bagg.showProduct();
                                n.decrementBalance((int)bagg.getFullPrice());
                                
                                try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cards.ser"))) {
                                    oos.writeObject(registered_cards);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                try(ObjectInputStream ooi = new ObjectInputStream(new FileInputStream("cards.ser"))){
                                    registered_cards = (HashMap<Card,Integer>) ooi.readObject();
                                } catch (IOException | ClassNotFoundException e) {
                                    e.printStackTrace();
                                }

                                bagg.removeAllProducts();
                                
                                System.out.println("Your current balance is: $"+n.getBalance()); 
                                found = true;
                                try {
                                    Thread.sleep(2000);
                                    break;
                                } catch (InterruptedException e) {

                                }
                            } else if (bagg.getFullPrice() == 0) {
                                found = true;
                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                System.out.println("You don't have any item in your bag!");
                                try {
                                    Thread.sleep(2000);
                                } catch (Exception e) {
                                }
                            } else {
                                found = true;
                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                System.out.println("You don't have enough money to buy...");
                                try {
                                    Thread.sleep(2000);
                                } catch (Exception e) {
                                }
                            }

                           
                        }
                        
                    }

                    if (!found) {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("This card has not been registered...");
                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                        }
                    } 
                        
                    
                    
                }

                else if (choice == 2) {
                    System.out.println("choose product number: ");
                    int prod_numb = sc.nextInt();
                    sc.nextLine();
                    if (bagg.findProductById(prod_numb).getCategory() != Category.NONE) {
                        System.out.println("Product: "+ bagg.findProductById(prod_numb).getName() + " has been removed from the bag.");
                        bagg.removeProduct(bagg.findProductById(prod_numb));
                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                        }
                    }
                    
                }

                else if (choice == 3) {
                    System.err.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("--------Register your card--------");
                    System.err.println("Enter card number: ");
                    String card_numb = sc.nextLine();
                    while (!card_pattern.matcher(card_numb).matches()) {
                        System.out.println("Incorrect ! Re-enter card number: ");
                        card_numb = sc.nextLine();
                    }

                    System.err.println("Enter expiry date: ");
                    String exp_date = sc.nextLine();
                    while (!exp_pattern.matcher(exp_date).matches()) {
                        System.out.println("Incorrect ! Re-enter expiry date: ");
                        exp_date = sc.nextLine();
                    }

                    System.err.println("Enter three-digit code: ");
                    String code = sc.nextLine();
                    while (!code_pattern.matcher(code).matches()) {
                        System.out.println("Incorrect ! Re-enter three-digit code: ");
                        code = sc.nextLine();
                    }

                    Card new_card = new Card(card_numb,exp_date,code);

                    for (Card c : registered_cards.keySet()) {
                        if (c.getCardNumb().equals(new_card.getCardNumb()) && c.getExpDate().equals(new_card.getExpDate()) && c.getCode().equals(new_card.getCode())) {
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("This card has already been registered...");
                            try {
                                Thread.sleep(2000);
                                break;
                            } catch (Exception e) {
                            }
                        } else {
                            registered_cards.put(new_card,1);
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("Card has been registered successfully !");

                            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cards.ser"))) {
                                oos.writeObject(registered_cards);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            try(ObjectInputStream ooi = new ObjectInputStream(new FileInputStream("cards.ser"))){
                                registered_cards = (HashMap<Card,Integer>) ooi.readObject();
                            } catch (IOException | ClassNotFoundException e) {
                                e.printStackTrace();
                            }

                            try {
                                Thread.sleep(2000);
                                break;
                            } catch (Exception e) {
                            }
                        }
                    }
                    
                    
                }
            }
        }

        else if (menuChoice == 3) {
            return;
        }

        
    }
    }

    
}