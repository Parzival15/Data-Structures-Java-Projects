import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class Clear {

  static Random rm;
  public static void main(String[] args) throws IOException {
    rm = new Random();
    int pics = 17;
    File[] file = new File[pics];
    String prefix = "";
    for (int p = 1; p <= pics; ++p) {
      String suff = String.valueOf(p);
      String filename = prefix + "birds" + suff + ".ppm";
      file[p-1] = new File(filename);
    }

    long start = System.currentTimeMillis();

  
    Scanner[] scan = new Scanner[pics];

    int rows = 0, cols = 0, mx = 0;
    for (int i = 0; i < pics; ++i) {
      try {
        scan[i] = new Scanner(file[i]);
        String line = scan[i].nextLine();
        cols = Integer.parseInt(scan[i].next());
        rows = Integer.parseInt(scan[i].next());
        mx = Integer.parseInt(scan[i].next());
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }

    

    BufferedWriter output = new BufferedWriter(new FileWriter("blurred1.ppm"));
    output.write(String.format("%s\n", "P3"));
    output.write(String.format("%d  %d\n", cols, rows));
    output.write(String.format("%d\n", mx));
    System.out.println(rows + ", " + cols + ", " + mx);

    
    
    int[] words = new int[pics];
    int avg;

    for (int i = 0; i < cols; ++i) {
      for (int j = 0; j < rows; ++j) {
        for (int c = 0; c < 3; ++c) {
          for (int k = 0; k < pics; ++k){
            avg = Integer.parseInt(scan[k].next());
            words[k] = avg;
            
            
          }
          
         output.write(String.format("%d ", select(words, 0, words.length-1, words.length-1)));
        }
      }
      output.write(String.format("/n"));
    }

    for (int i = 0; i < pics; ++i) {
      scan[i].close();
    }
    output.close();
  }

static int select(int[] A, int i, int j, int q) { // select qth smallest
    if (i == j)
      return A[i];
    int pivotindex = i + rm.nextInt(j - i + 1); // Pick a random pivot
    swap(A, pivotindex, j); // Stick pivot at end

    // k will be the first position in the right subarray
    int k = partition(A, i - 1, j, A[j]);
    swap(A, k, j); // Put pivot in place

    int sz = k - i;
    if (q == sz + 1)
      return A[k];
    else if (q <= sz)
      return select(A, i, k - 1, q);
    else 
      return select(A, k+1, j, q - sz-1);
  }

  static int partition(int[] A, int l, int r, int pivot) {
    do { // Move bounds inward until they meet
      while (A[++l] < pivot)
        ;
      while ((r != 0) && (A[--r] >= pivot))
        ;
      swap(A, l, r); // Swap out-of-place values
    } while (l < r); // Stop when they cross
    swap(A, l, r); // Reverse last, wasted swap
    return l; // Return first position in right partition
  }

  private static void swap(int[] A, int i, int j) {
    int temp = A[j];
    A[j] = A[i];
    A[i] = temp;
  }
}
