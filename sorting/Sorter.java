package sorting;

import java.util.ArrayList;

import sorting.NumberGenerator;

public class Sorter {
	
	NumberGenerator num;
	ArrayList sorted_linear = new ArrayList(), sorted_binary = new ArrayList();
	ArrayList unsorted;		//Our unsorted list, created by NumberGenerator
	
	
	public Sorter(NumberGenerator num) {
		// TODO Auto-generated constructor stub
		this.num = num;
		this.unsorted = num.unsorted;
	}
	
	void insertionSort() {
		long startTime = System.nanoTime();
		int tmp;		// A temporary variable for the number we pick from the unsorted list
		for(int i = 0; i < unsorted.size(); i++) {
			tmp = (int) unsorted.get(i);	//Grabbing a number from unsorted list
			if(i == 0) {					//The sorted list is always empty at the beginning...
				sorted_linear.add(tmp);		//...So just put in the first unsorted number.
			} else {
				System.out.println(sorted_linear);
				for(int j = sorted_linear.size() - 1; j >= 0; j--) {
				//Check through the sorted list
					
					if(tmp < (int)sorted_linear.get(j)) {//Is the number lower than it, in the sorted list?
						if(j-1 < 0) {					 //Are we at the bottom of the list?
							sorted_linear.add(0, tmp);	 //Put the number at the bottom of the list
							System.out.println(tmp);
							break;
						} else if (tmp >= (int)sorted_linear.get(j-1)) {
						//Ok we are less than j but what about the number behind j?
							
							sorted_linear.add(j, tmp); 
							//We are higher or equal and can add it in our current position
							
							System.out.println(tmp);
							break;
						}
					} else {					//tmp is higher than j
						sorted_linear.add(tmp); //We add tmp to the list.
						break;
					}
				}
			}
		}
		System.out.println(sorted_linear);
		System.out.println(((System.nanoTime() - startTime)/1000000.0) + " Miliseconds");
	}
	

	
	void bInsertionSort(ArrayList firstHalf, ArrayList secondHalf) {
	//For bInsertionSort we have lower and upperbounds to determine the split
		int tmp, upperbound, lowerbound;
		
		for(int i = 0; i < unsorted.size(); i++) {
			tmp = (int) unsorted.get(i);
			if(i == 0) {
				sorted_binary.add(tmp);
			} else {
				
				//Every new number we want to insert needs
				//to reset the bounds according to the sorted list.
				upperbound = sorted_binary.size() - 1;
				lowerbound = 0;
				
				while (unsorted.size() != 0){
				//Note that each "break;" throws us out of the while loop.
				//Causing our boundaries to be reset for the new number
					
					int j = (upperbound + lowerbound) / 2;	//j points to the middle of the boundaries
					if (tmp <= (int)sorted_binary.get(j)){	//is tmp less or equal to the number in j?
												
						if (j == 0){						//Are we at the bottom of the list?
							sorted_binary.add(0, tmp);		//Add it to the bottom of the list.
							break;
						}
						
						else if ((int)sorted_binary.get(j-1) > tmp){ 
						//Else if the number behind j is bigger than tmp...
						//...we can move the upper bound behind j and repeat the split.
						//NOTE: We do NOT "break;" to get thrown out of the while loop.
							
							upperbound = j - 1;
						}
						
						else{ //Else we just add the number to j
							sorted_binary.add(j, tmp);
							break;
						}
					}
					
					else{ //If tmp is HIGHER than j
						if (j == sorted_binary.size() - 1){
						//Are we at the end of the list?
						//Just add tmp at the end of the list.	
							sorted_binary.add(j+1, tmp);
							break;
						}
						
						else if((int)sorted_binary.get(j+1) < tmp){
						//if the next number to j is still less than tmp...
						//we raise the lowerbound past j and repeat the split
						//NOTE: We do NOT "break;" to get thrown out of the while loop.
							lowerbound = j + 1;
						}
						
						else{ 
						//Else we can just add tmp after j since it's higher than j
							sorted_binary.add(j+1, tmp);
							break;
						}
					}
					
				}
				
			}
		}
	}
	
	public ArrayList mergesort(ArrayList data, int high, int low) {
        int middle = (high+low)/2;
        if (middle==low) {
            ArrayList data2 = new ArrayList();
            data2.set(0, data.get(middle));
            return data2;
        } else {
            ArrayList firstHalfSorted = mergesort(data, low, middle);
            ArrayList secondHalfSorted = mergesort(data, middle+1, high);
            return (merge(firstHalfSorted, secondHalfSorted));
        }
	}	
}