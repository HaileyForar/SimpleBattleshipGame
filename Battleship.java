import java.util.ArrayList;



public class Battleship {

private ArrayList<String> locationCells; // ArrayList of the cells locations
private String name; // the BattleShip name

public void setName(String string) 
{
name = string;
}
    

public void setLocationCells(ArrayList<String> loc)
{
locationCells = loc; // Updates the battleships location from the MakeItHappen class
}

public String checkYourself(String userInput)
{
String result = "miss";

int index = locationCells.indexOf(userInput);	// if the userGuess is one of the cells 
						// in the ArrayList indexOf() will return its ArrayList
						// if its not it will return -1
if (index >= 0) 
{
	locationCells.remove(index); 		// if equal or greater then 0 the cell is deleted
	if (locationCells.isEmpty()) 		// if there after the Arraylist is empty then it will result in a kill
	{
	result = "kill";
	}
	else
	{
	result = "hit";
	}
	}
return result; // returns hit miss or kill
}

}