import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Collections;
import java.util.LinkedList;
import java.util.*;

/* Starter code for PS8.
 */

public class MovieRanker 
{

	public static void main(String[] args) 
   {
        File file = new File("C:\\Users\\dhruv\\Downloads\\ratingsFinal.txt\\");
		ArrayList<MovieRating> rl = new ArrayList<MovieRating>();
		try 
		{
			Scanner scanner = new Scanner(file,"UTF-8");
			while (scanner.hasNextLine()) 
			{
				String line = scanner.nextLine();
                String[] tkns = line.split("\\t"); // tabs separate tokens
                MovieRating nr = new MovieRating(tkns[0], tkns[1], tkns[2]);
                rl.add(nr);
			}
			scanner.close();
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		int minVotes = 1;
		int numRecords = 1;
		Scanner input = new Scanner(System.in);
		while (true) 
		{
			System.out.println();
			System.out.println("Enter minimum vote threshold and number of records:");
			minVotes = input.nextInt();
			numRecords = input.nextInt();
			if (minVotes * numRecords == 0)
				break;
			long startTime = System.currentTimeMillis();
			System.out.println();
/* Fill in code to determine the top numRecords movies that have at least
 * minVotes votes. For each record mr, in decreasing order of average rating,
 * execute a System.out.println(mr).
 * Do not sort the movie list!
 */
			MaxHeap<MovieRating> result = new MaxHeap<MovieRating>();
            for(MovieRating rating: rl)
            	if(rating.getVotes()>= minVotes)
					result.insert(rating);
            
            for(int i =0; i<numRecords;i++){
                if(result.isEmpty() == true){
                    break;
                }
                System.out.println(result.removemax());
            }
            
            long readTime = System.currentTimeMillis();
			System.out.println("\nTime: "+(System.currentTimeMillis()-startTime)+" ms");
			
		}
	}
}
