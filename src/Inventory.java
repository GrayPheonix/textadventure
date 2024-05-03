import java.util.ArrayList;
public class Inventory {
    //there will only ever be one inventory, so make the constructor private,
    //declare that instance of Inventory, and then let everyone access that instance (AKA singleton class)
    private static Inventory playerInventory; //playerInventory is the instance of Inventory
    private Inventory(){}

    public static Inventory getPlayerInventory(){
        if (playerInventory == null){
            playerInventory = new Inventory();
        }
        return playerInventory;
    }

    //variables
    protected ArrayList<Item> inventory = new ArrayList<Item>(); //inventory is an array of Items
    protected int maxInventorySize = 20; //config

    //get methods
    public ArrayList<Item> getInventory(){ return inventory; }
    public int getInventorySize(){ return inventory.size(); }
    //returns the first Item that matches the type
    public Item getItem(String targetType){
        for (Item item : inventory){
            if (item.getType().equals(targetType))
                return item;
        }
        System.out.println("You do not have any " + targetType + ".");
        return null;
    }
    //returns the Item at the index
    public Item getIndex(int index){ return inventory.get(index); }
    //this does the same thing as the total var in Item
    public int getHowMany(Item targetItem){
        String targetType = targetItem.getType();
        int count = 0;
        for (Item item : inventory){
            if (item.getType().equals(targetType)){
                count++;
            }
        }
        return count;
    }
    //get the type of an item in a certain index?
    //get the indexes of a type of item?

    //set methods
    public void add(Item item){
        if (!item.canPickUp){
            System.out.println("That item cannot be picked up.");
        }else if(inventory.size() + 1 > maxInventorySize) {
            System.out.println("Your inventory is full.");
        }else{
            inventory.add(item); //lowercase inventory is the instance
            item.changeTotalBy(1);
        }
    }
    public void drop(Item item){
        if (inventory.contains(item)){
            inventory.remove(item); //lowercase inventory is the instance
        }else{
            System.out.println("You have no " + item.toString() + " in your inventory.");
        }
        //change the total
        item.changeTotalBy(-1);
    }
    //changing the order of the inventory?
    public void clear(){
        inventory.clear();
    }



}
