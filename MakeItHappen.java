import java.io.*;

import java.util.*;



public class MakeItHappen 
{



  private static final String alphabet = "abcdefg"; // sets a string abcdefg for the grid

  private int gridLength = 7; // length of the grid

  private int gridSize = 49; // how many cells it will contain 7 x 7 = 49 ;)

  private int [] grid = new int[gridSize]; // creates an array called grid

  private int shipCount = 0; // sets ship count to 0





  public String getUserInput(String prompt) 
    { // asks user for a guess 

     String inputLine = null;

     System.out.print(prompt + "  ");

     try {

       BufferedReader is = new BufferedReader(

	 new InputStreamReader(System.in));

       inputLine = is.readLine();

       if (inputLine.length() == 0 )  return null; 

     } catch (IOException e) {

       System.out.println("IOException: " + e);

     }

     return inputLine.toLowerCase();

  }



  

  

   public ArrayList<String> placeBattleship(int shipSize) 
   {               

    ArrayList<String> alphabetCells = new ArrayList<String>();

    String [] alphacoordinates = new String [shipSize];      	// holds coordinates 

    String temp = null;                               		// temporary String for concat

    int [] coordinates = new int[shipSize];                  	// current candidate coords

    int attempts = 0;                                  		// current attempts counter

    boolean success = false;                           		// flag = found a good location ?

    int location = 0;                                  		// current starting location

    

    shipCount++;                                        	// battleship to place

    int increment = 1;                                      	// set horizontal increment

    if ((shipCount % 2) == 1) {                         	// if odd dot com  (place vertically)

      increment = gridLength;                               	// set vertical increment

    }



    while ( !success & attempts++ < 200 ) {             

	location = (int) (Math.random() * gridSize);      	// gets a random starting point within the grid

        //System.out.print(" try " + location); 		

	int x = 0;                                        	

        success = true;                                 	

        while (success && x < shipSize) {                	// looking for unused cells on the board

          if (grid[location] == 0) {                     	// if not already used

             coordinates[x++] = location;                      	// saves that location

             location += increment;                            	// increments location

             if (location >= gridSize){                        	// out of bounds - 'bottom'

             success = false;                                	// failure

             }

             if (x>0 & (location % gridLength == 0)) {  	// out of bounds - right edge

               success = false;                         	// failure

             }

        } 
	else 
        {                                     			 // found already used location

        // System.out.print(" used " + location);  

        success = false;                          		// failure

        }

        }

    }



    int x = 0;                                          	// turns good location into alpha coords

    int row = 0;

    int column = 0;

    // System.out.println("\n");

    while (x < shipSize) {

      grid[coordinates[x]] = 1;                              	// mark master grid pts. as 'used'

      row = (int) (coordinates[x] / gridLength);             	// gets row value

      column = coordinates[x] % gridLength;                  	// gets numeric column value

      temp = String.valueOf(alphabet.charAt(column));   	// converts to alpha

      

      alphabetCells.add(temp.concat(Integer.toString(row)));

      x++;



      //System.out.print("  coordinates "+x+" = " + alphabetCells.get(x-1)); //uncomment to cheat!!!

      

    }

     //System.out.println("\n"); // and this one makes it look pretty lol

    

    return alphabetCells;

   }

}