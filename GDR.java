import java.util.*;
import java.io.*;

/**
 * Entry point for animation viewer
 */
public class GDR {
    public static void main (String[] args) {
        Controller controller = new Controller(); //initialize controller
        if (args.length > 0) {
            controller.LoadGraph(args[0]);
        }
    }
}