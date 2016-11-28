package simpleexamples;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.*;

public class PanelExample {
    public static void main(String[] args) throws IOException {
        
        //create a comparator used in sorting arrays
        ArrayComparator sorter = new ArrayComparator();
        
        //create array with data with a number of columns
        String[][] data = {
            {"Wacky Races", "Any%", "00:25:00", "MaxieTheHatter"},
            {"Chakan", "Any%", "00:15:00", "Edenal"},
            {"World of Illusion", "Any% Co-Op", "00:30:00", "Edenal & Grukk"},
            {"Mega Man", "86 robot masters", "04:30:00", "Joka"},            
        };
        String[] columnNames = {"Game", "Category", "Estimate", "Runner"};
        //prints out current data to console as comparable before/after sorting
        System.out.println(toDataString(data));
        
        //create a table and a tableModel
        JTable table = new JTable(data, columnNames);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        //resize columns when you make them bigger/smaller
        table.setShowVerticalLines(false); //remove vertical lines in table
        setCellsAlignment(table, SwingConstants.CENTER);
        //allign text to center

        //Create the panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); //sets table to GridBagLayout   
        //defines GridBagConstraints, used for alligning elements
        GridBagConstraints c = new GridBagConstraints();
        panel.setOpaque(true); //allows us to use background color
        panel.setBackground(Color.DARK_GRAY); //set color of background

        //create new button with ("label")
        JButton sortGame = new JButton("Sort by game");
        c.fill = GridBagConstraints.CENTER; //allign button in the center
        c.insets = new Insets(5, 5, 5, 5); //padding for button
        c.gridy = 1; //put button at row 1, row 0 = table
        panel.add(sortGame, c);
        //create listener for button, determines what button does when pressed
        sortGame.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                /*
                sends following data to sortString in class ArrayComparator
                reverse: false
                table: data
                method: ESTIMATE(2)
                */
                sorter.sortString(false, data, SortingMethod.GAME);
                //test to see if data is sorted
                System.out.println(toDataString(data));
                //redraw the table
                panel.repaint();
            }
        });
        
        JButton sortEstimate = new JButton("Sort by Estimate");
        c.fill = GridBagConstraints.CENTER;
        c.insets = new Insets(5, 5, 5, 5);
        c.gridy = 2; //put button at row 2
        panel.add(sortEstimate, c);
        sortEstimate.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                sorter.sortString(false, data, SortingMethod.ESTIMATE);
                System.out.println(toDataString(data));
                panel.repaint();
            }
        });
        
        JButton sortCategory = new JButton("Sort by Category");
        c.fill = GridBagConstraints.CENTER;
        c.insets = new Insets(5, 5, 5, 5);
        c.gridy = 3; //put button at row 3
        panel.add(sortCategory, c);
        sortCategory.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                sorter.sortString(false, data, SortingMethod.CATEGORY);
                System.out.println(toDataString(data));
                panel.repaint();
            }
        });
        
        JButton sortRunner = new JButton("Sort by Runner");
        c.fill = GridBagConstraints.CENTER;
        c.insets = new Insets(5, 5, 5, 5);
        c.gridy = 4; //put button at row 4
        panel.add(sortRunner, c);
        sortRunner.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                sorter.sortString(false, data, SortingMethod.RUNNER);
                System.out.println(toDataString(data));
                panel.repaint();
            }
        });

        JButton exit = new JButton("Exit");
        //defins the anchor of the button, set to bottom right corner
        c.anchor = GridBagConstraints.BELOW_BASELINE_TRAILING;
        c.fill = GridBagConstraints.CENTER;
        c.insets = new Insets(5, 5, 5, 5); 
        c.gridy = 5; //allign with row 5
        exit.addActionListener(e -> System.exit(0));
        panel.add(exit, c);
        
        boolean changed = true;
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension (450, 88));
        //(x, y) eller (bredd, höjd) i pixlar

        //Create the top-level-container and add components to the containers
        //containers
        panel.add(scrollPane);
        JFrame frame = new JFrame("List of runs");
        frame.add(panel);
        //used if you want to set a fixed size to window
        //frame.setPreferredSize(new Dimension(1280, 1024));
        frame.setLocationRelativeTo(null); //centers window
        frame.setResizable(false); //prevents resizing of window
        //sets the icon image file
        frame.setIconImage(ImageIO.read(new File("src/image/ESA_Logo.png")));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //sets the visibility of the window, defaults to true if not defined
        frame.setVisible(true);
        frame.pack();


    }
    
    //method used for alligning text in cells
    public static void setCellsAlignment(JTable table, int alignment)
    {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);

        TableModel tableModel = table.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
    }
    
    //method for formatting output to console
    //if not defined prints memory allocation
    public static String toDataString(String data[][])
    {
        StringBuffer result = new StringBuffer();
        String seperator = ",";
        
        for(int i = 0; i < data.length; ++i)
        {
            result.append('[');
            for(int j = 0; j < data[i].length; ++j)
            {
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
