// Name: Akshay Deepak Hegde
// USC NetID: 8099460970
// CS 455 PA1
// Fall 2018

/*
 * Contains the 'main' method
 * Prompts for user to give number of trials as console input
 * CoinSimComponent is created to run simulation and draw results of simulation
 * creates JFrame containing the CoinSimComponent.
 */

import java.util.Scanner;
import javax.swing.JFrame;

public class CoinSimViewer 
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of trials: ");
		int numberOfTrials = in.nextInt();
		while(numberOfTrials<=0) 
		{
			System.out.println("ERROR: Number entered must be greater than 0.");
            System.out.print("Enter number of trials: ");
            numberOfTrials = in.nextInt();
		}
		
		// To create JFrame containing CoinSimComponent
		JFrame frame = new JFrame();
	    frame.setSize(500, 800);
	    frame.setTitle("CoinSim");
	    
	    // To set JFrame to exit on close button press
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    // To add component(CoinSimComponent object) to frame(JFrame)
        CoinSimComponent component = new CoinSimComponent(numberOfTrials);
	    frame.add(component);

	    // To display frame
	    frame.setVisible(true);
	    
	    // To close the scanner 'in'
	    in.close();
	}

}
