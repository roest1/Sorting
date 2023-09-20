/**
 * @author rileyoest
 */
public class SortingAlgorithms {
    /**
    selection sort

    Time Complexity ∈ Ο(n²) for comparisons and swaps in all cases.
    Space Complexity ∈ O(1) as it sorts in-place.
    */
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

    /**
    insertion sort
    
    Time Complexity:
    * Worst and Avg cases ∈ O(n²) for comparisons and swaps.
    * Best case ∈ Ο(n) if array is already sorted
    Space Complexity ∈ O(1) as it sorts in-place.
     */
    public static void insertionSort(int[] array) {
        int i, key, j;
        for (i = 1; i < array.length; i++) {
            key = array[i];
            j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    /*
     bubble sort

    Time Complexity:
    * Worst and Avg cases ∈ O(n²) for comparisons and swaps.
    * Best case ∈ Ο(n) if array is already sorted
    Space Complexity ∈ O(1) as it sorts in-place.
    */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - j; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /*
     short circuit bubble sort

    Time Complexity:
    * Worst case ∈ O(n²) for comparisons and swaps.
    * Avg & Best cases ∈ O(n) since we know the array is sorted when we stop making swaps
    Space Complexity ∈ O(1) as it sorts in-place.
    */
    public static void bubbleSortSC(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }

    /*
     merge sort

    Time Complexity ∈ O(nlog(n)) in all cases
    Space Complexity ∈ O(n) for using arrays
    */
    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return;
        }
        int mid = array.length / 2;
        int[] l = new int[mid];
        int[] r = new int[array.length - mid];
        for (int i = 0; i < mid; i++) {
            l[i] = array[i];
        }
        for (int i = mid; i < array.length; i++) {
            r[i - mid] = array[i];
        }
        mergeSort(l);
        mergeSort(r);
        merge(array, l, r, mid, array.length - mid);

    }
    public static void merge(int[] array, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                array[k] = l[i];
                i++;
            } else {
                array[k] = r[j];
                j++;
            }
            k++;
        }
        while (i < left) {
            array[k++] = l[i++];
        }
        while (j < right) {
            array[k++] = r[j++];
        }
    }

    /*
     quick sort

    Time Complexity:
    * Worst case ∈ O(n²) for comparisons and swaps.
    * Best & Avg cases ∈ Ο(nlog(n)) when pivot selection is well balanced
    Space Complexity ∈ O(1) as it sorts in-place.
    */
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    /**
    This function takes last element as pivot, places
    the pivot element at its correct position in sorted
    array, and places all smaller (smaller than pivot)
    to left of pivot and all greater elements to right
    of pivot 
    */
    static int partition(int[] arr, int low, int high) {

        // pivot
        int pivot = arr[high];

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /* 
    The main function that implements QuickSort
        arr[] --> Array to be sorted,
        low --> Starting index,
        high --> Ending index
     */
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     gnome Sort
     
    Time Complexity:
    * Worst and Avg cases ∈ O(n²) for comparisons and swaps.
    * Best case ∈ Ο(n) if array is already sorted
    Space Complexity ∈ O(1) as it sorts in-place.
    */
    public static void gnomeSort(int arr[]) {
        int index = 0;

        while (index < arr.length) {
            if (index == 0) {
                index++;
            }
            if (arr[index] >= arr[index - 1]) {
                index++;
            } else {
                int temp = 0;
                temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
        return;
    }
}

