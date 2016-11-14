package sorting;

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
		System.out.println(sort.mergesort(numArray, high, low));
	}

}
