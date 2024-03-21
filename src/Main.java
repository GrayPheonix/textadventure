//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;


public class Main {
    public static void main(String[] args) {
        JFrame j = new JFrame();
        JButton b = new JButton();
        GAME n = new GAME();
        j.setTitle("Dungeon Run");
        j.setLocationRelativeTo(null);
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLayout(null);
        j.setSize(1000, 600);
        j.setBackground(Color.BLACK);

        JTextField textPart = new JTextField();
        textPart.setBounds(8,10,972,550);
        textPart.setBackground(Color.BLACK);
        j.add(textPart);
        textPart.setText(null);
        Font font = new Font("Serif",0 , 50);
        textPart.setFont(font);
        textPart.setHorizontalAlignment(JTextField.RIGHT);
        textPart.setSelectedTextColor(Color.LIGHT_GRAY );
        textPart.setForeground(Color.WHITE );

        j.isVisible();
        j.setVisible(true);
        j.isEnabled();
    }

}