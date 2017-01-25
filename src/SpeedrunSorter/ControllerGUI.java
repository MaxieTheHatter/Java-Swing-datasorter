package SpeedrunSorter;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.*;

/**
 * Controller by MVC principle.
 * Manipulates data from Model and displays it in view
 *
 * @author Maxie
 */
public class ControllerGUI {

    /**
     * Constructor for Controller.
     * Creates a View and feeds it data from a Model.
     * It also adds recurring ActionListeners
     *
     * @throws IOException Catches error in icon image
     * @see ViewGUI
     */
    public ControllerGUI() throws IOException {
        ModelGUI modelGUI = new ModelGUI();
        String[][] data = modelGUI.getData();
        String[] columnNames = modelGUI.getColumnNames();
        System.out.println(toDataString(data));
        ViewGUI viewGUI = new ViewGUI(data, columnNames);
        ExitListener exit = new ExitListener();
        ArrayComparator sorter = new ArrayComparator();

        viewGUI.setSorter(sorter);
        viewGUI.getExitButton().addActionListener(exit);
        viewGUI.getExitOption().addActionListener(exit);
    }


    public static void main(String[] args) throws IOException {

        ControllerGUI controllerGUI = new ControllerGUI();
    }

    /**
     * Creates an ActionListener used when exiting the program.
     *
     * @see ViewGUI
     */
    private static class ExitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int confirmExit = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to exit?", null, JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE);
            if (confirmExit == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    /**
     * Method used to print MultiArray data to console.
     * Used only for debugging
     *
     * @param data MultiArray containing data displayed in JTable
     * @return String containing all the data in MultiArray data
     */
    public static String toDataString(String data[][]) {
        StringBuffer result = new StringBuffer();
        String seperator = ", ";

        for (int i = 0; i < data.length; ++i) {
            result.append('[');
            for (int j = 0; j < data[i].length; ++j) {
                if (j > 0)
                    result.append(data[i][j]).append(seperator);
                else
                    result.append(data[i][j]).append(seperator);
            }
            result.append("]\n");

        }
        return result.toString();
    }

}


