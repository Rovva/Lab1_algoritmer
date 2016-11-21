package sorting;

import java.util.Arrays;

import sorting.NumberGenerator;
import sorting.Sorter2;


public class Main {

	NumberGenerator num;
	Sorter2 sort;
	
	public static void main(String[] args) {
		for(int i = 8; i <= 20; i = i + 2) {
			startSort(5000, i);
			startSort(5000, i);
			System.out.println("---");
			startSort(10000, i);
			startSort(10000, i);
			System.out.println("---");
			startSort(15000, i);
			startSort(15000, i);
			System.out.println("---");
			startSort(20000, i);
			startSort(20000, i);
			System.out.println("---");
			startSort(25000, i);
			startSort(25000, i);
			System.out.println("---");
			startSort(30000, i);
			startSort(30000, i);
			System.out.println("---");
			startSort(35000, i);
			startSort(35000, i);
			System.out.println("---");
			startSort(40000, i);
			startSort(40000, i);
			System.out.println("---");
			startSort(45000, i);
			startSort(45000, i);
			System.out.println("---");
			startSort(50000, i);
			startSort(50000, i);
			System.out.println("---");
		}
	}
	
	public static void startSort(int numbers, int kvalue) {
		int n = numbers;
		int k = kvalue;
		long time, timeB;
		long test, testB;
		NumberGenerator num = new NumberGenerator(n);
		Sorter2 sort = new Sorter2();
		

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
		test = test / 5;
		System.out.println("Insert: n, k, t: " + n + "," + k + "," + test);
		//System.out.println("Insertion sort takes: " + (System.nanoTime() - startTime)/1000000.0 + " Milliseconds for n = " + num.unsorted.size() + "  and k = " + k );
		
		long startTimeB = System.nanoTime();
		sort.sortBinsertion(num, k);
		timeB = (long) ((System.nanoTime() - startTimeB)/100000.0);
		testB = timeB;
		startTimeB = System.nanoTime();
		sort.sortBinsertion(num, k);
		timeB += (long) ((System.nanoTime() - startTimeB)/100000.0);

		startTimeB = System.nanoTime();
		sort.sortBinsertion(num, k);
		timeB += (long) ((System.nanoTime() - startTimeB)/100000.0);

		startTimeB = System.nanoTime();
		sort.sortBinsertion(num, k);
		timeB += (long) ((System.nanoTime() - startTimeB)/100000.0);

		startTimeB = System.nanoTime();
		sort.sortBinsertion(num, k);
		timeB += (long) ((System.nanoTime() - startTimeB)/100000.0);

		startTimeB = System.nanoTime();
		sort.sortBinsertion(num, k);
		timeB += (long) ((System.nanoTime() - startTimeB)/100000.0);
		timeB = timeB / 5;
		System.out.println("bInsert: n, k, t: " + n + "," + k + "," + timeB);
		//System.out.println("bInsertion sort takes: " + (System.nanoTime() - startTimeB)/1000000.0 + " Milliseconds for n = " + num.unsorted.size() + "  and k = " + k );
		
	}

}
