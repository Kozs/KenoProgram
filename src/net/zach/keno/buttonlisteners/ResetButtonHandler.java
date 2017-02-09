package net.zach.keno.buttonlisteners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import net.zach.keno.GUI;

public class ResetButtonHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton resetButton = (JButton) e.getSource();
		resetButton.setEnabled(false);
		
		GUI.getChoices().clear();
		StartButtonHandler.rand.clear();
		GUI.getComText().setText("");
		GUI.getNumText().setText("");
		GUI.getStatusText().setText("Pick 3 numbers!");
		for (JButton j: GUI.buttons) {
		    j.setBackground(Color.BLUE);
		    j.setForeground(Color.YELLOW);
		}
	}

}
