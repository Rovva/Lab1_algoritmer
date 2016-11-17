package sorting;

import java.util.ArrayList;
import java.util.Random;

public class NumberGenerator {

	int num;
	ArrayList unsorted = new ArrayList();
	ArrayList unsorted2 = new ArrayList();
	
	public NumberGenerator(int n) {
		num = n;
		GenerateNumbers();
		showNumbers();
	}
	
	void GenerateNumbers() {  // Creates a list of random numbers from 0 to n-1
		int randomNumber;
		Random randomGenerator = new Random();
		for(int i = 0; i < this.num; i++) {				
			randomNumber = randomGenerator.nextInt(num);
			unsorted.add(randomNumber);
			unsorted2.add(randomNumber);
		}
	}
	
	void showNumbers() {
		//System.out.println("Orginal: " + unsorted);
	}
	
}
