// Name: Akshay Deepak Hegde
// USC NetID: 8099460970
// CS 455 PA1
// Fall 2018

/*
 * To test coinTossSimulator
 * creates a coinTossSimulator object and simulation is run on it
 * results are displayed after each run and reset.
 */
public class CoinTossSimulatorTester {
	
	public void testResult(CoinTossSimulator test,int numberOfTrials){
	      System.out.println("After run"+"("+numberOfTrials+"):");
	      System.out.println("Number of trials "+"[exp:"+(numberOfTrials)+"]: "+test.getNumTrials());
	      System.out.println("Two-head tosses: "+test.getTwoHeads());
	      System.out.println("Two-tail tosses: "+test.getTwoTails());
	      System.out.println("One-head one-tail tosses: "+test.getHeadTails());
	      Boolean trueFalse=(test.getNumTrials()==test.getTwoHeads()+test.getTwoTails()+test.getHeadTails());
	      System.out.println("Tosses add up correctly? "+trueFalse);
	      System.out.println();
	    }
	public void testResultReset(CoinTossSimulator test,int numberOfTrials){
	     // System.out.println("After run"+"("+numberOfTrials+")");
	      System.out.println("Number of trials "+"[exp:"+(numberOfTrials)+"]: "+test.getNumTrials());
	      System.out.println("Two-head tosses: "+test.getTwoHeads());
	      System.out.println("Two-tail tosses: "+test.getTwoTails());
	      System.out.println("One-head one-tail tosses: "+test.getHeadTails());
	      Boolean trueFalse=(test.getNumTrials()==test.getTwoHeads()+test.getTwoTails()+test.getHeadTails());
	      System.out.println("Tosses add up correctly? "+trueFalse);
	      System.out.println();
	    }
	
	
	       //Tested the simulation for 1,10,100,1000 times as mentioned in the pdf.
	
	    public static void main(String[] args){
	      CoinTossSimulator runSimulator=new CoinTossSimulator();
	      CoinTossSimulatorTester testSimulation=new CoinTossSimulatorTester();
	      System.out.println("After constructor:");
	      runSimulator.run(0);
	      testSimulation.testResultReset(runSimulator,0);
	      runSimulator.run(1);
	      testSimulation.testResult(runSimulator,1);
	      runSimulator.run(10);
	      testSimulation.testResult(runSimulator,10);
	      runSimulator.run(100);
	      testSimulation.testResult(runSimulator,100);
	      System.out.println("After reset:");
	      runSimulator.run(0);
	      testSimulation.testResultReset(runSimulator,0);
	      runSimulator.run(1000);
	      testSimulation.testResult(runSimulator,1000);
	      //runSimulator.run(10000);
	      //testSimulation.testResult(runSimulator,10000);
	      runSimulator.reset();
	            
	    }

}
