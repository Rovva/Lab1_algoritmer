package sorting;

import java.util.Arrays;

import sorting.NumberGenerator;
import sorting.Sorter2;


public class Main {

	NumberGenerator num;
	Sorter2 sort;
	
	public static void main(String[] args) {
		NumberGenerator num = new NumberGenerator(Integer.parseInt(args[0]));
		Sorter2 sort = new Sorter2();
		
		int k = 50;
		
		long startTime = System.nanoTime();
		sort.sortInsertion(num, k);
		System.out.println("Insertion sort takes: " + (System.nanoTime() - startTime)/1000000000.0 + " Seconds for n = " + num.unsorted.size() + "  and k = " + k );
		
		long startTimeB = System.nanoTime();
		sort.sortBinsertion(num, k);
		System.out.println("bInsertion sort takes: " + (System.nanoTime() - startTimeB)/1000000000.0 + " Seconds for n = " + num.unsorted.size() + "  and k = " + k );
		
	}

}
