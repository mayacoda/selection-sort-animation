package selectionsortanimation;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author majanedeljkovic
 */
public class SelectionSortAnimation extends JApplet {
    static int MAX_ELEMENT = 20;
    static int ELEMENTS_COUNT = 20;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        JFrame frame = new JFrame("Selection Sort Animation");
        SelectionSortAnimation sortAnimation = new SelectionSortAnimation();

        frame.add(sortAnimation, BorderLayout.CENTER);
        sortAnimation.init();
        sortAnimation.start();

        SelectionSort sortPanel = new SelectionSort();
        sortAnimation.add(sortPanel, BorderLayout.CENTER);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
