
/**
 * @author babatundeanafi
 *Master’s degree programme in Computer Science 2017:
 *Preliminary assignment – Paths in a Graph
 *Graph Class
 */


import java.util.List;

public class Graph {

    //public int numberOfNodes; // num of vertices
     private List <Node> nodes;
   
    
    
    public Graph()
    {
        
    }
    
    public Graph(List <Node> ln)
    {
        this.nodes =  ln ;
       
    }
    
    public List <Node> getNodes() {
		return nodes;
	}

	public void AddNodes(List <Node> nodes) {
		this.nodes = nodes;
	}

	public void AddNodestoList(List <Node> ln, Node n){
		
		this.nodes =  ln ;
		nodes.add(n);
		
	}
	
	
	
	
	
	
}