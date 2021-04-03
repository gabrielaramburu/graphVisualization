package examples;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class TestFirstGraph {
	
	public static void main(String[] args) {
		//System.setProperty("org.graphstream.ui", "swing"); 
		System.setProperty("org.graphstream.ui", "javafx"); 
		
		Graph graph = new SingleGraph("Tutorial 1");
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		graph.addEdge("AB", "A", "B");
		graph.addEdge("AC", "A", "C");
		graph.addEdge("BC", "B", "C");
		graph.display();
		
	}	
	
	
}
