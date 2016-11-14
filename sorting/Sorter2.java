package sorting;
import java.util.ArrayList;
import sorting.NumberGenerator;

public class Sorter2 {
    
    //private int[] array;
    //private int[] tempMergArr;
    //private int length;
    
    NumberGenerator num;
	ArrayList sorted = new ArrayList();
	ArrayList unsorted;		//Our unsorted list, created by NumberGenerator
	
	int length;
	int k;
	int length1;
    
    // Original
    public static void main(String a[]){
         
        int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
        Sorter2 mms = new Sorter2();
        mms.sort(inputArr);
        for(int i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }
    }
    //Original 
    public void sort(Arraylist inputArr) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }
    //test1
    public void sortInsertion(NumberGenerator num, int k) {
    	this.num = num;
		this.unsorted = num.unsorted;
        this.length = unsorted.size();
        this.k = k;
        sort1(0, length - 1);
    }
    //Test2
    public void sortBinsertion(NumberGenerator num, int k) {
    	this.num = num;
		this.unsorted = num.unsorted;
        this.length = unsorted.size();
        this.k = k;
        sort2(0, length - 1);
    }
    
    private void sort1(int lowerIndex, int higherIndex) {
    	int t =(higherIndex - lowerIndex);
    	
    	if(lowerIndex < higherIndex && t > k) {
    		
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            sort1(lowerIndex, middle);
            // Below step sorts the right side of the array
            sort1(middle + 1, higherIndex);
            
            if(higherIndex - lowerIndex <= k){
            	insertionSort(lowerIndex, higherIndex);
            }
            
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
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
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
    
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
    	
    	
    	
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
 
    }
    
    
    private void insertionSort(int lowerIndex, int higherIndex) {
    	
    	int i =
    	
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