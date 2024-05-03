import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GAME {
    public Random rand = new Random();
    public ArrayList<Object> arrayList = new ArrayList<>();
    public String[] enemies = {"Wolf", "Assassin", "Golem", "Dragon"};
    public static JLabel[] labels = new JLabel[10];
    public JButton[] buttons = new JButton[10];
    public JFrame frame;
    public JTextArea textArea;
    public int choice;
    public int inventoryTemp; //temp var needed for the inventory menu to work
    public int inventoryIndex; //used to pop up the right item clicked in inventory
    public int inventoryChoice; //used to choose what to do after an item is clicked in inventory
    public int maxEnemyHealth = 50;
    public int maxAttackDamage = 25;

    //Player Variables
    Inventory inventory = Inventory.getPlayerInventory();

    public int health = 100;
    public int attackDamage = 35;
    public int totalHealthPotions = 3;
    public int healthPotionHealing = 30;
    public int healthPotionDropchance = 40; //Drop percentage from enemies
    public int monstersDefeated = 0;
    public int ranAwayTimes = 0;
    public int potionsDrank = 0;
    public int goldDrop = 15;
    public int totalGold = 0;
    public int i;
    public int gold = 0;
    boolean running = true;

    public GAME() {
        createGUI();
        Start(false);
    }

    private void createGUI() {
        frame = new JFrame("Dungeon Run");
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);
        panel.setBackground(Color.BLACK);

        Font font = new Font("Serif", Font.PLAIN, 20);
        int yOffset = 10;

        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel("");
            labels[i].setBounds(10, yOffset + i * 40, 980, 30);
            labels[i].setHorizontalAlignment(SwingConstants.LEFT);
            labels[i].setFont(font);
            labels[i].setForeground(new Color(250, 231, 110));
            labels[i].setBackground(Color.black);
            labels[i].setOpaque(true);
            panel.add(labels[i]);
        }

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(font);
            buttons[i].setHorizontalAlignment(SwingConstants.LEFT);
            buttons[i].setForeground(new Color(250, 231, 110));
            buttons[i].setBackground(Color.BLACK);
            buttons[i].setVisible(false);
            buttons[i].setBounds(10, yOffset + i * 40, 980, 30);
            panel.add(buttons[i]);
        }

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(font);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void addButton(String text, int index, ActionListener listener) {
        buttons[index].addActionListener(listener);
        buttons[index].setText(text);
        buttons[index].setVisible(true);
        typewriterEffect(text, index);
    }

    private void removeButtons() {
        for (JButton button : buttons) {
            button.setVisible(false);
        }
    }

    public static void typewriterEffect(String str, int index) {
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            temp = str.substring(0, i);
            labels[index].setText(temp);
        }
        labels[index].setText(str);
        try {
            Thread.sleep(500); // Wait for a bit after displaying each line
        } catch (InterruptedException ignored) {
        }
    }

    private void clearLabels() {
        for (JLabel label : labels) {
            label.setText("");
        }
    }

    public void Start(boolean b) {
        typewriterEffect("> You have entered the Dungeon", 0);
        typewriterEffect("****************************************", 1);

        GAME:
        while (running) {
            clearLabels();
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            typewriterEffect("> * " + enemy + " has appeared! *", 0);
            typewriterEffect("> Your Health: " + health, 1);
            typewriterEffect("> " + enemy + "'s Health: " + enemyHealth, 2);
            typewriterEffect("> What would you like to do?", 3);

            addButton("> 1. Attack", 4, e -> {
                choice = 1;
                removeButtons();
                clearLabels();
            }); //choice = 1

            addButton("> 2. Drink Potion", 5, e -> {
                choice = 2;
                removeButtons();
                clearLabels();
            }); //choice = 2

            addButton("> 3. Run Away", 6, e -> {
                choice = 3;
                removeButtons();
                clearLabels();
            }); //choice = 3

            addButton("> 4. Check Inventory", 7, e -> {
                choice = 7; //I think this isn't used?
                removeButtons();
                clearLabels();
            }); //choice = 7

            waitForAction();

            if (choice == 1) {
                while (enemyHealth > 0 && health > 0) {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(maxAttackDamage);
                    enemyHealth -= damageDealt;
                    health -= damageTaken;
                    typewriterEffect("> You hit the " + enemy + " for " + damageDealt + " damage!", 0);
                    typewriterEffect("> You took " + damageTaken + " points of damage!", 1);
                    if (health <= 0) {
                        typewriterEffect("> You are dead!", 2);
                        break GAME; // End the game loop if the player dies
                    }
                    if (enemyHealth <= 0) {
                        monstersDefeated++;
                        totalGold = totalGold + 5;
                        choice = 4;
                    }
                    typewriterEffect("> Your Health: " + health, 2);
                    typewriterEffect("> " + enemy + "'s Health: " + enemyHealth, 3);
                    clearLabels();

                }
            } //Attack

            if (choice == 2) {
                if (totalHealthPotions > 0) {
                    health += healthPotionHealing;
                    --totalHealthPotions;
                    ++potionsDrank;
                    typewriterEffect("> You drank a Health Potion! You healed for " + healthPotionHealing + " points of health!", 0);
                    typewriterEffect("> You now have " + health + " HP!", 1);
                    typewriterEffect("> You now have: " + totalHealthPotions + " health potions!", 2);
                } else {
                    typewriterEffect("> You have no health potions!", 0);
                }
            } //Drink potion

            if (choice == 7) {
                textArea.setText("");
                typewriterEffect("> Inventory: ", 0);
                for (int i = 0; i < inventory.getInventorySize(); i++) {
                    inventoryTemp = i;
                    addButton("> " + (i + 1) + ". " + inventory.getIndex(i).toString(), i, e -> {
                        inventoryIndex = inventoryTemp;
                        removeButtons();
                        clearLabels();
                    });
                }
                addButton("> Back", inventory.getInventorySize() - 1, e -> {
                    choice = 8; //to get caught in the else on line 248?
                    removeButtons();
                    clearLabels();
                });
                if (choice != 8) { //skip this if > Back is clicked
                    typewriterEffect("> What do you want to do with " + inventory.getIndex(inventoryIndex).toString() + " ?", 0);
                    //TODO if we even get here then we want Drop, Use, and Back as options
                    //note: remember to add waitForAction()

                }
            } //Check inventory

            if (choice == 3) {
                if (totalHealthPotions > 0) {
                    typewriterEffect("> You successfully ran away from the " + enemy + "!", 0);
                    ++ranAwayTimes;
                    clearLabels();
                    // Set choice to a value that corresponds to the next screen options
                    choice = 4; // Assuming choice 4 represents the screen with options to search for monsters, exit the dungeon, and upgrade attack
                } else {
                    typewriterEffect("> You cannot run away without health potions!", 0);

                }
            } //Run away

            if (enemyHealth <= 0) {
                typewriterEffect("> * " + enemy + " was destroyed! *", 0);
                typewriterEffect("> * You have " + health + " health remaining. * ", 1);
                typewriterEffect("> * You now have " + totalGold + " gold! * ", 2);
                if (rand.nextInt(100) < healthPotionDropchance) {
                    totalHealthPotions++;
                    typewriterEffect("> * The " + enemy + " dropped a health potion! * ", 3);
                    typewriterEffect("> * You now have " + totalHealthPotions + " health potions! * ", 4);
                }
                typewriterEffect("****************************************", 5);
            } else { //this gets triggered when main menu choice is "else" and enemyHealth > 0
                typewriterEffect("> What would you like to do?", 6);

                addButton("> 1. Search for more Monsters", 7, e -> {
                    choice = 4;
                    removeButtons();
                    clearLabels();
                }); //choice = 4

                addButton("> 2. Exit the Dungeon", 8, e -> {
                    choice = 5;
                    removeButtons();
                    clearLabels();
                }); //choice = 5

                addButton("> 3. Upgrade Attack", 9, e -> {
                    choice = 6;
                    removeButtons();
                    clearLabels();
                }); //choice = 6

                waitForAction();

                if (choice == 5) {
                    typewriterEffect("***************************", 0);
                    typewriterEffect("> * Thanks For Playing! * ", 1);
                    typewriterEffect("> * You killed: " + monstersDefeated + " monsters!", 2);
                    typewriterEffect("> * You ran away: " + ranAwayTimes + " times!", 3);
                    typewriterEffect("> * You drank " + potionsDrank + " potions!", 4);
                    typewriterEffect("***************************", 5);
                    try {
                        Thread.sleep(10000); // Wait for 10 seconds
                    } catch (InterruptedException ignored) {
                    }
                    System.exit(0); // Exit the program
                } //Exit the dungeon

                if (choice == 4) {
                    typewriterEffect("> You search for more monsters.", 0);
                    clearLabels();
                    continue;
                } //Search for more monsters

                if (choice == 6) {
                    if (totalGold >= 10) {
                        attackDamage += attackDamage + 10;
                        totalGold += totalGold - 10;
                        typewriterEffect("> Your Attack Damage is now" + attackDamage, 0);
                        clearLabels();
                        continue;
                    } else {
                        typewriterEffect("> You don't have enough gold!", 0);
                        clearLabels();
                        continue;
                    }
                } //Upgrade attack

                break;
            }

            typewriterEffect("> What would you like to do?", 6);

            addButton("> 1. Search for more Monsters", 7, e -> {
                choice = 4;
                removeButtons();
                clearLabels();
            });

            addButton("> 2. Exit the Dungeon", 8, e -> {
                choice = 5;
                removeButtons();
                clearLabels();
            });

            addButton("> 3. Upgrade Attack", 9, e -> {
                choice = 6;
                removeButtons();
                clearLabels();
            });

            waitForAction();

            if (choice == 5) {
                typewriterEffect("***************************", 0);
                typewriterEffect("> * Thanks For Playing! * ", 1);
                typewriterEffect("> * You killed: " + monstersDefeated + " monsters!", 2);
                typewriterEffect("> * You ran away: " + ranAwayTimes + " times!", 3);
                typewriterEffect("> * You drank " + potionsDrank + " potions!", 4);
                typewriterEffect("***************************", 5);
                try {
                    Thread.sleep(10000); // Wait for 10 seconds
                } catch (InterruptedException ignored) {
                }
                System.exit(0); // Exit the program
            }

            if (choice == 4) {
                typewriterEffect("> You search for more monsters.", 0);
                clearLabels();
                continue;
            } else if (choice == 6 && totalGold >= 10) {
                attackDamage += attackDamage + 10;
                totalGold += totalGold - 10;
                typewriterEffect("> Your Attack Damage is now " + attackDamage, 0);
                clearLabels();
                continue;
            } else if (choice == 6 && totalGold < 10) {
                typewriterEffect("> You don't have enough gold!", 0);
                clearLabels();
                continue;
            }

            break;
        }
    }
    private void waitForAction() {
        // Reset choice before waiting for a new action
        choice = 0;

        // Wait until a button is clicked
        while (choice == 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}