package sorting;

import java.util.ArrayList;

import sorting.NumberGenerator;

public class Sorter {
	
	NumberGenerator num;
	ArrayList sorted_linear = new ArrayList(), sorted_binary = new ArrayList();
	ArrayList unsorted;
	
	
	public Sorter(NumberGenerator num) {
		// TODO Auto-generated constructor stub
		this.num = num;
		this.unsorted = num.unsorted;
	}
	
	void insertionSort() {
		int tmp;
		for(int i = 0; i < unsorted.size(); i++) {
			tmp = (int) unsorted.get(i);
			if(i == 0) {
				sorted_linear.add(tmp);
			} else {
				System.out.println(sorted_linear);
				for(int j = sorted_linear.size() - 1; j >= 0; j--) {
					if(tmp < (int)sorted_linear.get(j)) {
						if(j-1 < 0) {
							sorted_linear.add(0, tmp);
							System.out.println(tmp);
							break;
						} else if (tmp >= (int)sorted_linear.get(j-1)) {
							sorted_linear.add(j, tmp);
							System.out.println(tmp);
							break;
						}
					} else {
						sorted_linear.add(tmp);
						break;
					}
				}
			}
		}
		System.out.println(sorted_linear);
	}
	

	
	void bInsertionSort() {
		int tmp, upperbound, lowerbound;
		
		for(int i = 0; i < unsorted.size(); i++) {
			tmp = (int) unsorted.get(i);
			if(i == 0) {
				sorted_binary.add(tmp);
			} else {
				upperbound = sorted_binary.size() - 1;
				lowerbound = 0;
				
				while (unsorted.size() != 0){
					int j = (upperbound + lowerbound) / 2;
					if (tmp <= (int)sorted_binary.get(j)){
												
						if (j == 0){
							sorted_binary.add(0, tmp);
							break;
						}
						
						else if ((int)sorted_binary.get(j-1) > tmp){
							upperbound = j - 1;
						}
						
						else{
							sorted_binary.add(j, tmp);
							break;
						}
					}
					
					else{
						if (j == sorted_binary.size() - 1){
							
							sorted_binary.add(j+1, tmp);
							break;
						}
						
						else if((int)sorted_binary.get(j+1) < tmp){
							lowerbound = j + 1;
						}
						
						else{
							sorted_binary.add(j+1, tmp);
							break;
						}
					}
					
				}
				
			}
		}
		System.out.println(sorted_binary);
	}

}
