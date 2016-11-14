package sorting;

import java.util.Arrays;

import sorting.NumberGenerator;
import sorting.Sorter;


public class Main {

	NumberGenerator num;
	Sorter sort;
	
	public static void main(String[] args) {
		NumberGenerator num = new NumberGenerator(Integer.parseInt(args[0]));
		Sorter sort = new Sorter(num);
		//sort.insertionSort();
		//sort.bInsertionSort();
		int[] numArray = new int[num.unsorted.size()];
		for(int i = 0; i < num.unsorted.size(); i++) {
			numArray[i] = (int) num.unsorted.get(i);
		}
		int high = num.unsorted.size() -1;
		int low = 0;
		int k = 2;
		int[] complete = sort.mergesort(numArray, high, low, k);
		System.out.println(Arrays.toString(complete));
		/*
		for(int i = 0; i < complete.length; i++) {
			System.out.println(complete[i]);
		}
		*/
	}

}
