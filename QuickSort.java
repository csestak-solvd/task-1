public class QuickSort {
    public static void main(String[] args) {
        //intializing array of random numbers
        int[] array = {12,4,5,6,7,3,1,15};
        //quickSort is main sorting function for the array
        quickSort(array, 0, array.length - 1);
        System.out.println("Sorted");
        for (int value : array) {
            System.out.println(value + " ");
        }
    }
//quickSort checks if the low index is less than the high index
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            //if true it means there is more than one element to sort
            //proceeds to partition and recursively sort the subarrayss
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
//partition is a helper function
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}