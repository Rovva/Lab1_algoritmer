package sorting;
import java.util.ArrayList;
import sorting.NumberGenerator;

public class Sorter2 {
    
    private int[] tempMergArr;
    
    NumberGenerator num;
	ArrayList sorted;
	ArrayList unsorted;		//Our unsorted list, created by NumberGenerator
	ArrayList tempMerge;
	
	int length;
	int k;
   
    //insertionsort
    public void sortInsertion(NumberGenerator num, int k) {
    	this.num = num;
		this.unsorted = num.unsorted;
        this.length = unsorted.size();
        this.k = k;
        this.sorted = new ArrayList(length);
        this.tempMergArr = new int [length];
        sort1(0, length - 1);
		System.out.println(sorted);
    }
    //binsertionsort
    public void sortBinsertion(NumberGenerator num, int k) {
    	this.num = num;
		this.unsorted = num.unsorted;
        this.length = unsorted.size();
        this.k = k;
        this.tempMergArr = new int [length];
        sort2(0, length - 1);
    }
    
    private void sort1(int lowerIndex, int higherIndex) {
    	int t =(higherIndex - lowerIndex);
    	int middle = 0;
    	System.out.println("t: " + t + " k: " + k);
    	if(lowerIndex < higherIndex && t > k) {
    		
            middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            sort1(lowerIndex, middle);
            // Below step sorts the right side of the array
            sort1(middle + 1, higherIndex);
            System.out.println(higherIndex - lowerIndex + " k: " + k);
            if(higherIndex - lowerIndex <= k){
            	insertionSort(lowerIndex, higherIndex);
            }

            // Now merge both sides
            mergeSubArr(lowerIndex, middle, higherIndex);
        }
    }
 
    private void sort2(int lowerIndex, int higherIndex) {
        
    	int t =(higherIndex - lowerIndex);
    	
    	if(lowerIndex < higherIndex && t > k) {
    		
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            sort1(lowerIndex, middle);
            // Below step sorts the right side of the array
            sort1(middle + 1, higherIndex);
            
            if(higherIndex - lowerIndex <= k){
            	binsertionSort(lowerIndex, higherIndex);
            }
            
            // Now merge both sides
            mergeSubArr(lowerIndex, middle, higherIndex);
        }
    }
    //mergeSubArr är klar att testa om inga fel kan ses.
    private void mergeSubArr(int lowerIndex, int middle, int higherIndex) {
    	
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = (int)unsorted.get(i);
        }
        int i = lowerIndex;
        int j = middle + 1;
        int l = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                sorted.set(l, tempMergArr[i]);
                i++;
            } else {
                sorted.set(l, tempMergArr[j]);
                j++;
            }
            l++;
        }
        while (i <= middle) {
            sorted.set(l, tempMergArr[i]);
            l++;
            i++;
        }
 
    }
    
    
    private void insertionSort(int lowerIndex, int higherIndex) {
    	ArrayList tmpsorted = new ArrayList();
		int tmp;		// A temporary variable for the number we pick from the unsorted list
		for(int i = lowerIndex; i <= higherIndex; i++) {
			tmp = (int) unsorted.get(i);	//Grabbing a number from unsorted list
			if(i == 0) {					//The sorted list is always empty at the beginning...
				tmpsorted.add(tmp);		//...So just put in the first unsorted number.
			} else {
				System.out.println(tmpsorted);
				for(int j = tmpsorted.size() - 1; j >= 0; j--) {
				//Check through the sorted list
					
					if(tmp < (int)tmpsorted.get(j)) {//Is the number lower than it, in the sorted list?
						if(j-1 < 0) {					 //Are we at the bottom of the list?
							tmpsorted.add(0, tmp);	 //Put the number at the bottom of the list
							System.out.println(tmp);
							break;
						} else if (tmp >= (int)tmpsorted.get(j-1)) {
						//Ok we are less than j but what about the number behind j?
							
							tmpsorted.add(j, tmp); 
							//We are higher or equal and can add it in our current position
							
							System.out.println(tmp);
							break;
						}
					} else {					//tmp is higher than j
						tmpsorted.add(tmp); //We add tmp to the list.
						break;
					}
				}
			}
		}
		// Mata in tmp listan till unsorted.
		int j = 0;
		for(int i = lowerIndex; i <= higherIndex; i++) {
			unsorted.set(i, tmpsorted.get(j));
			j++;
		}
		System.out.println("lol");
		System.out.println(tmpsorted);
	}
    
    
    private void bInsertionSort(ArrayList firstHalf, ArrayList secondHalf) {
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
    
}