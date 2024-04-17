public class HealingPotion extends Item{

    //variables
    private int healthPotionHealing = 30; //config
    private int total; //total number of health potions
    Player player = Player.getPlayer(); //get the player instance

    //constructors
    HealingPotion(){
        super.type = "healingPotion"; //type as defined in HealingPotion
        super.canPickUp = true; //canPickUp as defined in HealingPotion
    }

    //get methods
    public int getHealthPotionHealing(){ return healthPotionHealing; }
    int getTotal() { return total; }

    //set methods
    public void setHealthPotionHealing(int healthPotionHealing) {
        this.healthPotionHealing = healthPotionHealing;
    }
    public void changeTotalBy(int change){
        total = total + change;
    }

    //use methods
    public void use(){
        //increase player's health
        player.setHealth(player.getHealth() + healthPotionHealing);
        //add to lifetime stat
        player.addTotalPotionsDrank();
        //subtract from the number of health potions the player has
        total--;
    }


}
