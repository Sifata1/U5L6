import java.util.Locale;
import java.util.Scanner;
public class BankApp {
    private String name;
    private String pin;
    private String shopName;
    private int inventory;
    private int price;
    private int bagelsPurchased;

    public int getBagelsPurchased() {
        return bagelsPurchased;
    }

    public void setBagelsPurchased(int bagelsPurchased) {
        this.bagelsPurchased = bagelsPurchased;
    }

    private Bank bank;
    private CreditCard card2 = new CreditCard(name,pin);
    private CreditCard card1 = new CreditCard(name,pin);

    Scanner s = new Scanner(System.in);

    public BankApp(String name, String pin, String shopName,int price) {
        Bank bank = new Bank();
        BagelShop shop = new BagelShop(shopName, inventory, price, bank);
        CreditCard cc = new CreditCard(name,pin);
        this.name = name;
        this.pin = pin;
        this.shopName = shopName;
        this.price = price;
        this.card1 = cc;
    }

    public void openSecondCC() {
        CreditCard card2 = new CreditCard(name, pin);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void menu() {
        System.out.println("Would you like to open a new credit card?");
        String a = s.nextLine();
        String a1 = a.toLowerCase();
        if (a1.equals("yes")) {
            openSecondCC();
        }

        System.out.println("Would you like to purchase a bagel?");
        String answer = s.nextLine();
        String lowercaseAns = answer.toLowerCase(Locale.ROOT);
        if (lowercaseAns.equals("yes")) {
            System.out.println("How many would you like to purchase?");
            int amtPurchased = s.nextInt();
            setBagelsPurchased(amtPurchased);
            System.out.println("Which card would you like to use to purchase them? Enter 1 or 2");
            int cardChoice = s.nextInt();
            if (cardChoice == 1) {
                card1.chargeCard(amtPurchased*price);
                System.out.println();
                System.out.println("Current Balance for Card 1: " + card1.getBalanceOwed());
                System.out.println("Current Balance for Card 2: " + card2.getBalanceOwed());
                System.out.println();
                System.out.println("Would you like to return bagels? Enter 1 for yes or enter 2 for No");
                int x = s.nextInt();
                if (x == 1) {
                    System.out.println("How many would you like to return?");
                    int y = s.nextInt();
                    if (cardChoice == 1) {
                        if (y > getBagelsPurchased()) {
                            System.out.println("You did not purchase that many bagels");
                        } else {
                            card1.reduceBalance((y)*price);
                            System.out.println("Current Balance for Card 1: " + card1.getBalanceOwed());
                        }
                    } else {
                        card2.reduceBalance((y)*price);
                        System.out.println("Current Balance for Card 2: " + card2.getBalanceOwed());
                    }

                }
            } else {
                card2.chargeCard(amtPurchased*price);
                System.out.println();
                System.out.println("Current Balance for Card 1: " + card1.getBalanceOwed());
                System.out.println("Current Balance for Card 2: " + card2.getBalanceOwed());
                System.out.println();
            }

        }
        }
    public void payment() {
        System.out.println("Do you want to make a payment to any of your cards? Enter 1 for yes or enter 2 for No");
        int a = s.nextInt();

        if (a == 1) {
            System.out.println("Which card would you like to make a payment for? Enter 1 or 2");
            int cardPayChoice = s.nextInt();
            if (cardPayChoice == 1) {
                System.out.println("How much would you like to pay?");
                int paymentAmount = s.nextInt();
                card1.reduceBalance(paymentAmount);
                System.out.println();
                System.out.println("Payment Successful! Current Balance of Card 1 is $" + card1.getBalanceOwed());
                System.out.println();
            } else {
                System.out.println("How much would you like to pay?");
                int paymentAmount = s.nextInt();
                card2.reduceBalance(paymentAmount);
                System.out.println();
                System.out.println("Payment Successful! Current Balance of Card 2 is $" + card2.getBalanceOwed());
                System.out.println();
            }

        }

        }


    }
