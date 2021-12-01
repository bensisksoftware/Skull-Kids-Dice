import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Dice implements ActionListener {
	
	private static String[] choices = { "d4","d6","d8","d10","d12","d20","d30","d40","d50","d100"};
	private static int fontSize = 44;
	private static JComboBox<String> menu = new JComboBox<String>(choices);
	private static JTextField inputBox1 = new JTextField("");
	private static JTextField inputBox2 = new JTextField("");
	private static JTextArea printResult = new JTextArea("RESULT: ");
	private static JLabel question1 = new JLabel("HOW MANY DICE?");
	private static JLabel question2 = new JLabel("CHOOSE YOUR DICE!");
	private static JLabel question3 = new JLabel("CHOOSE YOUR MODIFIER!");
	
	private ImageIcon skull;
	private JLabel picture;
	
	
	public Dice() {

		JFrame frame = new JFrame("SKULL KID'S DICE");

		JPanel panel = new JPanel();
		
		skull = new ImageIcon("skullkids.jpg");
		picture = new JLabel(skull);
		panel.add(picture);

		question1.setVisible(true);
		question1.setFont(new Font("Serif", Font.PLAIN, fontSize));
		question2.setVisible(true);
		question2.setFont(new Font("Serif", Font.PLAIN, fontSize));
		question3.setVisible(true);
		question3.setFont(new Font("Serif", Font.PLAIN, fontSize));
		menu.setFont(new Font("Serif", Font.PLAIN, fontSize));
		inputBox1.setFont(new Font("Serif", Font.PLAIN, fontSize));
		inputBox2.setFont(new Font("Serif", Font.PLAIN, fontSize));
		printResult.setFont(new Font("Serif", Font.PLAIN, fontSize));
		JButton roll = new JButton("ROLL");
		roll.addActionListener(this);
		menu.setVisible(true);
		
		panel.add(picture);
		panel.add(question1);
		panel.add(inputBox1);
		panel.add(question2);
		panel.add(menu);
		panel.add(question3);
		panel.add(inputBox2);
		panel.add(roll);
		panel.add(printResult);
		
		panel.setLayout(new GridLayout(0,1));

		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setTitle("SKULL KID'S DICE");
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String selection = menu.getItemAt(menu.getSelectedIndex());
		int numOfDice = Integer.parseInt(inputBox1.getText());
		int modifier = Integer.parseInt(inputBox2.getText());
		int diceRoll = 0;
		StringBuilder answer = new StringBuilder();;
		
		switch (selection) {
			case "d4":
				diceRoll = (int)(Math.random() * 4 + 1);
				break;
			case "d6":
				diceRoll = (int)(Math.random() * 6 + 1);
				break;
			case "d8":
				diceRoll = (int)(Math.random() * 8 + 1);
				break;
			case "d10":
				diceRoll = (int)(Math.random() * 10 + 1);
				break;
			case "d12":
				diceRoll = (int)(Math.random() * 12 + 1);
				break;
			case "d20":
				diceRoll = (int)(Math.random() * 20 + 1);
				break;
			case "d30":
				diceRoll = (int)(Math.random() * 30 + 1);
				break;
			case "d40":
				diceRoll = (int)(Math.random() * 40 + 1);
				break;
			case "d50":
				diceRoll = (int)(Math.random() * 50 + 1);
				break;
			case "d100":
				diceRoll = (int)(Math.random() * 100 + 1);
				break;
			default:
				System.out.println("error in switch");
				break;
		}
		
		int multiply = numOfDice * diceRoll;
		int total = multiply + modifier;
		
		printResult.setText("RESULT: (" + numOfDice + selection + ") + " + modifier + " = " + total);
	}
	
	public static void main(String[] args) {
		new Dice();
	}
}


