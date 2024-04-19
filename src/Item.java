public abstract class Item{
    //variables
    protected String type; //the type of item
    protected boolean canPickUp; //can the item be picked up by the player

    //constructors
    public Item(String type, boolean canPickUp){
        this.type = type;
        this.canPickUp = canPickUp;
    }
    public Item(){}

    //get methods
    public String getType(){ return type; }
    public boolean getCanPickUp(){ return canPickUp; }

    //set methods
    public void setType(String type){ this.type = type; }
    public void setCanPickUp(boolean canPickUp){ this.canPickUp = canPickUp; }

    //abstract methods
    abstract void use();
    abstract int getTotal(); //total in possession at time called, not total overall
    abstract void changeTotalBy (int change); //change the total in possession
}
