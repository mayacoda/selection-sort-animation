package selectionsortanimation;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;
import javax.swing.*;

/**
 * Holds the view and logic.
 * 
 * It is responsible for initializing buttons, creating the view,
 * calling the sort algorithm and updating the histogram.
 * 
 * @author majanedeljkovic
 */
public class SelectionSort extends JPanel {

    private JButton stepBtn;
    private JButton resetBtn;
    private SelectionSortIterator it;
    private int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    private HistogramPanel histogram;

    SelectionSort() {
        stepBtn = new JButton("Step");
        resetBtn = new JButton("Reset");

        // register an event listener for the reset button
        resetBtn.addActionListener((ActionEvent e) -> {
            reset();
        });

        // register an event listener for the step button
        stepBtn.addActionListener((ActionEvent e) -> {
             
            // checks if the SelectionSortIterator has another step
            if (it.hasNext()) {
                
                // updates the view with the new position
                int current = (int) it.next();
                System.out.println(Arrays.toString(this.array));
                
                updateView(current);
                
            // if sort has finished, display a message
            } else {
                JOptionPane.showMessageDialog(null, "Sort has finished");
            }
        });
                

        // adding components the the main panel
        JPanel buttons = new JPanel();
        buttons.add(stepBtn);
        buttons.add(resetBtn);

        add(buttons, BorderLayout.SOUTH);
        
        histogram = new HistogramPanel();
        histogram.updateHistogram(this.array, 0);
        add(histogram, BorderLayout.CENTER);
        
        // reset array to random order
        reset();
    }

    /**
     * Resets the array to a random order and redraws the view.
     */
    private void reset() {
        // shuffle the existing array of 20 ints to a random order
        for (int i = 0; i < this.array.length; i++) {
            Random r = new Random();
            int swapIndex = r.nextInt(i + 1);

            int temp = this.array[i];
            this.array[i] = this.array[swapIndex];
            this.array[swapIndex] = temp;
        }

        this.it = new SelectionSortIterator(this.array);

        // initialize the panel
        updateView(0);
    }
    
    /**
     * Triggers histogram view update.
     * 
     * Passes to updateHistogram the newly sorted array and the 
     * current position within the sort
     * 
     * @param current 
     */
    private void updateView(int current) {
        this.histogram.updateHistogram(this.array, current);
    }
}
