package com.codechallenge;
/**
 * Eight houses, represented as cells, are arranged in a straight line. Each day every cell competes with its adjacent cells (neighbors). An integer value 1 represents an active cell and a value of 0 represents an inactive cell. If the neighbors on both the sides of a cell are either active or inactive, the cell becomes inactive on the next day; otherwise the cell becomes active. The two cells on each end have a single adjacent cell, so assume that the unoccupied space on the opposite side is an inactive cell. Even after updating the cell state, consider its previous state when updating the state of other cells. The state information of all cells should be updated simultaneously.
	Write an algorithm to output the state of the cells after the given number of days.
	
	Input
	The input to the function/method consists of two arguments:
	states, a list of integers representing the current state of cells;
	days, an integer representing the number of days.
	
	Output
	Return a list of integers representing the state of the cells after the given number of days.
	
	Examples 1
	Input:
	[1, 0, 0, 0, 0, 1, 0, 0], 1
	
	Output:
	0 1 0 0 1 0 1 0
	
	Examples 2
	Input:
	[1, 1, 1, 0, 1, 1, 1, 1], 2
	
	Output:
	0 0 0 0 0 1 1 0

 * 
 * @author freddy
 *
 */
public class CellStateAfterNDays {
	
	 public static void main(String[] args) {
	        int[] array = {1, 1, 1, 0, 1, 1, 1, 1};
	        int[] array2 = {1, 0, 0, 0, 0, 1, 0, 0};

	        int days = 2;
	        array = cellCompete(array, days);
	        for (int i = 0; i < array.length; i++) {
	            System.out.print(array[i]);
	        }
	 }
	 
	 public static int[] cellCompete(int[] cells, int days)
	  {
	    int oldCell[]=new int[cells.length];
	    for (Integer i = 0; i < cells.length ; i++ ){
	        oldCell[i] = cells[i];
	    }
	    for (Integer k = 0; k < days ; k++ ){
	        for (Integer j = 1; j < oldCell.length - 1 ; j++ ){
	            if ((oldCell[j-1] == 1 && oldCell[j+1] == 1) || (oldCell[j-1] == 0 && oldCell[j+1] == 0)){
	                cells[j] = 0;
	            } else{
	                cells[j] = 1;
	            }
	        }
	        if (oldCell[1] == 0){
	            cells[0] = 0;
	        } else{
	            cells[0] = 1;
	        }
	        if (oldCell[6] == 0){
	            cells[7] = 0;
	        } else{
	            cells[7] = 1;
	        }
	        for (Integer i = 0; i < cells.length ; i++ ){
	            oldCell[i] = cells[i];
	        }
	    } 
	    return cells;
	  }

}
