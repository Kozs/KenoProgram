package net.zach.keno;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.zach.keno.buttonlisteners.ButtonHandler;
import net.zach.keno.buttonlisteners.ResetButtonHandler;
import net.zach.keno.buttonlisteners.StartButtonHandler;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -590231706806542250L;

	private JPanel contentPane;
	
	private static JLabel lblStatusText, lblNums; //Status text, had to declare in the actual class so I can grab it @ ButtonHandler 
	
    private static JButton btn;
	
    private static List<Integer> choices = new ArrayList<Integer>();
	
	private JPanel panel_1;
	private static JButton btnStartGame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private static JLabel comLabel;
	private static JButton btnReset;

	public static List<JButton> buttons = new ArrayList<JButton>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setResizable(false);
		setTitle("Keno - Created by Zachary Smith");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 492);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 34, 575, 322);
		for(int i = 1; i <= 80; i++)
		{
		    btn = new JButton(String.valueOf(i));
			buttons.add(btn);
		    btn.setBackground(Color.BLUE);
		    btn.setForeground(Color.YELLOW);
		    btn.setActionCommand(String.valueOf(i));
		    btn.addActionListener(new ButtonHandler());
		    panel.add(btn);
		}
		contentPane.add(panel);
		System.out.println("JButton ");
		
		lblStatusText = new JLabel("Pick 3 numbers!");
		lblStatusText.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStatusText.setForeground(Color.WHITE);
		lblStatusText.setBounds(201, 367, 225, 62);
		contentPane.add(lblStatusText);
		
		JLabel lblChoices = new JLabel("My Choices:");
		lblChoices.setForeground(Color.WHITE);
		lblChoices.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChoices.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoices.setVerticalAlignment(SwingConstants.TOP);
		lblChoices.setBounds(424, 367, 207, 75);
		contentPane.add(lblChoices);
		
		lblNums = new JLabel("Nums");
		lblNums.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNums.setBounds(473, 390, 96, 25);
		lblNums.setText("  "+choices);
		contentPane.add(lblNums);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(595, 34, 164, 322);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Winning #'s");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 144, 26);
		panel_1.add(lblNewLabel_1);
		
		comLabel = new JLabel("");
		comLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
		comLabel.setForeground(Color.WHITE);
		comLabel.setVerticalAlignment(SwingConstants.TOP);
		comLabel.setBounds(10, 48, 144, 263);
		panel_1.add(comLabel);
		
		btnStartGame = new JButton("Start Game");
		btnStartGame.setEnabled(false);
		btnStartGame.setBounds(595, 419, 164, 23);
		btnStartGame.addActionListener(new StartButtonHandler());
		contentPane.add(btnStartGame);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Zachy\\Desktop\\Programming Dev\\Keno\\images\\icon-128.png"));
		lblNewLabel.setBounds(20, 360, 131, 103);
		contentPane.add(lblNewLabel);
		
		btnReset = new JButton("Reset");
		btnReset.setEnabled(false);
		btnReset.addActionListener(new ResetButtonHandler());
		btnReset.setBounds(483, 419, 89, 23);
		contentPane.add(btnReset);
	}
	
	public static JLabel getStatusText() {
		return lblStatusText;
	}
	
	public static JLabel getNumText() {
		return lblNums;
	}
	
	public static JLabel getComText() {
		return comLabel;
	}
	
	public static JButton getResetBtn() {
		return btnReset;
	}
	
	public static JButton getBtn() {
		return btn;
	}
	
	public static List<Integer> getChoices() {
		return choices;
	}
	
	public static JButton getStartBtn() {
		return btnStartGame;
	}
	
	public static void setChoices(List<Integer> list) {
		choices = list;
	}
}
