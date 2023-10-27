import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        //intializing array of random numbers
        int[] array = {12, 4, 5, 6, 17, 3, 1, 7};
        System.out.println("Before sorting:" + Arrays.toString(array));
        //for each loop/ printing each element as it loops through the array being assigned to value before sorting
        for (int value : array) {
            System.out.println(value + " "); //printing unsorted array
        }
        quickSort(array, 0, array.length - 1); //calling quickSort function to sort array
        System.out.println("\nSorted" + Arrays.toString(array));
        //for each loop/ printing each element as it loops through the array being assigned to value after sorting
        for (int value : array) {
            System.out.println(value + " "); //printing sorted array
        }
    }

    //The main sorting function for the array
    private static void quickSort(int[] array, int lowIndex, int highIndex) {
        //check if the low index is greater than or equal to the high index
        if (lowIndex >= highIndex) {
            return; //nothing to sort or one element left
        }
        //choose the pivot as the element at the high index
        int pivot = array[highIndex];
        //get the index where the pivot should be placed
        int leftPointer = partition(array, lowIndex, highIndex, pivot);
        //recursively sort the left and right subarrays
        quickSort(array, lowIndex, leftPointer - 1);
        quickSort(array, leftPointer + 1, highIndex);
    }

    //function to partition the array and return the pivot's correct position
    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        //initializing left and right pointers
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        //loop until the left pointer is greater than the right pointer
        while (leftPointer < rightPointer) {
            //find an element on the left side that is greater than the pivot while being less than pivot and rp
            //incremement lp
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            //find an element on the right side that is less than the pivot
            //while being more than pivot and lp less then rp..decrement rp
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            // swap the elements at leftPointer and rightPointer as it loops through
            swap(array, leftPointer, rightPointer);

        }
        // Swap the pivot element (since we are choosing the high index as pivot each time) with the element at the leftPointer
        swap(array, leftPointer, highIndex);

        // Return the correct position of the pivot
        return leftPointer;
    }

    //function to swap two elements in the array that are being "pointed at"+
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}