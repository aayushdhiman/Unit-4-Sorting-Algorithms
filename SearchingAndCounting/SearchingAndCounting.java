//package SearchingAndCounting;

import java.io.*;
import java.util.*;

public class SearchingAndCounting {
	
	public static int numComparisons = 0;
	
	
	public static void main(String[] args) {
		List<String> searchMe;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the file name with extension : ");
		searchMe = makeListFromFile(input.nextLine());
		
		System.out.print("What is the name that you want to search for? ");
		String search = "";
		
		try {
			search = input.nextLine();
			if (search.equalsIgnoreCase("quit")) {
				System.out.println("Program Complete.");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("Program Complete.");
			System.exit(0);
		}
		
		
		System.out.println("Linear: ");
		if (getIndexWithLinearSearch(search, searchMe) > 0) {
			System.out.println(search + " was found in " + numComparisons + " comparision at index " + getIndexWithLinearSearch(search, searchMe));
		} else {
			System.out.println(search + " was not found in " + numComparisons + " comparision");
		}
		
		System.out.println("Binary: ");
		System.out.println("Index: " + getIndexWithBinarySearch(search, searchMe));
		if (getIndexWithBinarySearch(search, searchMe) > 0) {
			System.out.println(search + " was found in " + numComparisons + " comparision at index " + getIndexWithBinarySearch(search, searchMe));
		} else {
			System.out.println(search + " was not found in " + numComparisons + " comparision");
		}
		
	}
	
	/**
	 * Returns a List of names read from the file in the given <code>filename</code>
	 *
	 * @param filename the name of the file
	 * @return the list of a names of string read from the file.
	 */
	public static List<String> makeListFromFile(String filename) {
		List<String> names = new ArrayList<>();
		try {
			File file = new File("/Users/adhiman/Downloads/" + filename);
			Scanner input = new Scanner(file);
			
			while (input.hasNextLine()) {
				String line = input.nextLine();
				names.add(line);
			}
			input.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return names;
	}
	
	/**
	 * Returns the index of the element with the <code>targetName</code> in the List of <code>names</code>
	 * using a linear search algorithm, -1 if the element does not exist.
	 *
	 * @param targetName the name of the target element in the list
	 * @param names      the list of names
	 * @return the index of the element with the <code>targetName</code>, -1 if the element does not exist.
	 */
	public static int getIndexWithLinearSearch(String targetName, List<String> names) {
		numComparisons = 0;
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).equalsIgnoreCase(targetName)) {
				return i;
			} else {
				numComparisons++;
			}
		}
		return -1;
	}
	
	
	/**
	 * Returns the index of the element with the <code>targetName</code> in the List of <code>names</code>
	 * using a binary search algorithm, -1 if the element does not exist.
	 *
	 * @param targetName the name of the target element in the list
	 * @param names      the list of names
	 * @return the index of the element with the <code>targetName</code>, -1 if the element does not exist.
	 */
	public static int getIndexWithBinarySearch(String targetName, List<String> names) {
		numComparisons = 0;
		int low = 0;
		int high = names.size() - 1;
		while (low <= high) {
			int middle = low + (high - low) / 2;
			
			int compare = targetName.compareTo(names.get(middle));
			
			// Check if targetName is present at mid
			if (compare == 0) {
				numComparisons++;
				return middle;
			}
			
			// If targetName greater, ignore left half
			if (compare > 0) {
				numComparisons++;
				low = middle + 1;
			}
			
			// If targetName is smaller, ignore right half
			else {
				numComparisons++;
				high = middle - 1;
			}
		}
		
		return -1;
	}
	
}
