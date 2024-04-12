public class Notes {
    private int quantityOnHand;
    private int denomination;

    //constructor
    Notes(int denomination){
        this.denomination = denomination;
        this.quantityOnHand = 0;
    }

    //getters
    int getTotalValue(){
        return (this.denomination * this.quantityOnHand);
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
        output = printPretty(this.quantityOnHand * this.denomination) + " in " + printPretty(this.denomination) + " notes.";
        return output;
    }

}
