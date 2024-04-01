public class Player {
    //Player Variables
    private int health = 100;
    private int attackDamage = 35;
    private int maxAttackDamage = 25;
    private int monstersDefeated;
    private int ranAwayTimes;
    private int totalPotionsDrank;

    public int getHealth() {
        return health;
    }
    public int getAttackDamage(){
        return attackDamage;
    }
    public int getMaxAttackDamage() {
        return maxAttackDamage;
    }
    public int getMonstersDefeated() {
        return monstersDefeated;
    }
    public int getRanAwayTimes() {
        return ranAwayTimes;
    }
    public int getTotalPotionsDrank() {
        return totalPotionsDrank;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }
    public void setMaxAttackDamage(int maxAttackDamage) {
        this.maxAttackDamage = maxAttackDamage;
    }

    public void addMonstersDefeated(){
        this.monstersDefeated++;
    }
    public void addRanAwayTimes(){
        this.ranAwayTimes++;
    }
    public void addTotalPotionsDrank(){
        this.totalPotionsDrank++;
    }

}
