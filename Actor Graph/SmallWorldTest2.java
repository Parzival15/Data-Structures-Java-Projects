import java.util.*;
import java.io.*;
import java.lang.*;

public class SmallWorldTest2 {

    public static void main(String[] args) throws Exception {

        String fname = "ShortActorRoles.txt";
        BufferedReader in;
        String content;

        in = new BufferedReader(new InputStreamReader(new FileInputStream(fname), "UTF-8"));

        long start = System.nanoTime();

        ArrayList<String> act = new ArrayList<>();

        BST<String, MovieRecord_1> movieBST = new BST<>();

        int count = 0;
        while ((content = in.readLine()) != null) {
            String[] tkn = content.split("\\t");
            for (String movie : Arrays.copyOfRange(tkn, 1, tkn.length)) {
                if (movieBST.find(movie) == null) {
                    MovieRecord_1 record = new MovieRecord_1(movie);
                    record.addActor(count);
                    movieBST.insert(movie, record);
                } else {
                    movieBST.find(movie).addActor(count);
                }
            }
            act.add(tkn[0]);
            count++;
        }

        // long end = System.nanoTime();

        in.close();
        // System.out.println( (end - start)/1000000 + "ms" );

        GraphlWeights g;
        int movieValue = 0;
        g = new GraphlWeights(act.size());
        for (MovieRecord_1 movie : movieBST.values()) {
            movieValue++;
            for (int i : movie.actors) {
                for (int j : movie.actors) {
                    if (i != j && g.isEdge(i, j) == false) {
                        g.setEdge(i, j, movieValue);
                        g.setEdge(j, i, movieValue);
                    }
                }
            }
        }

        Scanner scan = new Scanner(System.in);

        ArrayList<String> key = (ArrayList<String>) movieBST.keys();
        // weight - 1 is the index of the movie
        while (true) {
            System.out.println("Enter source and destination indices:");
            int input1 = scan.nextInt();
            int input2 = scan.nextInt();
            if (input1 <= 0 && input2 <= 0) {
                break;
            } else if (input1 == input2) {
                System.out.println("no chain");
            } else {
                ArrayList<Integer> result = findShortestPath(g, input1, input2);
                if (result != null) {
                    System.out.println("Shortest path between " + act.get(input1) + " and " + act.get(input2));
                    int size = result.size() - 1;
                    System.out.println("Distance: " + size + "; the chain is:");
                    for (int x = 0; x < size; x++) {
                        int ActorOne = result.get(x);
                        int ActorTwo = result.get(x + 1);
                        System.out.println(act.get(ActorOne) + " appeared with " + act.get(ActorTwo) + " in "
                                + key.get(g.weight(ActorOne, ActorTwo) - 1));
                    }
                } else {
                    System.out.println("No connection.");

                    // System.out.println("No path between " + act.get(input1) + " and " +
                    // act.get(input2));
                }
            }
        }
        scan.close();
    }

    private static ArrayList<Integer> findShortestPath(GraphlWeights g, int i, int j) {
        boolean[] visited = new boolean[g.n()];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> path = new ArrayList<>();
        g.setMark(i, -1);
        visited[i] = true;
        queue.add(i);
        while (!queue.isEmpty()) {
            int first = queue.poll();
            ArrayList<int[]> getNeighbor = g.neighbors(first);
            for (int ii = 0; ii < getNeighbor.size(); ii++) {
                int[] temp = getNeighbor.get(ii);
                int tempNumber = temp[0];
                if (!visited[tempNumber]) {
                    visited[tempNumber] = true;
                    g.setMark(tempNumber, first);
                    queue.add(tempNumber);
                    if (tempNumber == j) {
                        while (tempNumber > -1) {
                            path.add(0, tempNumber);
                            tempNumber = g.getMark(tempNumber);
                        }
                        return path;
                    }
                }
            }
            // if while loop is terminated with 0 success, return null
        }
        return null;
    }
}
