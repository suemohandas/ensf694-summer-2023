import java.util.Arrays;
import java.util.Scanner;

public class SearchingAlgorithm {
	
	// Linear Search
	public static int linearSearch(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key)
				return i;
			
		}
		return -1; 
	}
	// Interpolated Search (Iterative) 
	public static int interpolatedSearchIterative(int[] arr, int key) {
		Arrays.sort(arr);
		int low = 0;
		int high = arr.length - 1;
		int pos;
		int mid;
		while (arr[low] <= key && arr[high] >= key) {
			pos = (key - arr[low]) / (arr[high] - arr[low]);
			mid = low + (((high - low) * pos));
			if (key < arr[mid])
				high = mid - 1;
			else if (arr[mid] < key)
				low = mid + 1;
			else
				return mid; 
			
		}
		return -1; 
	}
	// Improved Linear Search (By Swapping the key element to the front) 
	public static int linearSearchImproved(int[] arr, int key) {
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				index = i;
			break;
			
			}
		}
		if (index != -1) {
			int temp = arr[index];
			arr[index] = arr[0];
			arr[0] = temp; 
		}
		return index;
	}
	

	public static void main(String[] args) {
		
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter the number of elements in the array: ");
		int size = myObj.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter the elements in the array: ");
		for (int i = 0; i < size; i++)
			arr[i] = myObj.nextInt();
		System.out.println("Enter the search key: ");
		int key = myObj.nextInt();
		
		// Create copies of the arrays to be used in Interpolated Search & Improved Linear Search respectively 
		int[] arr2 = new int[size];
		System.arraycopy(arr,  0,  arr2,  0,  size);
		int[] arr3 = new int[size];
		System.arraycopy(arr2,  0,  arr3,  0,  size);
		
		// Evaluate the time taken to perform the search operation for each of the Search Methods 
		long startTime1 = System.nanoTime();
		int index = linearSearch(arr, key);
		long endTime1 = System.nanoTime();
		long timeElapsedLinearSearch = endTime1 - startTime1;
		System.out.println("Using Linear Search: ");
		if (index == -1)
			System.out.println("Search key NOT FOUND.");
		else
			System.out.println("Search key found at index " + index);
		System.out.println("Time elapsed in nanoseconds for Linear Search is " + timeElapsedLinearSearch);
		
		long startTime2 = System.nanoTime();
		int index2 = interpolatedSearchIterative(arr2, key);
		long endTime2 = System.nanoTime();
		long timeElapsedInterpolatedSearchIterative = endTime2 - startTime2;
		System.out.println("Using Interpolated Search Iterative: ");
		if (index2 == -1)
			System.out.println("Search key NOT FOUND.");
		else
			System.out.println("Search key found at index " + index2);
		System.out.println("Time elapsed in nanoseconds for Interpolated Search Iterative is " + timeElapsedInterpolatedSearchIterative);
		
		System.out.println("Linear Search performed better than the Interpolated Iterative Search. It took longer to sort the array first and then perform the search operation using the interpolated iterative serach.");
		
		long startTime3 = System.nanoTime();
		int index3 = linearSearchImproved(arr3, key);
		long endTime3 = System.nanoTime();
		long timeElapsedLinearSearchImproved = endTime3 - startTime3;
		System.out.println("Using Linear Search Improved: ");
		if (index3 == -1)
			System.out.println("Search key NOT FOUND.");
		else
			System.out.println("Search key found at index " + index3);
		System.out.println("Time elapsed in nanoseconds for Linear Search Improved is  " + timeElapsedLinearSearchImproved);
		
		System.out.println("The values of the array after perform1ing the Improved Linear Search was: ");
		for (int i = 0; i < size; i++)
			System.out.print(arr3[i] + " ");
		System.out.println();
		System.out.println("In the Improved Linear Search, after the key element is found, it is then swapped with the element at index 0. Then searching for the key element again resuts in it being at index 0 thereby reducing the overall search time.");
		myObj.close();
		
		
	}

}
