import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {

    private static Pattern exp_pattern = Pattern.compile("^[0-9][0-9][/][0-9][0-9]$");
    private static Pattern card_pattern = Pattern.compile("^[0-9]{16,20}$");
    private static Pattern code_pattern = Pattern.compile("^[0-9]{3}$");
    private static Pattern balance_pattern = Pattern.compile("^[0-9]+$");

    public static void main(String[] args) {
        while (true) {
        Scanner sc = new Scanner(System.in);
        Bag bagg = new Bag();
        Card[] registered_cards = new Card[4];
        registered_cards[0] = new Card("2344561034257896","07/27","987",1000);
        registered_cards[1] = new Card("3562534273648223","05/29","211",10);
        registered_cards[2] = new Card("8372425372638193","01/30","768",25);
        registered_cards[3] = new Card("9372546382938461","02/31","736",250);
        
        
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

                System.out.println("[1] Slender : the arrival");
                System.out.println("[2] Minecraft");
                System.out.println("[3] GTA VI");
                System.out.println("[4] Resident Evil : Village Edition");
                System.out.println("*************************************");
                System.out.println("[0] Go back");
                
                int mainChoice = sc.nextInt();
                sc.nextLine();
                
                if (mainChoice == 0) {
                    
                    break;
                }

                else if (mainChoice == 1) {
                    while (true) {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        Product p = new Product(1,"Slender : the arrival",Category.HORROR,"Slender Man est de retour, et encore plus terrifiant. Personne pour vous aider. Personne pour vous entendre crier. Replongez-vous dans l'horreur et découvrez des graphismes améliorés de survival-horror à l'occasion des 10 ans du jeu.",20);
                        System.out.println("---------" + p.getName() + "---------");
                        System.out.println("Category: " + p.getCategory());
                        System.out.println("Description: " + p.getDescription());
                        System.out.println("Price: $" + p.getPrice());

                        System.out.println("[0] Go back ---- [1] Add to Bag");
                        int checkoutChoice = sc.nextInt();
                        sc.nextLine();
                       
                        if (checkoutChoice == 0) {
                            
                            break;
                        }

                        else if (checkoutChoice == 1) {
                            while (true) {
                                if (bagg.Product_Is_Not_In(p)) {
                                    bagg.addProduct(p);
                                } else {
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("Product: " +p.getName() + " is already in the bag!");
                                    try {
                                        Thread.sleep(2000);
                                    } catch (InterruptedException e) {
                                        Thread.currentThread().interrupt();
                                    }
                                    
                                    break;
                                }
                                
                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                System.out.println("Product: " +p.getName() + " has been added!");
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
                        Product p = new Product(2,"Minecraft",Category.ADVENTURE,"Construisez tout ce que vous pouvez imaginer, découvrez des mystères étranges et survivez à la nuit dans ce jeu de bac à sable d’aventure ultime. Dans Minecraft, chaque partie est différente et des aventures inoubliables vous attendent à chaque coin. Explorez et fabriquez votre chemin dans un monde infini que vous pouvez façonner, un bloc à la fois.",10);
                        System.out.println("---------" + p.getName() + "---------");
                        System.out.println("Category: " + p.getCategory());
                        System.out.println("Description: " + p.getDescription());
                        System.out.println("Price: $" + p.getPrice());

                        System.out.println("[0] Go back ---- [1] Buy");
                        int buyChoice = sc.nextInt();
                        sc.nextLine();
                        if (buyChoice == 0) {
                            
                            break;
                        }

                        else if (buyChoice == 1) {
                            while (true) {
                                if (bagg.Product_Is_Not_In(p)) {
                                    bagg.addProduct(p);
                                } else {
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("Product: " +p.getName() + " is already in the bag!");
                                    try {
                                        Thread.sleep(2000);
                                    } catch (InterruptedException e) {
                                        Thread.currentThread().interrupt();
                                    }
                                    
                                    break;
                                }

                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                System.out.println("Product: " +p.getName() + " has been added!");
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
                        Product p = new Product(3,"GTA VI",Category.ADVENTURE,"Jason Duval et Lucia Caminos ont toujours baigné dans le milieu criminel et la vie ne leur a jamais été facile, malgré le soleil de la Leonida. Ils découvrent d'ailleurs la face obscure de cette région lorsque les choses tournent mal, en se retrouvant au cœur d'un complot criminel qui s'étend dans tout l'État, ce qui les obligera à compter plus que jamais l'un sur l'autre pour survivre",100);
                        System.out.println("---------" + p.getName() + "---------");
                        System.out.println("Category: " + p.getCategory());
                        System.out.println("Description: " + p.getDescription());
                        System.out.println("Price: $" + p.getPrice());

                        System.out.println("[0] Go back ---- [1] Buy");
                        int buyChoice = sc.nextInt();
                        sc.nextLine();
                        if (buyChoice == 0) {
                            
                            break;
                        }

                        else if (buyChoice == 1) {
                            while (true) {
                                if (bagg.Product_Is_Not_In(p)) {
                                    bagg.addProduct(p);
                                } else {
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("Product: " +p.getName() + " is already in the bag!");
                                    try {
                                        Thread.sleep(2000);
                                    } catch (InterruptedException e) {
                                        Thread.currentThread().interrupt();
                                    }
                                    
                                    break;
                                }

                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                System.out.println("Product: " +p.getName() + " has been added!");
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
                        Product p = new Product(4,"Resident Evil : Village Edition",Category.HORROR,"Survie et épouvante atteignent des sommets dans le 8e titre de la franchise Resident Evil : Resident Evil Village. Graphismes ultra-détaillés, action intense en vue subjective et récit palpitant : la peur n'a jamais été aussi palpable.",39.99f);
                        System.out.println("---------" + p.getName() + "---------");
                        System.out.println("Category: " + p.getCategory());
                        System.out.println("Description: " + p.getDescription());
                        System.out.println("Price: $" + p.getPrice());

                        System.out.println("[0] Go back ---- [1] Buy");
                        int buyChoice = sc.nextInt();
                        sc.nextLine();
                        if (buyChoice == 0) {
                            
                            break;
                        }

                        else if (buyChoice == 1) {
                            while (true) {
                                if (bagg.Product_Is_Not_In(p)) {
                                    bagg.addProduct(p);
                                } else {
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("Product: " +p.getName() + " is already in the bag!");
                                    try {
                                        Thread.sleep(2000);
                                    } catch (InterruptedException e) {
                                        Thread.currentThread().interrupt();
                                    }
                                    
                                    break;
                                }

                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                System.out.println("Product: " +p.getName() + " has been added!");
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
                
                System.out.println("[0] Go back ---- [1] Checkout ---- [2] Remove");
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
                
                    for (int i = 0; i<registered_cards.length;i++) {
                        if (registered_cards[i].getCardNumb().equals(cardNumber) && registered_cards[i].getExpDate().equals(expiryDate) && registered_cards[i].getCode().equals(code)) {
                            if (registered_cards[i].getBalance() >= bagg.getFullPrice()) {
                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                System.out.println("You just bought..." );
                                bagg.showProduct();
                                bagg.removeAllProducts(); 
                                found = true;
                                try {
                                    Thread.sleep(2000);
                                    break;
                                } catch (InterruptedException e) {

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
            }
        }

        else if (menuChoice == 3) {
            return;
        }

        
    }
    }
}