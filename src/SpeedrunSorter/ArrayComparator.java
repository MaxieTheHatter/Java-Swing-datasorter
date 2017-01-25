package SpeedrunSorter;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Class that compares values in an Array.
 * Used to sort the data Array
 *
 * @author Maxie
 * @see ModelGUI
 */
public class ArrayComparator {

/**
 * Method used to compare String in an mutliArray
 */
public class ArrayStringSorter implements Comparator<String[]> {
    int index;
    boolean reverse;

    public int compare(String[] array1, String[] array2) {
        //if reverse is true, run first line, else run second line
        //determines in which order to sort data
        return reverse ? -array1[index].compareTo(array2[index]) :
                array1[index].compareTo(array2[index]);
    }

}

    //sets ArrayStringSorter as variable sortArrays
    ArrayStringSorter sortArrays;

    /**
     * Constructor, creates a new StringSorter from variable sortArrays
     */
    public ArrayComparator() {
        this.sortArrays = new ArrayStringSorter();
    }

    /**
     * Runs ArrayStringSorter(), sortingMethod() is used to get value from SortingMethod
     * The value is used to determing which method to use
     *
     * @param reverse       Determines in which order to sort, if true sort in reverse order
     * @param arrayInput    MultiArray data containing the information to be sorted
     * @param sortingMethod Determines which column to sort
     * @see ModelGUI
     * @see ViewGUI
     */
    public void sortString(boolean reverse, String[][] arrayInput,
                           SortingMethod sortingMethod) {
        sortArrays.reverse = reverse;
        //gets index number from enum SortingMethod
        sortArrays.index = sortingMethod.getValue();
        Arrays.sort(arrayInput, sortArrays);

    }

}
