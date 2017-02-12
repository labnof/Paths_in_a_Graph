
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author babatundeanafi
 *Master’s degree programme in Computer Science 2017:
 *Preliminary assignment – Paths in a Graph
 *Main Class
 */
public class InfPathDetector {

	/**
	 * @param args
	 */
	
	 private static Graph G;    //Graph to test
	 private static int v;      // Node to search from
	 private static Scanner scInt; //Scanner to scan int input 
	 private static Scanner scString; //Scanner to scan String input 
	 private static List <Node> listOfNodes;
	 private static SpaceComplexity spC;
	
	 
 
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		long lStartTime = System.nanoTime();// indicates(holds) the Start Time of Program
		listOfNodes = MakeListOfNodes();
		G = new Graph(listOfNodes);
		spC = new SpaceComplexity();
		char ans;
		
	
		//v = getInnitialNodeName( );
		
		
		
		
		
		
		
		
		
		
		int number_of_nodes = listOfNodes.size();
		int number_of_arcs = getNumberOfArcs(G);
		
		int max_num_of_out_arcs  = getMaxNumberOfOutArcs(G);
		int min_num_of_out_arcs  = getMinNumberOfOutArcs(G);
		
		int max_num_of_in_arcs  = getMaxNumberOfInArcs(G);
		int min_num_of_in_arcs  = getMinNumberOfInArcs(G);
		
