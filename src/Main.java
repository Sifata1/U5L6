import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("What is your name?");
        String n = s.nextLine();
        System.out.println("What do you want your pin to be?");
        String p = s.nextLine();
        System.out.println("What is your stores name?");
        String sName = s.nextLine();
        System.out.println("What is the price of a bagel?");
        int price = s.nextInt();



        BankApp app = new BankApp(n,p,sName,price);
        app.menu();
        app.payment();

        // call methods from your BankApp object to handle program logic
    }
}