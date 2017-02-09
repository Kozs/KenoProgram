package net.zach.keno.buttonlisteners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import net.zach.keno.GUI;
import net.zach.keno.Keno;

public class ButtonHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		if (GUI.getChoices().size() < 3) {
			GUI.getChoices().add(Integer.parseInt(event.getActionCommand()));
			GUI.getNumText().setText("  " + GUI.getChoices());
	        JButton b = (JButton)event.getSource();
	        b.setBackground(Color.RED);
			if (GUI.getChoices().size() == 3) {
				GUI.getStartBtn().setEnabled(true);
			}
		} else {
			JOptionPane.showMessageDialog(Keno.g, "You've already picked 3 numbers!");
		}

	}

}
