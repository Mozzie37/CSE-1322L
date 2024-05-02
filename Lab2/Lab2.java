import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        int choiceInt;
        float choiceFloat;
        boolean running = true;
        Scanner in = new Scanner(System.in);
        StockItem milk = new StockItem("1 Gallon of Milk",0,360,15);
        StockItem bread = new StockItem("1 Loaf of Bread", 1, 198, 30);

        while(running){
            System.out.println("""
                    1. Sold One Milk
                    2. Sold One Bread
                    3. Change price of Milk
                    4. Change price of Bread
                    5. Add Milk to Inventory
                    6. Add Bread to Inventory
                    7. See Inventory
                    8. Quit""");
            choiceInt = in.nextInt();
            switch(choiceInt){
                case 1:
                    milk.lowerStock(1);
                    break;
                case 2:
                    bread.lowerStock(1);
                    break;
                case 3:
                    System.out.println("What is the new price for Milk");
                    milk.setPrice(in.nextFloat());
                    break;
                case 4:
                    System.out.println("What is the new price for Bread");
                    bread.setPrice(in.nextFloat());
                    break;
                case 5:
                    System.out.println("How many milk did we get?");
                    milk.raiseStock(in.nextInt());
                    break;
                case 6:
                    System.out.println("How many bread did we get?");
                    bread.raiseStock(in.nextInt());
                    break;
                case 7:
                    System.out.println(milk);
                    System.out.println(bread);
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.err.println("ERROR: INVALID ENTRY. TRY AGAIN.");
            }
        }
    }
}
