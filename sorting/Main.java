package sorting;

import java.util.Arrays;

import sorting.NumberGenerator;
import sorting.Sorter;


public class Main {

	NumberGenerator num;
	Sorter sort;
	
	public static void main(String[] args) {
		/*
		 * In this for loop we append the k value by 2 and compare with increasing n
		 * we run the code twice to get the average time.
		 */
		for(int k = 2; k <= 20; k = k + 2) {
			startSort(5000, k);
			System.out.println("---");
			startSort(10000, k);
			System.out.println("---");
			startSort(15000, k);
			System.out.println("---");
			startSort(20000, k);
			System.out.println("---");
			startSort(25000, k);
			System.out.println("---");
			startSort(30000, k);
			System.out.println("---");
			startSort(35000, k);
			System.out.println("---");
			startSort(40000, k);
			System.out.println("---");
			startSort(45000, k);
			System.out.println("---");
			startSort(50000, k);
			System.out.println("---");
		}
	}
	
	public static void startSort(int numbers, int kvalue) {
		int n = numbers;
		int k = kvalue;
		long time, timeB;
		long test, testB;
		NumberGenerator num = new NumberGenerator(n);
		Sorter sort = new Sorter();
		

		long startTime = System.nanoTime();
		sort.sortInsertion(num, k);
		time = (long) ((System.nanoTime() - startTime)/100000.0);
		test = time;
		startTime = System.nanoTime();
		sort.sortInsertion(num, k);
		time = (long) ((System.nanoTime() - startTime)/100000.0);
		test += time;
		startTime = System.nanoTime();
		sort.sortInsertion(num, k);
		time = (long) ((System.nanoTime() - startTime)/100000.0);
		test += time;
		startTime = System.nanoTime();
		sort.sortInsertion(num, k);
		time = (long) ((System.nanoTime() - startTime)/100000.0);
		test += time;
		sort.sortInsertion(num, k);
		time = (long) ((System.nanoTime() - startTime)/100000.0);
		test += time;
		test = test / 5;
		System.out.println("Insert: n, k, t: " + n + "," + k + "," + test);
		//System.out.println("Insertion sort takes: " + (System.nanoTime() - startTime)/1000000.0 + " Milliseconds for n = " + num.unsorted.size() + "  and k = " + k );
		
		long startTimeB = System.nanoTime();
		sort.sortBinsertion(num, k);
		timeB = (long) ((System.nanoTime() - startTimeB)/100000.0);
		testB = timeB;
		startTimeB = System.nanoTime();
		sort.sortBinsertion(num, k);
		testB += (long) ((System.nanoTime() - startTimeB)/100000.0);

		startTimeB = System.nanoTime();
		sort.sortBinsertion(num, k);
		testB += (long) ((System.nanoTime() - startTimeB)/100000.0);

		startTimeB = System.nanoTime();
		sort.sortBinsertion(num, k);
		testB += (long) ((System.nanoTime() - startTimeB)/100000.0);
		
		startTimeB = System.nanoTime();
		sort.sortBinsertion(num, k);
		testB += (long) ((System.nanoTime() - startTimeB)/100000.0);
		testB = testB / 5;
		System.out.println("bInsert: n, k, t: " + n + "," + k + "," + testB);
		
	}

}
