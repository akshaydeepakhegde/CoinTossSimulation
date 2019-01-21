// Name: Akshay Deepak Hegde
// USC NetID: 8099460970
// CS 455 PA1
// Fall 2018

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */

import java.util.Random;

public class CoinTossSimulator {
	
	private static final int RANDOM_CHOICES = 2; //Output is either 0 or 1 -simulates a coin flip
	private static final int HEADS = 0; // Consider 0 as heads
	private int numTrials;
	private int twoHeads;
	private int twoTails;
	private int headTails;


   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {

   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   
   public void run(int numTrials) {
	   reset();
	   Random randNumber = new Random();
	   for (int i = 0; i<numTrials; i++)
	   {
		   int firstToss = randNumber.nextInt(RANDOM_CHOICES);
		   int secondToss = randNumber.nextInt(RANDOM_CHOICES);
		   
		   if(firstToss == secondToss) {
			   if(firstToss == HEADS) {
				   twoHeads++;
			   }
			   else {
				   twoTails++;
			   }
		   }
		   else {
			   headTails++;
		   }
	   }
 
   }


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
	   numTrials = twoHeads + headTails + twoTails;
       return numTrials; 
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return twoHeads; 
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return twoTails; 
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return headTails; 
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
	   twoHeads = 0;
	   twoTails = 0;
	   headTails = 0;
	   
   }

}
