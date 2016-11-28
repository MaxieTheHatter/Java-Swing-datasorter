package simpleexamples;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayComparator {
   
    public class ArrayStringSorter implements Comparator<String[]> {
        int index;
        boolean reverse;
        public int compare(String[] array1, String[] array2)
        {
            //if reverse is true, run first line, else run second line
            //determines in which order to sort data
            return reverse? -array1[index].compareTo(array2[index]):
                    array1[index].compareTo(array2[index]);
        }
        
    }
    
    //sets ArrayStringSorter as variable sortArrays
    ArrayStringSorter sortArrays;
    
    public ArrayComparator()
    {
        this.sortArrays = new ArrayStringSorter();
    }
    
    //runs ArrayStringSorter, SortingMethod takes in an enum to determine
    //which SortingMethod to use
    public void sortString(boolean reverse, String[][] arrayInput,
            SortingMethod sortingMethod)
    {
        sortArrays.reverse = reverse;
        //gets index number from enum SortingMethod
        sortArrays.index = sortingMethod.getValue();
        Arrays.sort(arrayInput, sortArrays);
        
    }

}
