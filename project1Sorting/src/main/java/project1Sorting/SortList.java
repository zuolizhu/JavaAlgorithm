package project1Sorting;

public class SortList {
    private int[] numberList;
    private int listLength;

    public void sort(int[] values) {
        if(values == null || values.length == 0) {
            return;
        }
        this.numberList = values;
        listLength = values.length;
        quicksort(0, listLength - 1);
    }

    private void quicksort(int low, int high) {
        int i = low;
        int j = high;
        // Get the pivot element from the middle of the list
        int pivot = numberList[low + (high-low)/2];

        while(i <= j) {
            while (numberList[i] < pivot) {
                i++;
            }
            while (numberList[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }

        if (low < j)
            quicksort(low, j);
        if(high > i)
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        int temp = numberList[i];
        numberList[i] = numberList[j];
        numberList[j] = temp;
    }


}
