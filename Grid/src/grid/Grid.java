/**
   Dhruv Chaudhry
   Project 3
    4/29/2021
*/

package grid;
        
import java.util.Random;

public class Grid{
    // class fields
    private int[][] gameBoard;
    private int currentRow;
    private int currentCol;

    //for random numbers
    Random randomNumbers = new Random();

    // constants
    private final int MAX_ELEMENT_VALUE = 1000;

     //creates a 10x10 grid and sets random location
   
    public Grid(){
        gameBoard = new int[10][10];
        currentCol = 0;
        currentRow = 0;
	populateBoard();
        jump();
    }

  
     
    
    //constructor  - creates a grid (newGridSize x newGridSize) and sets random location
       
    public Grid(int newGridSize){
        gameBoard = new int[newGridSize][newGridSize];
        currentCol = 0;
        currentRow = 0;
    }
    //private method populateBoard to set locations to random value
   
    private void populateBoard(){
        int row, col;
        for (row = 0; row < getGridSize(); row++) {
            for (col = 0; col < getGridSize(); col++) {
                int randomValue = randomNumbers.nextInt(MAX_ELEMENT_VALUE);
                gameBoard[row][col] = randomValue;
            }
        }
        // use random to populate the elememts of a
        // two dimensional array
    }

   
    //jump method sets random location
    
    public void jump(){
        currentRow = randomNumbers.nextInt(getGridSize());
        currentCol = randomNumbers.nextInt(getGridSize());

                
    }

    
    //getCurrentRow method returns value in currentRow field and returns the value in currentRow field
    
    public int getCurrentRow(){
        return currentRow;
    }

    
    //getCurrentCol method returns value in currentCol field and returns the value in currentCol field
    
    public int getCurrentCol(){
        return currentCol;
    }

    
    //getCurrentValue method returns value in gameBoard at the currentRow currentCol field and returns the value in gameBoard[currentRow][currentCol]
    
    public int getCurrentValue(){
        return gameBoard[currentRow][currentCol];
    }

    
    //goNorth method decreases value in currentRow
   
    public void goNorth(){
        // decrease row (north)
         currentRow=-1;
        if (currentRow < 0) {
            currentRow = 0;
        }
    }
    
    //goSouth method increases value in currentRow
    
    public void goSouth(){
    // increase row (south)
        currentRow+=1;
        if (currentRow > (gameBoard.length - 1)) {
            currentRow = gameBoard.length - 1;
        }
    }

    
    //goWest method decreases value in currentCol
    
    public void goWest(){
        // decrease col (west)
        currentCol=-1;
        
        if (currentCol < 0) {
            currentCol=0;
        }
    }

    
    //gatherDaisies method decreases current location in grid by 80% and returns the value decremented and returns the value of 80% decrease in cell
    
    public int gatherDaisies(){
        int daisiesGathered;
        int total = gameBoard[currentRow][currentCol];
        daisiesGathered = (int) (total * 80.0 / 100.0);
        gameBoard[currentRow][currentCol] = total - daisiesGathered;

        return daisiesGathered;
    }

    
    //goEast method increases value in currentCol
    
    public void goEast(){
        // increase col (east)
        currentCol++;
        // make sure not greater than length-1
        if (currentCol > (gameBoard[0].length - 1)) {
         currentCol = gameBoard[0].length - 1;
        }
    }
    
     //getGridSize method returns size of grid and returns the value of gameBoard.length
    
    public int getGridSize(){
        return gameBoard.length;
    }

    
    //toString method used to return a String representing this Grid and returns a String representing this feild
    
    @Override
    public String toString()
    {
        String stringToReturn = "";
        int row, col;

        for (row = 0; row < gameBoard.length; row++)
        {
            for (col = 0; col < gameBoard.length; col++)
            {
                if (gameBoard[row][col] < 100)
                    stringToReturn = stringToReturn + " ";
                if (gameBoard[row][col] < 10)
                    stringToReturn = stringToReturn + " ";
                stringToReturn = stringToReturn + gameBoard[row][col] + " ";
            }
            stringToReturn = stringToReturn + "\n";
        }


        return stringToReturn;
    }
}