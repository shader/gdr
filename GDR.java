import java.util.*;
import java.io.*;

public class GDR {
    public static void parseLine(Graph graph, String line) {
        String[] fields = line.split(" ");
        if (fields[0].equals("g")) {
            graph.setSize(Integer.parseInt(fields[1]), Integer.parseInt(fields[2]));
        } else if (fields[0].equals("n")) {
            graph.addNode(new Node(fields[1], fields[2], fields[3]));
        } else if (fields[0].equals("e")) {
            graph.addEdge(fields[1], fields[2]);
        }
    }

    public static void main (String[] args) {
        Graph graph = new Graph();
        FileInputStream fstream;
        DataInputStream in;
        BufferedReader br;
        String line;

        //read file
        if (args.length > 0) {
            try {
                fstream = new FileInputStream(args[0]);
                in = new DataInputStream(fstream);
                br = new BufferedReader(new InputStreamReader(in));

                while ((line = br.readLine()) != null) {
                    parseLine(graph, line);
                }

                in.close();
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        } else { //take command line args
            br = new BufferedReader(new InputStreamReader(System.in));
            try {
                while ((line = br.readLine()) != null) {
                    parseLine(graph,line);
                    if (graph.isFull()) break;
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        graph.printAdjacencies();
    }
}