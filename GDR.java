import java.util.*;
import java.io.*;

public class GDR {
    public static void main (String[] args) {
        Reader reader = new Reader();
        //read file
        if (args.length > 0) {
            reader.ReadFile(args[0]);
        } else {
            reader.ReadStdin();
        }

        View view = new View();
        TestAnim test = new TestAnim(view.getAnimator(), reader.getGraph());
    }
}