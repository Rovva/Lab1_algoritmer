package sorting;

import sorting.NumberGenerator;
import sorting.Sorter;


public class Main {

	NumberGenerator num;
	Sorter sort;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1/2);
		NumberGenerator num = new NumberGenerator(Integer.parseInt(args[0]));
		Sorter sort = new Sorter(num);
		sort.insertionSort();
	}

}