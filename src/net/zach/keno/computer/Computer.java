package net.zach.keno.computer;

import java.util.Random;

/**
 * 
 * @author Zachy
 * Class will be the instance of the Computer, generating numbers randomly.
 */

public class Computer {
	
	public static int[] generateNumbers(int[] store, int max, int min) {
		//Pre: Gets Max/Min/Amount values and Store array
		//Post: Returns the array filled with randomized numbers
		Random r = new Random();
		int amount = store.length;
		for (int i = 0; i < amount; i++) {
			int nextNum = r.nextInt((max - min) + 1) + min;
			if (!containsValue(store, nextNum)) {
				store[i] = nextNum;
			} else {
				i--;
			}
		}
		return store;
	}
	
	private static boolean containsValue(int[] store, int value) {
		//Pre: 
		//Post: Tells you if the value 
		int amount = store.length;
		for (int i = 0; i < amount; i++) {
			if (store[i] == value) {
				return true;
			}
		}
		return false;
	}

}
