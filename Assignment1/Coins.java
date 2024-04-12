public class Coins {
    private int quantityOnHand;
    private  float denomination;
    private float weight;

    //constructor
    Coins(float denomination, float weight){
        this.denomination = denomination;
        this.weight = weight;
        this.quantityOnHand = 0;
    }

    //getters
    float getTotalWeight(){
        return (this.weight * this.quantityOnHand);
    }

    float getTotalValue(){
        return(this.denomination * this.quantityOnHand);
    }

    int getQuantityOnHand(){
        return this.quantityOnHand;
    }


    //methods
    void increaseQuantity(int quantity){
        this.quantityOnHand += quantity;
    }

    void decreaseQuantity(int quantity){
        this.quantityOnHand -= quantity;
        if(this.quantityOnHand < 0){
            this.quantityOnHand = 0;
        }
    }

    String printPretty(float amount){
        return("$"+String.format("%4.2f",amount));
    }

    @Override
    public String toString(){
        String output;
        output = printPretty(this.quantityOnHand * this.denomination) + " in " + printPretty(this.denomination) + " coins.";
        return output;
    }

}
