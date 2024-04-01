import java.util.Random;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class GAME {
    Scanner in = new Scanner(System.in);
    Random rand = new Random();

    //Player Variables
    int health = 100;
    int attackDamage = 35;
    int totalHealthPotions = 3;
    int healthPotionHealing = 30;
    int healthPotionDropchance = 40; //Drop percentage from enemies
    int monstersDefeated = 0;
    int ranAwayTimes = 0;
    int potionsDrank = 0;



    public void Start() {
        boolean running = true;

        System.out.println("You have entered the Dungeon");

        GAME:
        while (true) {
            System.out.println("****************************************");

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t* " + enemy + " has appeared! *\n");

            label:
            while (enemyHealth > 0) {
                System.out.println("\t Your Health: " + health);
                System.out.println("\t" + enemy + "'s Health: " + enemyHealth);
                System.out.println("\n\tWhat will you do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink Potion");
                System.out.println("\t3. Run Away");

                String input = in.nextLine();
                switch (input) {
                    case "1" -> {
                        int damageDealt = rand.nextInt(attackDamage);
                        int damageTaken = rand.nextInt(maxAttackDamage);

                        enemyHealth -= damageDealt;
                        health -= damageTaken;

                        System.out.println("\t> You hit the " + enemy + " for " + damageDealt + " damage!");
                        System.out.println("\t> You took " + damageTaken + " points of damage!");

                        if (health < 1) {
                            System.out.println("\t> You are dead!");
                            break label;
                        }
                    }
                    case "2" -> {
                        if (totalHealthPotions > 0) {
                            health += healthPotionHealing;
                            totalHealthPotions--;
                            potionsDrank++;
                            System.out.println("\t You drank a Health Potion! You healed for " + healthPotionHealing + " points of health!" + "\n\t> You now have " + health + " HP! " + "\n\t You now have: " + totalHealthPotions + " health potions!");

                        } else {
                            System.out.println("\t You have no health potions!");
                        }
                    }
                    case "3" -> {
                        System.out.println("\t You successfully ran away from the " + enemy + "!");
                        ranAwayTimes++;
                        continue GAME;
                    }
                    default -> {
                        System.out.println("\t Nothing Happened!");
                        if (health < 1) {
                            System.out.println("\t You died!");
                            break;
                        }
                    }
                }
            }

            monstersDefeated++;
            System.out.println("****************************************");
            System.out.println(" * " + enemy + " was destroyed! *");
            System.out.println(" * You have " + health + " health remaining. * ");
            if (rand.nextInt(100) < healthPotionDropchance) {
                totalHealthPotions++;
                System.out.println(" * The " + enemy + " dropped a health potion! * ");
                System.out.println(" * You now have " + totalHealthPotions + " health potions! * ");
            }
            System.out.println("****************************************");
            System.out.println("What would you like to do?");
            System.out.println("1. Find another Monster");
            System.out.println("2. Leave the dungeon!");

            String input = in.nextLine();

            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("Nothing Happened!");
                input = in.nextLine();
            }

            if (input.equals("1")) {
                System.out.println("You search for more monsters.");
            } else {
                System.out.println("You exited the dungeon!");
            }

            System.out.println("***************************");
            System.out.println(" * Thanks For Playing! * ");
            System.out.println(" * You killed: " + monstersDefeated + " monsters!");
            System.out.println(" * You ran away: " + ranAwayTimes + " times!");
            System.out.println(" * You drank " + potionsDrank + " potions!");
            System.out.println("***************************");
        }
    }
}