		float av_num_of_out_arcs  = getAveNumberOfOutArcs(G);
		float av_num_of_in_arcs   = getAveNumberOfInArcs(G);
		
		
		//long fStartTime = System.nanoTime();
		
		
    do {
    	    long fStartTime = System.nanoTime();
			v = getInnitialNodeName( );
            String InfPathResult = InfPath(G,v);
            System.out.println(InfPathResult);
            long fEndTime = System.nanoTime(); // indicates(holds) the End Time of Algorithm (Method)
            long foutput = fEndTime - fStartTime; //time elapsed
            

            System.out.println("**********Results********");
            
            System.out.println("Number of nodes: "+number_of_nodes);
    		System.out.println("Number of arcs: "+number_of_arcs +"\n");
    		System.out.println("Maximum number of out going of arcs: "+max_num_of_out_arcs);
    		System.out.println("Minimum number of out going arcs: "+min_num_of_out_arcs+"\n");
    		System.out.println("Maximum number of in coming arcs: "+max_num_of_in_arcs);
    		System.out.println("Minimum number of in coming arcs: "+min_num_of_in_arcs+"\n");
    		System.out.printf("Average number of out going arcs: "+"%.2f"+"\n",av_num_of_out_arcs);
    		System.out.printf("Average number of in coming arcs: "+"%.2f"+"\n",av_num_of_in_arcs);
   
    		System.out.println("Graph was created and examined in: " + foutput / 1000000 + " milliseconds");
    		//end
            long lEndTime = System.nanoTime(); // indicates(holds) the End Time of Program
            //time elapsed
            long output = lEndTime - lStartTime;
            System.out.println("Total time elapsed in milliseconds (Time Complexity): " + output / 1000000 + "\n");
            System.out.println("Approximate memory used by graph (Space Complexity): " + spC.GraphSpaceComplexity(G) +" bytes" + "\n \n");
    		
            
            
            
            
            
            
            
            
            
            
            
            System.out.println("please press y and Enter key to check from another Node or any other key to end program");
            ans = scString.next(".").charAt(0);
        } while (ans == 'y');
		
		
		
		
	

	}
	
	
	// Method to detect Infinite Path in Graph
	
	   public static String InfPath(Graph graph, int nodeName){
		
		Graph g = graph;
		int givenNodeName  =  nodeName;;
		int initialNodeName =  givenNodeName;
		int curretNodeName;
		spC = new SpaceComplexity();
		int totalSpC; //use to keep the Approximate Total Space Complexity(for each variable and return statement)
		String i = " is an is isolated Node";
		String d = "Infinite Path Detected from ";
		String notd = "No Cycle Dectected from ";
		String a = "Approximate Total Space Complexity:  ";
		String b= " bytes";
		
		
		
		Node initialNode;
		Node curretNode;
	    int [] outAjacentArcs;
		
		List <Node>  stack  = new ArrayList<Node>(); // to hold visited vertices
		
		
				
		
		initialNode = getNodeFromGraph(g, initialNodeName);
		
		while (initialNode != null) {
			
		curretNode = initialNode;
		outAjacentArcs = curretNode.getOutAjacentArcs();
		
		
		 if(g.getNodes().size() == 1){
			
			totalSpC= spC.GraphSpaceComplexity(graph)
    				+spC.NodeSpaceComplexity(initialNode)
    				+spC.NodeSpaceComplexity(curretNode)
    				+spC.StringSpaceComplexity(i+1)
    				+spC.StringSpaceComplexity(i)
    				+spC.StringSpaceComplexity(d)
    				+spC.StringSpaceComplexity(notd)
    				+spC.StringSpaceComplexity(a)
    				+spC.StringSpaceComplexity(b)
    				+(SpaceComplexity.INT_FIELD_SIZE*4)
    				+(SpaceComplexity.CHAR_FIELD_SIZE*4
    			    );
			
			
			
			return givenNodeName+ i +"\n"+
         		   a + totalSpC +b;
			
		}
		
		else {
			stack.add(curretNode);
			curretNodeName = getAjcNodeNmaeFromArray(outAjacentArcs);
            curretNode = getNodeFromGraph(g, curretNodeName);
           
            
            if (stack.contains( curretNode)){
            	
            	totalSpC= spC.GraphSpaceComplexity(graph)
        				+spC.ListSpaceComplexity(stack)
        				+spC.IntArraySpaceComplexity( outAjacentArcs)
        				+spC.NodeSpaceComplexity(initialNode)
        				+spC.NodeSpaceComplexity(curretNode)
        				+spC.StringSpaceComplexity(i)
        				+spC.StringSpaceComplexity(d)
        				+spC.StringSpaceComplexity(d+1)
        				+spC.StringSpaceComplexity(notd)
        				+spC.StringSpaceComplexity(a)
        				+spC.StringSpaceComplexity(b)
        				+(SpaceComplexity.INT_FIELD_SIZE*5)
        				+(SpaceComplexity.CHAR_FIELD_SIZE*4
        			    );
            	return d + givenNodeName +"\n"+
            		   a + totalSpC +b
            			;
            }
            
            
            else{
            stack.add(curretNode);
            initialNode = curretNode;
            
            }
		}
		
		
		}
		
		
		totalSpC= spC.GraphSpaceComplexity(graph)
				+spC.StringSpaceComplexity(notd+1)
				+spC.StringSpaceComplexity(i)
				+spC.StringSpaceComplexity(d)
				+spC.StringSpaceComplexity(notd)
				+spC.StringSpaceComplexity(a)
				+spC.StringSpaceComplexity(b)
				+(SpaceComplexity.INT_FIELD_SIZE*4)
				+(SpaceComplexity.CHAR_FIELD_SIZE*4
			    );
		
		
		
		return notd + givenNodeName
				+"\n"+
      		   a + totalSpC +b;
		
		
	}
	   
	   // Method to get the node to start Infinite path detection from
	    public static int getInnitialNodeName( ){
	    	
	    	scString = new Scanner(System.in);
	        String input =" Please Enter an interger 'Node name' you will like to start your check from. e.g 1, cann't be 0 "+"\n";
			System.out.println(input);
			int n;
			n = scString.nextInt();
			
			return n;
	    }
	
	// Method to put the nodes in a List
		public static List <Node> MakeListOfNodes(){
			

	    	scString = new Scanner(System.in);
			
			List <Node> nodes;
			Node n;
			nodes = new ArrayList<Node>();
			String a ="***********************Infinite Path Dectector**********************";
			String c ="Please Enter 'y' to enter another Node or any other key to cancle";
			System.out.println(a);
			char ans; // hold user Answer 
			
			
			do {
				
				n = getnodeFromUser();
		        nodes.add(n);
	            System.out.println(c);
	            ans = scString.next(".").charAt(0);
	           
	            
	        } while (ans == 'y');
			
	    return nodes;
		}
	
		
	
	//Methos to get Nodes from User
	static Node getnodeFromUser(){
		

		scInt = new Scanner(System.in);
	    scString = new Scanner(System.in);
	    
	    int nodeName ;
	    
        
        
	    nodeName = getNodeName();
	    
	    String outAjcNodes ="Please Enter Node's Out Ajacent Nodes, do not include in the current node. e.g 2,3,4, 5 or blank if no out Ajacent Nodes";
		System.out.println(outAjcNodes);
		String StringoutAjcNodes = scString .nextLine();
	    
		String inAjcNodes ="Please Enter Node's in Ajacent Nodes, do not include in the current node. e.g 2,3,4, 5 or blank if no in Ajacent Nodes";
		System.out.println(inAjcNodes);
		String StringinAjcNodes = scString.nextLine();
	    
		
		

	    
	    
	    
	    
		int[] InAjcNodes = Node.StringToAjcNodes(StringinAjcNodes);
		int[] OutAjcNodes = Node.StringToAjcNodes(StringoutAjcNodes);
		
	    //s.close();
	    //scan.close();
		
		return new Node(nodeName,InAjcNodes, OutAjcNodes );
			
	}
	
	//Method to get a Node with a given name from a Graphy
	public static Node getNodeFromGraph(Graph graph, int nodeName) {
		Graph g = graph;
		int n = nodeName;
		
		
		for( Node node :g.getNodes() ){
			
		if(node.getName() == n){
				return node;
			}
		}
		
		return null;
	}
	
	//Method to get Random Ajacent Node of a given Node
	public static int getAjcNodeNmaeFromArray(int[] array) {
		int rn = (int)(Math.random()* array.length);
		int index = rn;
	    return array[index];
	}
	
	public static int getNumberOfArcs(Graph graph){
		
		Graph g = graph;

		if (g.getNodes().size() != 1){

		int numOfArcs = 0;
	    for( Node node :g.getNodes() ){
	    	if (node.getOutAjacentArcs()[0] != 0){
	      numOfArcs += node.getOutAjacentArcs().length;
	    	}
	    }
		
	    return numOfArcs;
	}
	 return 0;
		
	} 
	
    public static int getMinNumberOfOutArcs(Graph graph){
		
		Graph g = graph;
		
		 if (g.getNodes().size() != 1){

		int MinNumberOfOutArcs = g.getNodes().get(0).getOutAjacentArcs().length;
	    for( Node node :g.getNodes() ){
	    	
	      if (MinNumberOfOutArcs > node.getOutAjacentArcs().length)
	    	  MinNumberOfOutArcs = node.getOutAjacentArcs().length;
	    	}
		
	    return MinNumberOfOutArcs;}
		 return 0;
		
    }
    
    public static int getMaxNumberOfOutArcs(Graph graph){
		
		Graph g = graph;
		
		 if (g.getNodes().size() != 1){

		int MaxNumberOfOutArcs = g.getNodes().get(0).getOutAjacentArcs().length;
	    for( Node node :g.getNodes() ){
	    	
	      if (MaxNumberOfOutArcs < node.getOutAjacentArcs().length)
	    	  MaxNumberOfOutArcs = node.getOutAjacentArcs().length;
	    	}
		
	    return MaxNumberOfOutArcs;}
		 return 0;
		
    }
    
 public static int getMinNumberOfInArcs(Graph graph){
		
		Graph g = graph;
		
		 if (g.getNodes().size() != 1){

		int MinNumberOfInArcs = g.getNodes().get(0).getInAjacentArcs().length;
	    for( Node node :g.getNodes() ){
	    	
	      if (MinNumberOfInArcs >= node.getInAjacentArcs().length)
	    	  MinNumberOfInArcs = node.getInAjacentArcs().length;
	    	}
		
	    return MinNumberOfInArcs;}
		 
		 return 0;
		
    }
    
    public static int getMaxNumberOfInArcs(Graph graph){
		
		Graph g = graph;
		
		 if (g.getNodes().size() != 1){

		int MinNumberOfInArcs = g.getNodes().get(0).getInAjacentArcs().length;
	    for( Node node :g.getNodes() ){
	    	
	      if (MinNumberOfInArcs <= node.getInAjacentArcs().length)
	    	  MinNumberOfInArcs = node.getInAjacentArcs().length;
	    	}
		
	    return MinNumberOfInArcs;}
	    
	    return 0;
		
    }
    
     public static float getAveNumberOfInArcs(Graph graph){
		
    	 Graph g = graph;
    	 float NumberOfInArcs = 0;
    	 
    	 if (g.getNodes().size() != 1){
   
 	    for( Node node :g.getNodes() ){
 	    	if (node.getInAjacentArcs()[0] != 0){
 	    	NumberOfInArcs += node.getInAjacentArcs().length;
 	    	}	  
  }
    	 return NumberOfInArcs/g.getNodes().size();
    	 }
    	 return 0;
    }
     
     public static float  getAveNumberOfOutArcs(Graph graph){
 		
    	 Graph g = graph;

  		float NumOfOutArcs = 0;
  		
  		if (g.getNodes().size() != 1){
  		
  		
  	    for( Node node :g.getNodes() ){
  	    	if (node.getOutAjacentArcs()[0] != 0){
  	    	NumOfOutArcs += node.getOutAjacentArcs().length;
  	    	}
  	    	
  	    }
  	  return NumOfOutArcs/g.getNodes().size() ;
  	}
  		return 0;
     }
     
   
 
     
     
public static int  getNodeName(){
    	 
    	 int nodeName = 0;
		 String inputNode =" Please Enter integer to represent the Node. e.g 1 cann't be 0  "+"\n";
		 System.out.println(inputNode);
		 scInt = new Scanner(System.in);
		 // scInt.hasNextInt();
    	 
    	 while (!scInt.hasNextInt()){  
  	 		 System.out.println(inputNode);
  	 		scInt.next();//Go to next
  	 		 }
    	nodeName = scInt.nextInt();
       return nodeName;
       

 		
 	   }
 		


 }
		
 
 
 

     
 		
     
     
     
     
