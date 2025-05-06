import java.util.Arrays;
import java.util.Random;

public class Logical 
{
	
	 public static void wait(int miliSec) 
	 {
		 try {
			Thread.currentThread();
			Thread.sleep(miliSec * 400);
		 } catch (InterruptedException e) {
			 e.printStackTrace();
		 }
	 }

	public static void printMatrix(int [][]grid) 
	{
		System.out.println();
		for(int r=0; r<grid.length; r++) 
		{
			for(int c=0; c<grid[r].length; c++) 
				System.out.printf("%-5d",grid[r][c]);
			System.out.println(); // \n new line
		}
	}
	
	public static void buildLogicalMatrix(int []a,int [][]grid)
	{
		 int index=0;
		 int r;// = grid.length;
	     int c; // = grid[r].length;
	     
	     for(r=0; r<grid.length; r++) 
		    {
		       for(c=0; c<grid[r].length; c++) 
		       {
		    	   grid[r][c]=a[index++];
		    	   //printMatrix(grid);
		       }
		    }
	}
	public static boolean isFull(int []a)
	{
		for (int i=0 ; i<a.length ; i++)
			if (a[i]==0)
				return(false);
		return(true);
	}
	
	public static int howMany(int []a, int lookFor)
	{
		int mone=0;
		for (int i=0 ; i<a.length ; i++)
			if (a[i]==lookFor)
				mone++;
		return(mone);
	}
	
	public static boolean isExist(int []a, int lookFor)
	{
		for (int i=0 ; i<a.length ; i++)
			if (a[i]==lookFor)
				return(true);
		return(false);
	}
	
	public static void makeBoard()
	{
		AePlayWave voice;
		
		System.out.println("logical matrix At start:");
		
		Logical.printMatrix(Rashi.logical); // MyPrint
		System.out.println(Arrays.deepToString(Rashi.logical)+"\n"); // JavaPrint		
		System.out.println(Arrays.toString(Rashi.rand)); // JavaPrint
		while (!(Logical.isFull(Rashi.rand)))
		{
			//System.out.println("Enter number between 1.."+((Rashi.N*Rashi.M)/2)+":");
			//Rashi.r=Rashi.kelet.nextInt();
			Random rand = new Random();
			Rashi.r = rand.nextInt(Rashi.N*Rashi.M)/2;
			Rashi.r++; // avoid zero!
			//System.out.println("r is: "+Rashi.r);
			switch (Logical.howMany(Rashi.rand,Rashi.r)) 
			{
				case 0: 
				case 1:
					Rashi.rand[Rashi.index++]=Rashi.r;
					break;
				case 2: // NOP!
				    System.err.println(Rashi.r+ " allready exist!");
				    voice=new AePlayWave("af.wav");
				    voice.start(); // run()
				    wait(1);
				    break;

				default: // NOP!
				
				     break;
			}
			
			System.out.println(Arrays.toString(Rashi.rand)); // JavaPrint
		}
		System.out.println("Final: "+Arrays.toString(Rashi.rand)); // JavaPrint
		Logical.buildLogicalMatrix(Rashi.rand,Rashi.logical);
		System.out.println("logical matrix At end:");
		Logical.printMatrix(Rashi.logical); // MyPrint
		System.out.println(Arrays.deepToString(Rashi.logical)+"\n"); // JavaPrint
		
	}

}
