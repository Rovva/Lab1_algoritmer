package sorting;

import java.util.Arrays;

import sorting.NumberGenerator;
import sorting.Sorter2;


public class Main {

	NumberGenerator num;
	Sorter2 sort;
	
	public static void main(String[] args) {
		int n = 5000;
		long time;
		NumberGenerator num = new NumberGenerator(100000);
		Sorter2 sort = new Sorter2();
		
		int k = 50;
		
		long startTime = System.nanoTime();
		sort.sortInsertion(num, k);
		time = (long) ((System.nanoTime() - startTime)/100000.0);
		System.out.println("Insert: n, k, t: " + n + "," + k + "," + time);
		//System.out.println("Insertion sort takes: " + (System.nanoTime() - startTime)/1000000.0 + " Milliseconds for n = " + num.unsorted.size() + "  and k = " + k );
		
		long startTimeB = System.nanoTime();
		sort.sortBinsertion(num, k);
		time = (long) ((System.nanoTime() - startTimeB)/100000.0);
		System.out.println("bInsert: n, k, t: " + n + "," + k + "," + time);
		//System.out.println("bInsertion sort takes: " + (System.nanoTime() - startTimeB)/1000000.0 + " Milliseconds for n = " + num.unsorted.size() + "  and k = " + k );
		
	}

}
