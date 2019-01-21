// Name: Akshay Deepak Hegde
// USC NetID: 8099460970
// CS 455 PA1
// Fall 2018

/*
 * extends JComponent
 * constructor initialization and runs simulation using CoinTossSimulator class
 * overrides paintComponent to draw the bar graph using Bar class
 * 
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class CoinSimComponent extends JComponent
{
	private int numberOfTrials;
	private static final int VERTICAL_BUFFER = 50;//constant vb
    private static final int BAR_WIDTH = 50;//constant bw
    private static final int HUNDRED_PERCENT = 100; //  to get percentage values
    private static final Color TWOHEADS_BAR_COLOR = Color.RED; // Coloring to bars
    private static final Color HEADTAILS_COLOR = Color.GREEN;
    private static final Color TWOTAILSS_BAR_COLOR = Color.BLUE;
	
    // constructor to assign the number of trials to 'numberOfTrials' variable
	public CoinSimComponent(int trials)
	{
		numberOfTrials = trials;
	}
	
	// override paintComponent to represent 3 bars for the simulation
	public void paintComponent(Graphics g)
	   {  
	      Graphics2D g2 = (Graphics2D) g;
	      CoinTossSimulator coinToss = new CoinTossSimulator();
	      coinToss.run(numberOfTrials);
	      
	      String label = "Hello, world!";   
	      Font font = g2.getFont();
	      FontRenderContext context = g2.getFontRenderContext();
	      Rectangle2D labelBounds = font.getStringBounds(label, context);
	      int widthOfLabel = (int) Math.ceil(labelBounds.getWidth());
	      int heightOfLabel = (int) Math.ceil(labelBounds.getHeight());
	      
	      // get results of the coin toss simulation
	      int numTrials = coinToss.getNumTrials();
	      int twoHeads = coinToss.getTwoHeads();
	      int twoTails = coinToss.getTwoTails();
	      int headTails = coinToss.getHeadTails();
	      
	      // parameters of the draw() method; applicable to all bars.
	      int bottom = getHeight() - VERTICAL_BUFFER;
	      //since getWidth() = (4*w)+(3*bw) and w=widthFactor
	      int widthFactor = ((getWidth())-(BAR_WIDTH*3))/4;
	      //since (scale*barHeight)+(2*vb)+heightOfLabel = getHeight()
	      //int max = Math.max(Math.max(twoHeads, twoTails),headTails);
	      double s = (double)coinToss.getNumTrials()/(getHeight() - (2*VERTICAL_BUFFER) - heightOfLabel);
	    		  
	      
	      // Two heads bar
	      int TwoHeadsPercent = (int) Math.round((((double) (twoHeads) / numTrials) * HUNDRED_PERCENT));
	      String twoHeadsLabel = "Two Heads: " + twoHeads + " (" + TwoHeadsPercent + "%)";
	      Bar twoHeadsBar = new Bar(bottom, widthFactor, BAR_WIDTH, twoHeads, s, TWOHEADS_BAR_COLOR, twoHeadsLabel);
	      
	      // HeadTails bar
	      int HeadTailPercent = (int) Math.round((((double) (headTails) / numTrials) * HUNDRED_PERCENT));
	      String HeadTailResult = "A Head and a Tail: " + headTails + " (" + HeadTailPercent + "%)";
	      Bar headTailsBar = new Bar(bottom, (2*widthFactor)+(BAR_WIDTH), BAR_WIDTH, headTails, s, HEADTAILS_COLOR, HeadTailResult);
	      
	      // Two tails bar
	      int TwoTailsPercent = (int) Math.round((((double) (twoTails) / numTrials) * HUNDRED_PERCENT));
	      String TwoTailsResult = "Two Tails: " + twoTails + " (" + TwoTailsPercent + "%)";
	      Bar twoTailsBar = new Bar(bottom, (3*widthFactor)+(2*BAR_WIDTH), BAR_WIDTH, twoTails, s, TWOTAILSS_BAR_COLOR, TwoTailsResult);
	      
	      twoHeadsBar.draw(g2);
	      headTailsBar.draw(g2);
	      twoTailsBar.draw(g2);
	   }
	
}
