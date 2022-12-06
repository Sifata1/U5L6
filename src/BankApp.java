import java.util.Locale;
import java.util.Scanner;
public class BankApp {
    private String name;
    private String pin;
    private String shopName;
    private int inventory;
    private int price;
    private Bank bank;
    private CreditCard card2;
    private CreditCard card1 = new CreditCard();

    Scanner s = new Scanner(System.in);

    public BankApp(String name, String pin, String shopName, int inventory, int price) {
        Bank bank = new Bank();
        BagelShop shop = new BagelShop(shopName, inventory, price, bank);
        CreditCard cc = new CreditCard(name,pin);
        this.name = name;
        this.pin = pin;
        this.shopName = shopName;
        this.inventory = inventory;
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


        System.out.println("Would you like to purchase a bagel?");
        String answer = s.nextLine();
        String lowercaseAns = answer.toLowerCase(Locale.ROOT);
        if (lowercaseAns.equals("yes")) {
            System.out.println("How many would you like to purchase?");
            int amtPurchased = s.nextInt();
            card1.chargeCard(amtPurchased);
            System.out.println("Current Balance: " + card1.getBalanceOwed());
        }


    }



}
