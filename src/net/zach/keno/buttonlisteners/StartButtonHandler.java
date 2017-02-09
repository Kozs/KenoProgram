package net.zach.keno.buttonlisteners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import net.zach.keno.GUI;
import net.zach.keno.Keno;
import net.zach.keno.computer.Computer;
import net.zach.keno.util.FinalStage;

public class StartButtonHandler implements ActionListener {

	public static List<Integer> rand = new ArrayList<Integer>();
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (rand.size() > 0) {
			JOptionPane.showMessageDialog(Keno.g, "Please press 'Reset' button to play again!");
			return;
		}
		if (GUI.getChoices().size() < 3 || GUI.getChoices().size() > 3) {
			System.out.println("Reset Game, choices are NULLED!");
			return;
		}
		GUI.getResetBtn().setEnabled(true);
		GUI.getStartBtn().setEnabled(false);
		int[] com = new int[20];
		com = Computer.generateNumbers(com, 80, 1);
		for (int i = 0; i < com.length; i++) {
			rand.add(com[i]);
		}
		GUI.getComText().setText("<html>"+rand+"</html>");
		for (JButton j: GUI.buttons) {
			int id = Integer.parseInt(j.getActionCommand());
			if (rand.contains(id)) {
				j.setBackground(Color.GREEN);
			}
		}
		GUI.getStatusText().setText("Correctly Guessed: " + FinalStage.getWinners());
	}

}
