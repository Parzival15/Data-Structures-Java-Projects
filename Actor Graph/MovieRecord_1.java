import java.util.*;

public class MovieRecord_1 {
    public String name;
    ArrayList<Integer> actors;

    public MovieRecord_1(String n) {
        name = n;
        actors = new ArrayList<Integer>();
    }

    /* Add a movie to the list for this actor. */
    public void addActor(Integer m) {
        actors.add(m);
    }

    public String toString() {
        String s = name + ": ";
        for (Integer m : actors)
            s += m + "; ";
        return s;
    }
}
