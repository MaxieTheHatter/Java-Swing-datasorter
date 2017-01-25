package SpeedrunSorter;

/**
 * Enums used to set which column to sort
 *
 * @author Maxie
 */
public enum SortingMethod {
    GAME(0), CATEGORY(1), ESTIMATE(2), RUNNER(3);

    private final int value;

    /**
     * Constructor for SortingMethod
     *
     * @param value value determined from Enum type
     * @see ViewGUI
     */
    SortingMethod(int value) {
        this.value = value;
    }

    /**
     * Getter for value
     *
     * @return a value used to determine which method to use
     */
    public int getValue() {
        return value;
    }

}
