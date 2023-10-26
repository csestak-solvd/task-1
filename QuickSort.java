public class QuickSort {
    public static void main(String[] args) {
        //intializing array of random numbers
        int[] array = {12,4,5,6,17,3,1,7};
        //quickSort is main sorting function for the array
        quickSort(array, 0, array.length - 1);
        System.out.println("Sorted");
        for (int value : array) {
            System.out.println(value + " ");
        }
    }
//quickSort checks if the low index is less than the high index
    private static void quickSort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }

        int pivot = array[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        while (leftPointer<rightPointer) {
            while(array[leftPointer]<= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (array[rightPointer]>= pivot && leftPointer<rightPointer) {
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);

        }
        swap(array, leftPointer, highIndexs);
        quickSort(array,lowIndex, leftPointer -1);
        quickSort(array, leftPointer +1, highIndex);
    }
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}