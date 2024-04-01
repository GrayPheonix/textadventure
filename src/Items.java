import java.util.ArrayList; //needed for inventory

public class Items{
    //this is only needed once there are more than one thing to pick up
    //aka inventory update lmao
    //private ArrayList<String> inventory = new ArrayList<String>();

    //total in possession at time called, not total overall
    private int totalHealthPotions;

    //customizable. Should probably not change mid-game?
    private int healthPotionHealing = 30;

    /* see above: inventory update
    public ArrayList<String> getInventory(){
        return inventory;
    }
    */
    public int getTotalHealthPotions(){
        return totalHealthPotions;
    }

    //could be smushed into one method but idk whether to do it
    //by using setHealth or by using negative potions
    public void addPotion (int potions){
        totalHealthPotions += potions;
        //inventory.add(healthPotion); see above: inventory update
    }
    public void minusPotion(int potions){
        totalHealthPotions -= potions;
    }
    public int getHealthPotionHealing(){
        return healthPotionHealing;
    }

}
