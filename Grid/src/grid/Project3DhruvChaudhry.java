/**
   Dhruv Chaudhry
   Project 3
    4/29/2021
*/
package grid;
import java.util.Scanner;
//main class
public class Project3DhruvChaudhry{
     
    public static void main(String[] args) {
         //creates a new grid 
        Grid grid = new Grid();
         //prints out the starung commands and grid
        System.out.println("Map of Grid: ");
        System.out.println(grid);
        //scanner initialization 
        Scanner uInput = new Scanner(System.in);
        String choice;
        int totalDaisies = 0;
           //loop which works with the gameflow 
        do{
            //series of output commands to provide the user with the options to play the game
            System.out.println("You are in Spot: ["+grid.getCurrentRow()+","+ grid.getCurrentCol() +"]");
            System.out.println("There are " + grid.getCurrentValue()+" daisies located here");
            System.out.println("You currently have a total of "+ totalDaisies + " daisies");
            System.out.println("What would you like to do? "+ "(G, J, N, S, E, W, M, Q):");
            //scanner storage for use in reading user input
            choice = uInput.nextLine();
        
            //go north command
            if (choice.equals("N")||(choice.equals("n"))){
                    
                grid.goNorth();
                    
            } 
            //go south command
            else if (choice.equals("S")||(choice.equals("s"))){
                grid.goSouth();
                   
            } 
            //go east command
            else if (choice.equals("E")||(choice.equals("e"))){
                grid.goEast();
                    
            } 
            //go west command
            else if (choice.equals("W")||(choice.equals("w"))){
                grid.goWest();
                
            }
            //gather daisies command
            else if (choice.equals("G")||(choice.equals("g"))){
                int daisies = grid.gatherDaisies();
                totalDaisies += daisies;
                System.out.println("You just gathered " + daisies+ " daisies from this spot");
                    
            }
            //jump command
            else if (choice.equals("J")||(choice.equals("j"))){
                grid.jump();
                System.out.println("Jumped to [" + grid.getCurrentRow()+","+ grid.getCurrentCol()+"]");
                    
            }  
            //show map command
            else if (choice.equals("M")||(choice.equals("m"))){
                System.out.println("Map of Grid: \n" + grid);
                   
            } 
            //end command
            else if (choice.equals("Q")||(choice.equals("q"))){
                System.out.println("Bye!");
                    
            } 
            //default/wrong command command
            else{
                System.out.println("Invalid choice");
                    
            }
            //while loop command
        }while (!choice.equalsIgnoreCase("Q"));
            
        
    }
    
}
        
            


     

