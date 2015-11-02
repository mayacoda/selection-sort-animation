package selectionsortanimation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Visual representation of the array being sorted
 * 
 * @author majanedeljkovic
 */
public class HistogramPanel extends JPanel {

    private int[] array;
    private int current;
    private final int TOTAL_HEIGHT = 400;
    private final int TOTAL_WIDTH = 760;

    HistogramPanel() {
        setPreferredSize(new Dimension(this.TOTAL_WIDTH, this.TOTAL_HEIGHT));
    }

    /**
     * Renders the view for the current array being sorted.
     * @param g 
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.white);
        
        // calculate dimensions
        int width = this.TOTAL_WIDTH / SelectionSortAnimation.ELEMENTS_COUNT;
        int intHeight = this.TOTAL_HEIGHT / SelectionSortAnimation.MAX_ELEMENT;

        // render each bar of the histogram
        for (int i = 0; i < this.array.length; i++) {
            int height = intHeight * this.array[i];
            
            if (i == current) { g.setColor(Color.black); } else { g.setColor(Color.white); }
            
            g.fillRect(i * width, this.TOTAL_HEIGHT - height, width, height);
            g.setColor(Color.black);
            g.drawRect(i * width, this.TOTAL_HEIGHT - height, width, height);


            if (i == current) { g.setColor(Color.white); } else { g.setColor(Color.black); }
            g.drawString(String.valueOf(this.array[i]),
                    i * width + width / 2 - 7,
                    this.TOTAL_HEIGHT - (height / 2));
        }
    }
    
    // rerender with new array and current position
    public void updateHistogram (int[] array, int current) {
        this.array = array;
        this.current = current;
        repaint();
    }
}
