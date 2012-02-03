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

        Animator anim = new Animator();
        TestAnim test = new TestAnim(anim, reader.getGraph());
        anim.animate();
    }
}