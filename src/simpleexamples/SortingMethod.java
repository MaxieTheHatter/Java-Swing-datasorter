package simpleexamples;
/*
enums for determining what to sort.
Numbers determine which column is to be sorted.
*/
public enum SortingMethod {
    GAME(0), CATEGORY(1), ESTIMATE(2), RUNNER(3);
    
    private final int value;
    private SortingMethod(int value)
    {
        this.value = value;
    }
    
    public int getValue()
    {
        return value;
    }
    
}
