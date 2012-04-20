import java.util.*;
import java.io.*;

public class GDR {
    public static void main (String[] args) {
        Controller controller = new Controller();
        if (args.length > 0) {
            controller.LoadGraph(args[0]);
        }
    }
}