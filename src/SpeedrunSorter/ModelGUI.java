package SpeedrunSorter;

/**
 * Model class by MVC principle
 * Handles all the data used
 *
 * @author Maxie
 */
public class ModelGUI {

    /**
     * Data used in JTable
     */
    private String[][] data = {
            {"Wacky Races", "Any%", "00:25:00", "MaxieTheHatter"},
            {"Chakan", "Any%", "00:15:00", "Edenal"},
            {"World of Illusion", "Any% Co-Op", "00:30:00", "Edenal & Grukk"},
            {"Mega Man", "86 robot masters", "04:30:00", "Joka"},
    };
    private String[] columnNames = {"Game", "Category", "Estimate", "Runner"};

    /**
     * Getter for dataTable
     *
     * @return Returns MultiArray containing the data
     */
    public String[][] getData() {
        return this.data;
    }

    /**
     * Getter for columnNames
     *
     * @return Returns the name of every column in the JTable
     */
    public String[] getColumnNames() {
        return this.columnNames;
    }
}
