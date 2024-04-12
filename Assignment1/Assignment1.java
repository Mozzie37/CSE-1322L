import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {
        float totalMoney;
        float totalWeight;
        float ammountNeeded;

        Scanner in = new Scanner(System.in);
        Notes twenties=new Notes(20);
        Notes tens=new Notes(10);
        Notes fives=new Notes(5);
        Notes ones=new Notes(1);
        Coins quarters=new Coins(0.25f,0.2f);
        Coins dimes=new Coins(0.10f,0.08f);
        Coins nickels=new Coins(0.05f,0.176f);
        Coins pennies=new Coins(0.01f,0.088f);
        //putting the objects in arrays for functions
        Notes[] notes = {twenties, tens, fives, ones};
        Coins[] coins = {quarters, dimes, nickels, pennies};

        dimes.increaseQuantity(41);
        nickels.increaseQuantity(17);
        pennies.increaseQuantity(132);
        ones.increaseQuantity(33);
        fives.increaseQuantity(12);
        tens.increaseQuantity(2);
        twenties.increaseQuantity(5);


        System.out.println(twenties.toString());
        System.out.println(tens.toString());
        System.out.println(fives.toString());
        System.out.println(ones.toString());
        System.out.println(quarters.toString());
        System.out.println(dimes.toString());
        System.out.println(nickels.toString());
        System.out.println(pennies.toString());

        totalMoney = addNotes(notes) + addCoins(coins);
        totalWeight = addWeight(coins);

        System.out.println("Total Money is $" + totalMoney + " total weight is " + totalWeight + "oz");
        System.out.println("How much do you need?");

        ammountNeeded = in.nextFloat();


        //todo: finish the logic all object stuff is finished =3




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
}
