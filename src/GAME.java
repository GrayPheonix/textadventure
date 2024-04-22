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

    JLabel l = new JLabel("");
    JLabel l2 = new JLabel("");
    JLabel l3 = new JLabel("");
    JLabel l4 = new JLabel("");
    JLabel l5 = new JLabel("");
    JLabel l6 = new JLabel("");
    JLabel l7 = new JLabel("");
    JLabel l8 = new JLabel("");
    JLabel l9 = new JLabel("");
    JLabel l10 = new JLabel("");
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
        j.setForeground(Color.BLACK);

        JTextField t = new JTextField();
        t.setSize(1000,600);
        t.setBackground(Color.BLACK);
        t.setForeground(Color.BLACK);
        j.add(t);
        t.setText(null);

        Font font = new Font("Serif",0 , 30);

        l.setBorder(null);
        l.setBounds(10,10,980,30);
        l.setHorizontalAlignment(SwingConstants.LEFT);
        l.setFont(font);
        l.setForeground(new Color(250, 231, 110));
        l.setBackground(Color.black);
        l.setOpaque(true);
        l.isVisible();
        l.setVisible(true);
        l.isEnabled();
        l2.setBorder(null);
        l2.setBounds(10,70,980,30);
        l2.setHorizontalAlignment(SwingConstants.LEFT);
        l2.setFont(font);
        l2.setForeground(new Color(250, 231, 110));
        l2.setBackground(Color.black);
        l2.setOpaque(true);
        l2.isVisible();
        l2.setVisible(true);
        l2.isEnabled();
        l3.setBorder(null);
        l3.setBounds(10,130,980,30);
        l3.setHorizontalAlignment(SwingConstants.LEFT);
        l3.setFont(font);
        l3.setForeground(new Color(250, 231, 110));
        l3.setBackground(Color.black);
        l3.setOpaque(true);
        l3.isVisible();
        l3.setVisible(true);
        l3.isEnabled();
        l4.setBorder(null);
        l4.setBounds(10,190,980,30);
        l4.setHorizontalAlignment(SwingConstants.LEFT);
        l4.setFont(font);
        l4.setForeground(new Color(250, 231, 110));
        l4.setBackground(Color.black);
        l4.setOpaque(true);
        l4.isVisible();
        l4.setVisible(true);
        l4.isEnabled();
        l5.setBorder(null);
        l5.setBounds(10,250,980,30);
        l5.setHorizontalAlignment(SwingConstants.LEFT);
        l5.setFont(font);
        l5.setForeground(new Color(250, 231, 110));
        l5.setBackground(Color.black);
        l5.setOpaque(true);
        l5.isVisible();
        l5.setVisible(true);
        l5.isEnabled();
        l6.setBorder(null);
        l6.setBounds(10,310,980,30);
        l6.setHorizontalAlignment(SwingConstants.LEFT);
        l6.setFont(font);
        l6.setForeground(new Color(250, 231, 110));
        l6.setBackground(Color.black);
        l6.setOpaque(true);
        l6.isVisible();
        l6.setVisible(true);
        l6.isEnabled();
        l7.setBorder(null);
        l7.setBounds(10,370,980,30);
        l7.setHorizontalAlignment(SwingConstants.LEFT);
        l7.setFont(font);
        l7.setForeground(new Color(250, 231, 110));
        l7.setBackground(Color.black);
        l7.setOpaque(true);
        l7.isVisible();
        l7.setVisible(true);
        l7.isEnabled();
        l8.setBorder(null);
        l8.setBounds(10,430,980,30);
        l8.setHorizontalAlignment(SwingConstants.LEFT);
        l8.setFont(font);
        l8.setForeground(new Color(250, 231, 110));
        l8.setBackground(Color.black);
        l8.setOpaque(true);
        l8.isVisible();
        l8.setVisible(true);
        l8.isEnabled();
        l9.setBorder(null);
        l9.setBounds(10,490,980,30);
        l9.setHorizontalAlignment(SwingConstants.LEFT);
        l9.setFont(font);
        l9.setForeground(new Color(250, 231, 110));
        l9.setBackground(Color.black);
        l9.setOpaque(true);
        l9.isVisible();
        l9.setVisible(true);
        l9.isEnabled();
        l10.setBorder(null);
        l10.setBounds(10,550,980,30);
        l10.setHorizontalAlignment(SwingConstants.LEFT);
        l10.setFont(font);
        l10.setForeground(new Color(250, 231, 110));
        l10.setBackground(Color.black);
        l10.setOpaque(true);
        l10.isVisible();
        l10.setVisible(true);
        l10.isEnabled();

        a.setBorder(null);
        a.setBounds(10,250,980,30);
        a.setHorizontalAlignment(JLabel.RIGHT);
        a.setFont(font);
        a.setForeground(new Color(250, 231, 110));
        a.addActionListener(this);
        a.setVisible(true);
        a.isVisible();
        a.isEnabled();
        d.setBorder(null);
        d.setBounds(10,310,980,30);
        d.setHorizontalAlignment(JLabel.RIGHT);
        d.setFont(font);
        d.setForeground(new Color(250, 231, 110));
        d.addActionListener(this);
        d.setVisible(true);
        d.isVisible();
        d.isEnabled();
        r.setBorder(null);
        r.setBounds(10,370,980,30);
        r.setHorizontalAlignment(JLabel.RIGHT);
        r.setFont(font);
        r.setForeground(new Color(250, 231, 110));
        r.addActionListener(this);
        r.setVisible(true);
        r.isVisible();
        r.isEnabled();
        f.setBorder(null);
        f.setBounds(10,430,980,30);
        f.setHorizontalAlignment(JLabel.RIGHT);
        f.setFont(font);
        f.setForeground(new Color(250, 231, 110));
        f.addActionListener(this);
        f.setVisible(true);
        f.isVisible();
        f.isEnabled();
        le.setBorder(null);
        le.setBounds(10,490,980,30);
        le.setHorizontalAlignment(JLabel.RIGHT);
        le.setFont(font);
        le.setForeground(new Color(250, 231, 110));
        le.addActionListener(this);
        le.setVisible(true);
        le.isVisible();
        le.isEnabled();
        s.setBorder(null);
        s.setBounds(10,550,980,30);
        s.setHorizontalAlignment(JLabel.RIGHT);
        s.setFont(font);
        s.setForeground(new Color(250, 231, 110));
        s.addActionListener(this);
        s.setVisible(true);
        s.isVisible();
        s.isEnabled();

        j.add(l);
        j.add(l2);
        j.add(l3);
        j.add(l4);
        j.add(l5);
        j.add(l6);
        j.add(l7);
        j.add(l8);
        j.add(l9);
        j.add(l10);
        j.add(a);
        j.add(d);
        j.add(r);
        j.add(f);
        j.add(le);
        j.add(s);

        j.isVisible();
        j.setVisible(true);
        j.isEnabled();
    }

    public static void typewriterEffect(JLabel label, String str) {
        String temp = "";
        for(int i = 0; i<str.length(); i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            temp = str.substring(0,i);
            label.setText(temp);
        }
        label.setText(str);
    }

    public void actionPerformed(ActionEvent e) {
        e.getActionCommand();
        arrayList.add(e.getSource());
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
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            typewriterEffect(l3,"> * " + enemy + " has appeared! *");

            label:
            while (enemyHealth > 0) {
                typewriterEffect(l2,"> Your Health: " + health);
                typewriterEffect(l3,"> " + enemy + "'s Health: " + enemyHealth);
                typewriterEffect(l4,"> What will you do?");
                typewriterEffect(l5,a.getText());
                typewriterEffect(l6,d.getText());
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
                }
                break;
            }

            monstersDefeated++;
            ++goldDrop;
            totalGold = goldDrop + totalGold;
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
            } else if (arrayList.contains(le)) {
                typewriterEffect(l,"> You exited the dungeon!");
                break;
            } else if (arrayList.contains(s) && totalGold >= 10){
                attackDamage += attackDamage + 10;
            }
            else if (arrayList.contains(s) && totalGold < 10){
                typewriterEffect(l,"> You don't have enough gold!");
            }

            typewriterEffect(l,"***************************");
            typewriterEffect(l2,"> * Thanks For Playing! * ");
            typewriterEffect(l3,"> * You killed: " + monstersDefeated + " monsters!");
            typewriterEffect(l4,"> * You ran away: " + ranAwayTimes + " times!");
            typewriterEffect(l5,"> * You drank " + potionsDrank + " potions!");
            typewriterEffect(l6,"***************************");
        }
    }
}