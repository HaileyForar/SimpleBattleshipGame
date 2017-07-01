import java.util.*;



public class Game {

    	private MakeItHappen makeItHappen = new MakeItHappen();

    	private ArrayList<Battleship> battleshipList = new ArrayList<Battleship>();
	
    	private int numOfGuesses = 0;

	// set up the game will make three battle ship objects and puts them on the board    

    	private void setUpGame() 
	{

        Battleship one = new Battleship();

        one.setName("Destroyer"); 

        Battleship two = new Battleship();

        two.setName("Cruiser");

        Battleship three = new Battleship();

        three.setName("lightweight");

        battleshipList.add(one);

        battleshipList.add(two);

        battleshipList.add(three);

        

        System.out.println("Your mission if you choose to accept it is to sink all the ships!"); // instructions to the player 

        System.out.println("Destroyer, Cruiser and lightWeight!");

        System.out.println("Try to sink them all with fewest guesses");

        

        for (Battleship battleshipSet : battleshipList) // repeats with each battleship in the list
	{

            ArrayList<String> newLocation = makeItHappen.placeBattleship(3); // places battleship in location

            battleshipSet.setLocationCells(newLocation);

        }

    }

    

    private void startPlaying() 
    {

    while (!battleshipList.isEmpty()) { // game will continue until the battleship list is empty

    String userGuess = makeItHappen.getUserInput("Enter your guess"); // gets players guess

    checkUserGuess(userGuess); // uses checkUserGuess method with the players guess

    }

    finishGame(); // finish game method

    }

    

    private void checkUserGuess(String userGuess)

    {

    numOfGuesses++; // every guess made by the player this increments by 1

    String result = "miss"; // sets result to "miss" and will change if any of the below statement become true

        

        for (Battleship battleshipTest : battleshipList) // goes through the battleship list

        {

            result = battleshipTest.checkYourself(userGuess); // checks to see if the users guess is a "hit" or "kill"

            if (result.equals("hit"))

            {

                break;

            }

            if (result.equals("kill"))

            {

                battleshipList.remove(battleshipTest); // removes battleship from the list

                break;

            }

        }

        System.out.println(result); // will print "hit", "miss" or "kill" depsding on the out come of the above

    }

    
	// will print a message to give the player its result of the game

    	private void finishGame() 
	{

        System.out.println("All ships have been destroyed...congratulations ;) ");

        if (numOfGuesses <= 18) {

            System.out.println("It only took you " + numOfGuesses + " guesses");

            System.out.println("You are legendary!!!");

        }

        else

        {

            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");

            System.out.println("Good job they do not fire back!!! lol.");

        }

    }

	// main method which creates the game object, then sets up the boat on the board and then procreeds to playing the game    

    	public static void main(String[] args) 
	{

        Game game = new Game();

        game.setUpGame();

        game.startPlaying();

    	}

}