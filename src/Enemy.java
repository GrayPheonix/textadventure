import java.util.Random;

public class Enemy{

    private Random rand = new Random();

    //Enemy Variables
    private String[] enemies = {"Wolf", "Assassin", "Golem", "Dragon"};
    private int maxEnemyHealth = 50;
    private int healthPotionDropchance = 40; //Drop percentage from enemies
    private int enemyHealth;
    private String enemyName;

    public void initiate (){
        enemyHealth = rand.nextInt(maxEnemyHealth);
        enemyName = enemies[rand.nextInt(enemies.length)];
    }
    public int getEnemyHealth(){
        return enemyHealth;
    }
    public void setEnemyHealth(int newHealth){
        enemyHealth = newHealth;
    }
    public String getEnemyName(){
        return enemyName;
    }
    public int getMaxEnemyHealth(){
        return maxEnemyHealth;
    }
    public int getHealthPotionDropchance() {
        return healthPotionDropchance;
    }
}
