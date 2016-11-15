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
		//sort.insertionSort();
		//sort.bInsertionSort();
		/*int high = num.unsorted.size() -1;
		int low = 0;
		int k = 2;
		int[] complete = sort.mergesort(numArray, high, low, k);*/
		sort.sortInsertion(num, 2);
	}

}
