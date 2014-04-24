package edu.jhu.cs.ugrad.kwong23;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Driver {
	private static Graph<String, String> graph =
	        new SparseGraph<String, String>();

	    // Vertices for the actor we're trying to connect to Kevin
	    // Bacon and for Kevin Bacon himself.
	    private static Vertex<String> actor = null;
	    private static Vertex<String> bacon = null;
	private static Map<String, Vertex<String>> vertices = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// keep track of all vertices created so far by name
        
        
        String who = "Schwarzenegger, Arnold";
        String line = "River Wild, The (1994)/Bacon, Kevin/Lucking, William";
        addLine(line, who);
        line = "Rundown, The (2003)/Lucking, William/Schwarzenegger, Arnold";    
        addLine(line, who); 
        System.out.println(graph.toString());
        System.out.println("Done");
//        removeLine(line);
//        System.out.println(graph.toString());
        
        
	}
	public static void removeLine(String line){
		String[] data = line.split("/");

        // find vertex for the movie
        Vertex<String> m = vertices.get(data[0]);
        if(m != null){ //we can remove edges
        	for (int i = 1; i < data.length; i++) {
        		// find vertex for the actor
        		Vertex<String> a = vertices.get(data[i]);
        		if (a != null) {
       
        			// remove two edges, from and to the movie
            		graph.remove(m);
            		graph.remove(a);
            		
        		}

        		
        	}
        }
	}
	public static void addLine(String line, String who){
		String[] data = line.split("/");

        // find or create vertex for the movie
        Vertex<String> m = vertices.get(data[0]);
        if (m == null) {
            m = graph.insert(data[0]);
            vertices.put(data[0], m);
        }

        for (int i = 1; i < data.length; i++) {
            // find or create vertex for the actor
            Vertex<String> a = vertices.get(data[i]);
            if (a == null) {
                a = graph.insert(data[i]);
                vertices.put(data[i], a);
            }

            // double-check for special actors
            if (a.get().equals("Bacon, Kevin")) {
                bacon = a;
            }
            if (a.get().equals(who)) {
                actor = a;
            }

            // create two edges, from and to the movie
            graph.insert(m, a, "features");
            graph.insert(a, m, "acts in");
        }
	}
}
