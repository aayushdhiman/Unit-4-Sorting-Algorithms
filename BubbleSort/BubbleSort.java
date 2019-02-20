package BubbleSort;

import java.util.*;

public class BubbleSort {

    /**
     * Swaps the two elements at index <code>a</code> and <code>b</code> in the array
     * @param arr the array to swap in
     * @param a the first index to swap at
     * @param b the second index to swap at
     */
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("How many numbers would you like? ");
        int amtOfRand = in.nextInt();
        System.out.print("Enter the lower range for the numbers: ");
        int lowRange = in.nextInt();
        System.out.print("Enter the higher range for the numbers: ");
        int highRange = in.nextInt();
        int[] nums = new int[amtOfRand];

        for (int i = 0; i < amtOfRand; i++) {
            nums[i] = (int)(Math.random() * (highRange - lowRange + 1) + lowRange);
        }

        System.out.println(Arrays.toString(nums));
        for (int i = 0 ; i < nums.length - 1; i++) {
            for (int j = i + 1 ; j < nums.length; j++) {
                if (nums[i] < nums[j])
                    swap(nums, i, j);
            }
            System.out.println(Arrays.toString(nums));
        }






    }

}
