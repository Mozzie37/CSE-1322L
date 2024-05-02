public class StockItem {
    private String description;
    private int id;
    private int price; //stored as pennies
    private int quantity;


    StockItem(){
        this.description = "Default description";
        this.id = -1;
        this.price = 0;
        this.quantity = 0;
    }
    StockItem(String description, int id, int price, int quantity){
        this.description = description;
        this.id = id;
        this.price = Math.max(price, 0);
        this.quantity = Math.max(quantity, 0);
    }

    //setters

    public void setPrice(float price) {
        if(price < 0){
            System.err.println("PRICE CANNOT BE NEGATIVE!");
        }
        else{
            this.price = (int) (price * 100);
        }
    }

    public void raiseStock(int raiseBy){
        this.quantity += raiseBy;
    }

    public void lowerStock(int lowerBy){
        if(this.quantity - lowerBy < 0){
            System.err.println("QUANTITY CANNOT BE NEGATIVE!");
        }
        else{
            this.quantity -= lowerBy;
        }
    }

    //getters

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public float getPrice(){
        return priceToFloat();
    }

    public int getQuantity() {
        return quantity;
    }

    //methods

    @Override
    public String toString() {
        String output;
        output = String.format("""
                Description: %1$s
                ID: %2$d
                Price: $%3$.2f
                Quantity: %4$d
                """, this.description, this.id, priceToFloat(), this.quantity);
        return output;
    }
    float priceToFloat(){
        return  ((float)this.price/100);
    }
}
