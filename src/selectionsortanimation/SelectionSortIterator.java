package selectionsortanimation;

import java.util.Iterator;

/**
 * Selection Sort Iterator.
 * 
 * It steps through each outer loop of the sort, .
 * 
 * @author majanedeljkovic
 */
public class SelectionSortIterator implements Iterator {
    int[] array;
    int counter = 0;
    int length;

    SelectionSortIterator(int arr[]) {
        this.array = arr;
        this.length = arr.length;
    }

    /**
     * Checks if sort has loops left to complete.
     * 
     * @return has next loop
     */
    @Override
    public boolean hasNext() {
        return counter < this.length;
    }

    /**
     * Goes once through the outer loop of the sort.
     * 
     * @return index of last element of the sorted subarray
     */
    @Override
    public Object next() {
        int j, minIndex = counter;
        int tmp;
        int n = length;

        for (j = counter + 1; j < n; j++) {
            if (array[j] < array[minIndex]) {
                minIndex = j;
            }
        }
        
        if (minIndex != counter) {
            tmp = array[counter];
            array[counter] = array[minIndex];
            array[minIndex] = tmp;
        }
        
        return counter++;
    }
}
