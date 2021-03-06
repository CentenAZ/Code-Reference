// Binary Search O(log n), TERMS HAVE TO BE SORTED
// Language: Java

package binarySearch;

// Package that contains the generateArray(integer, integer) method. MAKE SURE THE GenerateArray-Java PROJECT IS LOADED IN THE 
// ALGORITHMS/GenerateToSort/GenerateArray-Java FOLDER
import randomArrayJava.RandomlyGenerateArray;
import tempsort.TempSort;

import java.util.Scanner;

public class BinarySearch 
{
	// BINARY SEARCH ALGORITHM
	public static int binarySearch(int[] arr, int target)
	{
		int leftBound = 0;
		int rightBound = arr.length-1;
		while (leftBound <= rightBound) 
		{
			int middle = rightBound - leftBound;
			if (arr[middle] == target)
			{
				return middle;
			}
			else if (target < arr[middle]) 
			{
				rightBound = middle - 1;
			}
			else if (target > arr[middle]) 
			{
				leftBound = middle + 1;
			}
		}
		return -1;
	}

	
	public static void main(String[] args) 
	{
		// Generate array and print it
		int[] initArray = RandomlyGenerateArray.generateArray(10, 100);
		int[] array = TempSort.selectionSort(initArray);	// The array needs to be sorted
		System.out.print("Initial Array: { ");
		for (int i : array) 
		{
			System.out.print(i + " ");
		}
		System.out.println(" }");
		// Input the number to find in the array
		Scanner numberToFind = new Scanner(System.in);
		System.out.println("\nEnter a number to find in the array: ");
		int number = numberToFind.nextInt();
		numberToFind.close();
		
		// Searching through array and outputting result
		int foundIndex = binarySearch(array, number);
		if (foundIndex != -1)
		{
			System.out.println("\n" + number + " is at " + foundIndex);
		}
		else
		{
			System.out.println("\n" + number + " is not in the array.");
		}
	}
}
