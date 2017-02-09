package net.zach.keno.util;

import java.awt.Color;

import javax.swing.JButton;

import net.zach.keno.GUI;

public class FinalStage {
/**
 * The final stage of the game, will print the numbers you got right!
 */
	public static int getWinners() {
		//Pre - Needs to be called after the game is played!
		//Post - Returns the amount of numbers the user got right!
		int count = 0;
		for (JButton j : GUI.buttons) {
			if (j.getBackground().equals(Color.RED)) {
				count++;
			}
		}
		return 3-count;
	}
}
