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

    public void Start() {
        boolean running = true; //is this used?

        //could let the person name the player?
        Player player = new Player();
        System.out.println("You have entered the Dungeon");

        GAME:
        while (true) {
            System.out.println("****************************************");

            //right now the only thing you can do is fight so an enemy gets
            //generated right off the bat. If other stuff becomes possible then
            //the combat event would become another class, I think.
            Enemy enemy = new Enemy();
            enemy.initiate();

            //this is not the inventory. This is so methods from Items can be called.
            //Items would be made static? if Inventory is added and this would be unnecessary.
            Items items = new Items();

            System.out.println("\t* " + enemy.getEnemyName() + " has appeared! *\n");

            //combat options
            label:
            while (enemy.getEnemyHealth() > 0) {
                System.out.println("\t Your Health: " + player.getHealth());
                System.out.println("\t" + enemy.getEnemyName() + "'s Health: " + enemy.getEnemyHealth());
                System.out.println("\n\tWhat will you do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink Potion");
                System.out.println("\t3. Run Away");
                String input = in.nextLine();
                switch (input) {
                    case "1" -> { //attack
                        int damageDealt = rand.nextInt(player.getAttackDamage());
                        int damageTaken = rand.nextInt(player.getMaxAttackDamage());

                        enemy.setEnemyHealth(enemy.getEnemyHealth()-damageDealt);
                        player.setHealth(player.getHealth()-damageTaken);

                        System.out.println("\t> You hit the " + enemy.getEnemyName() + " for " + damageDealt + " damage!");
                        System.out.println("\t> You took " + damageTaken + " points of damage!");

                        if (player.getHealth() < 1) {
                            System.out.println("\t> You are dead!");
                            break label;
                        }
                    }
                    case "2" -> { //use potion
                        if (items.getTotalHealthPotions() > 0) {
                            //change player health
                            player.setHealth(player.getHealth()+items.getHealthPotionHealing());
                            //remove a potion from the player
                            items.minusPotion(1);
                            //add to the lifetime stat
                            player.addTotalPotionsDrank();
                            System.out.println("\t You drank a Health Potion! " +
                                    "You healed for " + items.getHealthPotionHealing() + " points of health!" +
                                    "\n\t> You now have " + player.getHealth() + " HP! " +
                                    "\n\t You now have: " + items.getTotalHealthPotions() + " health potions!");
                        } else {
                            System.out.println("\t You have no health potions!");
                        }
                    }
                    case "3" -> {
                        System.out.println("\t You successfully ran away from the " + enemy + "!");
                        player.addRanAwayTimes(); //add to lifetime stat
                        continue GAME;
                    }
                    default -> {
                        System.out.println("\t Nothing Happened!");
                        if (player.getHealth() < 1) {
                            System.out.println("\t You died!");
                        }
                    }
                }
            }

            player.addMonstersDefeated(); //add to lifetime stat
            System.out.println("****************************************");
            System.out.println(" * " + enemy.getEnemyName() + " was destroyed! *");
            System.out.println(" * You have " + player.getHealth() + " health remaining. * ");
            if (rand.nextInt(100) < enemy.getHealthPotionDropchance()) {
                items.addPotion(1);
                System.out.println(" * The " + enemy + " dropped a health potion! * ");
                System.out.println(" * You now have " + items.getTotalHealthPotions() + " health potions! * ");
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
            System.out.println(" * You killed: " + player.getMonstersDefeated() + " monsters!");
            System.out.println(" * You ran away: " + player.getRanAwayTimes() + " times!");
            System.out.println(" * You drank " + player.getTotalPotionsDrank() + " potions!");
            System.out.println("***************************");
        }
    }
}
