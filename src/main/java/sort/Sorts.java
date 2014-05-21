package sort;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Sorts {
	public static void main(String[] args) throws IOException {
		int rn[] = {25,50,100,250,500,1000,2500,5000,10000,20000,25000,35000,45000,50000};
		Random generator = new Random();
		for (int i : rn) {
			int[] a = new int[i];
			for (int j = 0; j < a.length; j++) {
				a[i] = generator.nextInt(i);
			}
		}
	}
}
