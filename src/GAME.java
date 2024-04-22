import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class GAME implements ActionListener {
    Random rand = new Random();

    ArrayList<Object> arrayList = new ArrayList<>();
    //Enemy Variables
    String[] enemies = {"Wolf", "Assassin", "Golem", "Dragon"};
    int maxEnemyHealth = 50;
    int maxAttackDamage = 25;

    //Player Variables
    int health = 100;
    int attackDamage = 35;
    int totalHealthPotions = 3;
    int healthPotionHealing = 30;
    int healthPotionDropchance = 40; //Drop percentage from enemies
    int monstersDefeated = 0;
    int ranAwayTimes = 0;
    int potionsDrank = 0;
    int goldDrop = 15;
    int totalGold = 0;
    int gold = 0;

    Insets insets;

    JLabel l = new JLabel();
    JLabel l2 = new JLabel();
    JLabel l3 = new JLabel();
    JLabel l4 = new JLabel();
    JLabel l5 = new JLabel();
    JLabel l6 = new JLabel();
    JLabel l7 = new JLabel();
    JLabel l8 = new JLabel();
    JLabel l9 = new JLabel();
    JLabel l10 = new JLabel();
    JButton a = new JButton("> 1. Attack");
    JButton d = new JButton("> 2. Drink Potion");
    JButton r = new JButton("> 3. Run Away");
    JButton f = new JButton("> 1. Find another Monster");
    JButton le = new JButton("> 2. Leave The dungeon!");
    JButton s = new JButton("> 3. Upgrade your sword!");

    public void GUI(){
        JFrame j = new JFrame();
        j.setTitle("Dungeon Run");
        j.setLocationRelativeTo(null);
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLayout(null);
        j.setSize(1000, 600);
        j.setBackground(Color.BLACK);

        JTextField t = new JTextField();
        t.setSize(1000,600);
        t.setBackground(Color.BLACK);
        t.setForeground(Color.BLACK);
        j.add(t);
        t.setText(null);

        Font font = new Font("Serif",0 , 50);

        l.setBorder(null);
        l.setBounds(10,10,980,50);
        l.getPreferredSize();
        l.setHorizontalAlignment(JLabel.RIGHT);
        l.setFont(font);
        l.setForeground(new Color(250, 231, 110));
        l.isVisible();
        l.setVisible(true);
        l2.setBorder(null);
        l2.setBounds(10,70,980,50);
        l2.getPreferredSize();
        l2.setHorizontalAlignment(JLabel.RIGHT);
        l2.setFont(font);
        l2.setForeground(new Color(250, 231, 110));
        l2.isVisible();
        l2.setVisible(true);
        l3.setBorder(null);
        l3.setBounds(10,130,980,50);
        l3.getPreferredSize();
        l3.setHorizontalAlignment(JLabel.RIGHT);
        l3.setFont(font);
        l3.setForeground(new Color(250, 231, 110));
        l3.isVisible();
        l3.setVisible(true);
        l4.setBorder(null);
        l4.setBounds(10,190,980,50);
        l4.getPreferredSize();
        l4.setHorizontalAlignment(JLabel.RIGHT);
        l4.setFont(font);
        l4.setForeground(new Color(250, 231, 110));
        l4.isVisible();
        l4.setVisible(true);
        l5.setBorder(null);
        l5.setBounds(10,250,980,50);
        l5.getPreferredSize();
        l5.setHorizontalAlignment(JLabel.RIGHT);
        l5.setFont(font);
        l5.setForeground(new Color(250, 231, 110));
        l5.isVisible();
        l5.setVisible(true);
        l6.setBorder(null);
        l6.setBounds(10,310,980,50);
        l6.getPreferredSize();
        l6.setHorizontalAlignment(JLabel.RIGHT);
        l6.setFont(font);
        l6.setForeground(new Color(250, 231, 110));
        l6.isVisible();
        l6.setVisible(true);
        l7.setBorder(null);
        l7.setBounds(10,370,980,50);
        l7.getPreferredSize();
        l7.setHorizontalAlignment(JLabel.RIGHT);
        l7.setFont(font);
        l7.setForeground(new Color(250, 231, 110));
        l7.isVisible();
        l7.setVisible(true);
        l8.setBorder(null);
        l8.setBounds(10,430,980,50);
        l8.getPreferredSize();
        l8.setHorizontalAlignment(JLabel.RIGHT);
        l8.setFont(font);
        l8.setForeground(new Color(250, 231, 110));
        l8.isVisible();
        l8.setVisible(true);
        l9.setBorder(null);
        l9.setBounds(10,490,980,50);
        l9.getPreferredSize();
        l9.setHorizontalAlignment(JLabel.RIGHT);
        l9.setFont(font);
        l9.setForeground(new Color(250, 231, 110));
        l9.isVisible();
        l9.setVisible(true);
        l10.setBorder(null);
        l10.setBounds(10,550,980,50);
        l10.getPreferredSize();
        l10.setHorizontalAlignment(JLabel.RIGHT);
        l10.setFont(font);
        l10.setForeground(new Color(250, 231, 110));
        l10.isVisible();
        l10.setVisible(true);

        a.setBorder(null);
        a.setBounds(10,250,980,50);
        a.getPreferredSize();
        a.setHorizontalAlignment(JLabel.RIGHT);
        a.setFont(font);
        a.setForeground(new Color(250, 231, 110));
        d.setBorder(null);
        d.setBounds(10,310,980,50);
        d.getPreferredSize();
        d.setHorizontalAlignment(JLabel.RIGHT);
        d.setFont(font);
        d.setForeground(new Color(250, 231, 110));
        r.setBorder(null);
        r.setBounds(10,370,980,50);
        r.getPreferredSize();
        r.setHorizontalAlignment(JLabel.RIGHT);
        r.setFont(font);
        r.setForeground(new Color(250, 231, 110));
        f.setBorder(null);
        f.setBounds(10,430,980,50);
        f.getPreferredSize();
        f.setHorizontalAlignment(JLabel.RIGHT);
        f.setFont(font);
        f.setForeground(new Color(250, 231, 110));
        le.setBorder(null);
        le.setBounds(10,490,980,50);
        le.getPreferredSize();
        le.setHorizontalAlignment(JLabel.RIGHT);
        le.setFont(font);
        le.setForeground(new Color(250, 231, 110));
        s.setBorder(null);
        s.setBounds(10,550,980,50);
        s.getPreferredSize();
        s.setHorizontalAlignment(JLabel.RIGHT);
        s.setFont(font);
        s.setForeground(new Color(250, 231, 110));

        j.isVisible();
        j.setVisible(true);
        j.isEnabled();
    }

    public static void typewriterEffect(JLabel label, String str) {
        String temp = "";
        for(int i = 0; i<str.length(); i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            temp = str.substring(0,i);
            label.setText(temp);
        }
        label.setText(str);
    }

    public void actionPerformed(ActionEvent e) {
        e.getSource();
        arrayList.add(e);
        l.setText("");
        l2.setText("");
        l3.setText("");
        l4.setText("");
        l5.setText("");
        l6.setText("");
        l7.setText("");
        l8.setText("");
        l9.setText("");
    }

    public void Start() {
        boolean running = true;
        GUI();
        typewriterEffect(l, "> You have entered the Dungeon");

        GAME:
        while (true) {
            typewriterEffect(l2,"****************************************");
            l.setText("");
            l2.setText("");
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            typewriterEffect(l,"> * " + enemy + " has appeared! *");

            label:
            while (enemyHealth > 0) {
                typewriterEffect(l2,"> Your Health: " + health);
                typewriterEffect(l3,"> " + enemy + "'s Health: " + enemyHealth);
                typewriterEffect(l4,"> What will you do?");
                a.setVisible(true);
                typewriterEffect(l5,a.getText());
                d.setVisible(true);
                typewriterEffect(l6,d.getText());
                r.setVisible(true);
                typewriterEffect(l7,r.getText());


                if (arrayList.contains(a)) {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(maxAttackDamage);
                    enemyHealth -= damageDealt;
                    health -= damageTaken;
                    typewriterEffect(l,"> You hit the " + enemy + " for " + damageDealt + " damage!");
                    typewriterEffect(l2,"> You took " + damageTaken + " points of damage!");
                    if (health < 1) {
                        typewriterEffect(l3,"> You are dead!");
                        break;
                    }
                } else if (arrayList.contains(d)) {
                    if (totalHealthPotions > 0) {
                        health += healthPotionHealing;
                        --totalHealthPotions;
                        ++potionsDrank;
                        typewriterEffect(l,"> You drank a Health Potion! You healed for " + healthPotionHealing + " points of health!");
                        typewriterEffect(l2,"> You now have " + health + " HP!");
                        typewriterEffect(l3,"> You now have: " + totalHealthPotions + " health potions!");
                    } else {
                        typewriterEffect(l,"> You have no health potions!");
                    }
                } else {
                    if (arrayList.contains(r)) {
                        typewriterEffect(l,"> You successfully ran away from the " + enemy + "!");
                        ++ranAwayTimes;
                        continue GAME;
                    }
                    typewriterEffect(l2,"> Nothing happened!");
                }
            }

            monstersDefeated++;
            ++totalGold;
            typewriterEffect(l,"****************************************");
            typewriterEffect(l2,"> * " + enemy + " was destroyed! *");
            typewriterEffect(l3,"> * You have " + health + " health remaining. * ");
            typewriterEffect(l4," * You now have " + totalGold + " gold! * ");
            if (rand.nextInt(100) < healthPotionDropchance) {
                totalHealthPotions++;
                typewriterEffect(l4,"> * The " + enemy + " dropped a health potion! * ");
                typewriterEffect(l5,"> * You now have " + totalHealthPotions + " health potions! * ");
            }
            typewriterEffect(l6,"****************************************");
            typewriterEffect(l7,"> What would you like to do?");
            f.setVisible(true);
            typewriterEffect(l8,f.getText());
            le.setVisible(true);
            typewriterEffect(l9,le.getText());
            s.setVisible(true);
            typewriterEffect(l10,s.getText());


            if (arrayList.contains(f)) {
                typewriterEffect(l,"> You search for more monsters.");
            } else {
                typewriterEffect(l,"> You exited the dungeon!");
            }
            l.setText("");
            l2.setText("");
            l3.setText("");
            l4.setText("");
            l5.setText("");
            l6.setText("");
            l7.setText("");
            l8.setText("");
            l9.setText("");

            typewriterEffect(l,"***************************");
            typewriterEffect(l2,"> * Thanks For Playing! * ");
            typewriterEffect(l3,"> * You killed: " + monstersDefeated + " monsters!");
            typewriterEffect(l4,"> * You ran away: " + ranAwayTimes + " times!");
            typewriterEffect(l5,"> * You drank " + potionsDrank + " potions!");
            typewriterEffect(l6,"***************************");
        }
    }
}