import java.util.*;
import java.io.*;

/**
 * Class for reading and parsing a graph either from stdin or a file
 */
public class Reader {
    private Graph graph;
    private FileInputStream fstream;
    private DataInputStream in;
    private BufferedReader br;

    public Reader () {
        graph = new Graph();
    }
    
    /**
     * Parse a single line
     */
    public void parseLine(String line) {
        String[] fields = line.split(" ");
        if (fields[0].equals("g")) { //information on the graph size
            graph.setSize(Integer.parseInt(fields[1]), Integer.parseInt(fields[2]));
        } else if (fields[0].equals("n")) { //node
            graph.addNode(new Node(fields[1], fields[2], fields[3]));
        } else if (fields[0].equals("e")) { //edge
            graph.addEdge(fields[1], fields[2]);
        }
    }

    /**
     * Read a graph from a file
     */
    public Graph ReadFile(String filename) {
        String line;
        try {
            fstream = new FileInputStream(filename);
            in = new DataInputStream(fstream);
            br = new BufferedReader(new InputStreamReader(in));

            while ((line = br.readLine()) != null) {
                parseLine(line);
            }

            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return graph;
    }

    /**
     * Read a graph from stdin
     */
    public Graph ReadStdin() {
        String line;
        br = new BufferedReader(new InputStreamReader(System.in));
        try {
            while ((line = br.readLine()) != null) {
                parseLine(line);
                if (graph.isFull())
                    return graph;
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return graph;
    }

    /**
     * @return the most recently read graph
     */
    public Graph getGraph() { return graph; }
}