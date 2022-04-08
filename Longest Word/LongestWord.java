import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class LongestWord {

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		String userInput=sc.next();
		sc.close();

		findTheLongestWords(userInput);
	}
	
	public static void findTheLongestWords(String input) throws FileNotFoundException{
		ArrayList<String> allSubsets=new ArrayList<String>();
		subsets(input,allSubsets);
		sortedStrArrayLst(allSubsets);
		
		ArrayList<String> txtFileWordsUnsorted= new ArrayList<String>();
		ArrayList<String> txtFileWordsSorted= new ArrayList<String>();
		File wordsTxtFile= new File("C:\\Users\\dhruv\\OneDrive\\Desktop\\trial\\words.txt\\");
		Scanner allOfTheWordsScanner=new Scanner(wordsTxtFile);
		while(allOfTheWordsScanner.hasNextLine()){
			String wordInTxtFile=allOfTheWordsScanner.nextLine();
			txtFileWordsSorted.add(sortedStr(wordInTxtFile));
			txtFileWordsUnsorted.add(wordInTxtFile);
		}
		allOfTheWordsScanner.close();
//"C:\\Users\\dhruv\\Downloads\\ratingsFinal.txt\\"
		ArrayList<String> correctWords= new ArrayList<String>();

		for(int i=0;i<allSubsets.size();i++){
			if(txtFileWordsSorted.contains(allSubsets.get(i))){
				int index=txtFileWordsSorted.indexOf(allSubsets.get(i));
				correctWords.add(txtFileWordsUnsorted.get(index));
			} 
		}

		int correctWordsLen=correctWords.size();

		int biggestLen=0;
		for(int i=0;i<correctWordsLen;i++){
			if(correctWords.get(i).length()>biggestLen){
				biggestLen=correctWords.get(i).length();
			}
		}
		for(int i=0;i<correctWordsLen;i++){
			if(correctWords.get(i).length()==biggestLen){
				System.out.println(correctWords.get(i));
			}
		}
	}
	
	public static String sortedStr(String str){
		char[] charArr = str.toCharArray();
                for (int i = 1; i < charArr.length; i++)
                  for (int j = i; (j > 0) && (charArr[j] < charArr[j - 1]); j--) {
                    char tmp = charArr[j];
                    charArr[j] = charArr[j-1];
                    charArr[j-1] = tmp;
                  }
		return new String(charArr);
	}
	
	public static void subsets(String str, ArrayList<String> allSubsets){
		int len = str.length();  
        String arr[] = new String[len];
		
		if(str.length()==1){
			return;
		}
        for(int i = 0; i < len; i++) { 
			int endInd=i+len-1; 
			endInd=endInd>len-1?endInd-len:endInd;
			if(endInd>i){
				arr[i]=str.substring(i,endInd); 
			}
			else{
				arr[i]=str.substring(i)+str.substring(0, endInd); 
			}
        }

		for(String theWord:arr){ 
			String aWord=sortedStr(theWord);
			if(!allSubsets.contains(aWord))
				allSubsets.add(aWord);
			subsets(aWord,allSubsets);
		}
	}

	public static void sortedStrArrayLst(ArrayList<String> list){
		int lstSize=list.size();
		//bubble sort
		//pust in aplhabetical order
		for(int i=0;i<lstSize;i++){
			for(int j=i;j<lstSize-1;j++){
				if(list.get(j).compareTo(list.get(j+1))>0){
					String temp=list.get(j+1);
					list.set(j+1,list.get(j));
					list.set(j,temp);
					// System.out.println(list);
				}
				
			}
		}
		
		//selection sort
		//puts lenght in order
		for(int i=0;i<lstSize;i++){
			int longestWordInd=i;
			for(int j=i+1;j<lstSize;j++){
				if(list.get(longestWordInd).length()<list.get(j).length()){
					longestWordInd=j;
				}
				else if(list.get(longestWordInd).length()==list.get(j).length()){
					if(list.get(longestWordInd).compareTo(list.get(j))>0){
						longestWordInd=j;
					}
				}
			}
			String temp=list.get(i);
			list.set(i,list.get(longestWordInd));
			list.set(longestWordInd,temp);
		}
	}

}