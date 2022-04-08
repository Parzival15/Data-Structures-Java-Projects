import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/** Identify a common 5-letter English word that has the following property:
 * Removing the first letter or the second letter results in words with the
 * same pronunciation as the original word.
 */

public class MaxHomophones {

	public static void main(String[] args) {
		UALDictionary<String, Pronunciation> PDict = new UALDictionary<String, Pronunciation>();
        OALDictionary<String, ArrayList> newDict = new OALDictionary<String, ArrayList>();
		
		File file = new File("C:\\Users\\seanu\\Desktop\\School\\CS\\CS 114\\PS5\\cmudict.0.7a.txt");
	    Scanner newObj = new Scanner(System.in);
		int count = 0;
		int lineLim = newObj.nextInt();
		
		


		//long start = System.currentTimeMillis();

		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine() && count != lineLim) {
				String line = scanner.nextLine();
				
				if (line.substring(0, 3).equals(";;;"))
					continue; // skip comment lines
				Pronunciation p = new Pronunciation(line);
				PDict.insert(p.getWord(), p);
				count++;
			}
			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		//long middle = System.currentTimeMillis();

		//System.out.println("Loaded dictionary.");

		for (Pronunciation p : PDict.values()) {
			if (newDict.find(p.getPhonemes()) == null)
			{
				ArrayList<String> addword = new ArrayList<String>();
				addword.add(p.getWord());
				newDict.insert(p.getPhonemes(), addword);
			}
			else {
				newDict.find(p.getPhonemes()).add(p.getWord());
			}
		}
		
		int count2 = 0;

		for (ArrayList<String> addWord : newDict.values()) {
			if (addWord.size() > count2) {
				count2 = addWord.size();
			}
		}

		System.out.println(count2);

		for (ArrayList<String> addWord : newDict.values()) {
			if (addWord.size() == count2) {
				for (String word : addWord) {
					System.out.println(addWord);
				}
				System.out.println();
			}
		}
		

		//long end = System.currentTimeMillis();
		
		/*System.out.println("Run times: load dictionary= " + (middle - start)
				+ " process= " + (end - middle) + " total= " + (end - start));
	*/}
}