import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {
        float totalMoney;
        float totalWeight;
        float amountNeeded;

        //coins and notes init
        Scanner in = new Scanner(System.in);
        Notes twenties=new Notes(20);
        Notes tens=new Notes(10);
        Notes fives=new Notes(5);
        Notes ones=new Notes(1);
        Coins quarters=new Coins(0.25f,0.2f);
        Coins dimes=new Coins(0.10f,0.08f);
        Coins nickels=new Coins(0.05f,0.176f);
        Coins pennies=new Coins(0.01f,0.088f);

        //wallet init
        dimes.increaseQuantity(41);
        nickels.increaseQuantity(17);
        pennies.increaseQuantity(132);
        ones.increaseQuantity(33);
        fives.increaseQuantity(12);
        tens.increaseQuantity(2);
        twenties.increaseQuantity(5);


        //putting the objects in arrays for functions
        Notes[] notes = {twenties, tens, fives, ones};
        Coins[] coins = {quarters, dimes, nickels, pennies};

        //wallet print
        System.out.println(twenties.toString());
        System.out.println(tens.toString());
        System.out.println(fives.toString());
        System.out.println(ones.toString());
        System.out.println(quarters.toString());
        System.out.println(dimes.toString());
        System.out.println(nickels.toString());
        System.out.println(pennies.toString());

        //getting totals for amount and weight
        totalMoney = addNotes(notes) + addCoins(coins);
        totalWeight = addWeight(coins);

        System.out.println("Total Money is $" + totalMoney + " total weight is " + totalWeight + "oz");
        System.out.println("How much do you need?");
        amountNeeded = in.nextFloat();


        while(totalMoney > .001 && amountNeeded > .001){
            if(amountNeeded >= 20 && twenties.getQuantityOnHand() > 0){
                System.out.println("Give them a $20 note.");
                twenties.decreaseQuantity(1);
                amountNeeded -= 20;
            }
            else if (amountNeeded >= 10 && tens.getQuantityOnHand() > 0){
                System.out.println("Give them a $10 note.");
                tens.decreaseQuantity(1);
                amountNeeded -= 10;
            }
            else if(amountNeeded >= 5 && fives.getQuantityOnHand() > 0){
                System.out.println("Give them a $5 note.");
                fives.decreaseQuantity(1);
                amountNeeded -= 5;
            }
            else if (amountNeeded >= 1 && ones.getQuantityOnHand() > 0){
                System.out.println("Give them a $1 note.");
                ones.decreaseQuantity(1);
                amountNeeded -= 1;
            }
            else if (amountNeeded >= .25 && quarters.getQuantityOnHand() > 0){
                System.out.println("Give them a quarter.");
                quarters.decreaseQuantity(1);
                amountNeeded -= .25f;

            }
            else if (amountNeeded >= .1 && dimes.getQuantityOnHand() > 0){
                System.out.println("Give them a dime.");
                dimes.decreaseQuantity(1);
                amountNeeded -= .1f;
            }
            else if (amountNeeded >= .05 && nickels.getQuantityOnHand() > 0){
                System.out.println("Give them a nickel.");
                nickels.decreaseQuantity(1);
                amountNeeded -= .05f;
            }
            else if (amountNeeded >= .01 && pennies.getQuantityOnHand() > 0){
                System.out.println("Give them a penny.");
                pennies.decreaseQuantity(1);
                amountNeeded -= .01f;
            }
            totalMoney = addNotes(notes) + addCoins(coins);
        }
        //not wasting cycles in the loop continuing to calculate weight, so fixing the total after the fact.
        totalWeight = addWeight(coins);
        //if we need to print the "you broke" statement
        if(amountNeeded > .001){
            System.out.println("I don't have enough money. I still owe you $" + printPretty(amountNeeded));
        }
        //final statement
        System.out.println("I have $" + printPretty(totalMoney) + " left, it's total weight is " + printPretty(totalWeight) + "oz");

    }
    static float addNotes(Notes[] notes){
        float total = 0;

        for(int i = 0; i < notes.length; i++){
            total += notes[i].getTotalValue();
        }
        return total;
    }
    static float addCoins(Coins[] coins){
        float total = 0;

        for(int i = 0; i < coins.length; i++){
            total += coins[i].getTotalValue();
        }
        return total;
    }
    static float addWeight(Coins[] coins){
        float total = 0;

        for(int i = 0; i < coins.length; i++){
            total += coins[i].getTotalWeight();
        }
        return total;

    }
    static String printPretty(float amount){
        return(String.format("%4.2f",amount));
    }
}
