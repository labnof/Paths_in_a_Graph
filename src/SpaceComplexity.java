import java.util.List;

/**
 * 
 */

/**
 * @author babatundeanafi
 * This class contain a SpaceComplexity Estimate and may not be very Accurate
 *reference: http://introcs.cs.princeton.edu/java/41analysis/
 */
public class SpaceComplexity {
	
	
	// java.lang.Object shell size in bytes:
    int  INT_HEADER_INFORMATION  = 24;
    int  LIST_HEADER_INFORMATION  = 32;
    int  STRING_HEADER_INFORMATION  = 32;
    public static final int OBJREF_HEADER_INFORMATION = 32;
    public static final int LONG_FIELD_SIZE     = 8;
    public static final int INT_FIELD_SIZE      = 4;
    public static final int SHORT_FIELD_SIZE    = 2;
    public static final int CHAR_FIELD_SIZE     = 2;
    public static final int BYTE_FIELD_SIZE     = 1;
    public static final int BOOLEAN_FIELD_SIZE  = 1;
    public static final int DOUBLE_FIELD_SIZE   = 8;
    public static final int FLOAT_FIELD_SIZE    = 4;
   
    
    
    SpaceComplexity( ){
    	
    }
    
    public int GraphSpaceComplexity(Graph graph){
    	
    	Graph g = graph;
    	int nodesSpaceComplexity= 0;
    	
    	List <Node>  ln =  g.getNodes();
    	
    	for(Node n :ln ){
    		
    		nodesSpaceComplexity+= NodeSpaceComplexity(n);
    	}
  	  
    	
 	   return  nodesSpaceComplexity +
 			  LIST_HEADER_INFORMATION +
 			  OBJREF_HEADER_INFORMATION ;
    	
    }

    public int ListSpaceComplexity(List <Node>  lnodes ){
    	
    
    	
    	List <Node>  ln =  lnodes;
    	int nodesSpaceComplexity= 0;
    	
    	if (ln == null){
    		
    		return INT_HEADER_INFORMATION + INT_HEADER_INFORMATION*2;}
    	
    	
    	for(Node n :ln ){
    		
    		nodesSpaceComplexity+= NodeSpaceComplexity(n);
    	}
  	  
    	
 	   return  nodesSpaceComplexity +
 			  LIST_HEADER_INFORMATION;
    	}
    	
    	
    	
    
    
    
    public int NodeSpaceComplexity(Node n){
    	
    	Node node = n;
    	
    	if ((node.getInAjacentArcs() == null) && node.getOutAjacentArcs() == null){
    		
    		return INT_FIELD_SIZE + INT_HEADER_INFORMATION*2;
    	}
    	
    			return IntArraySpaceComplexity(node.getInAjacentArcs())
    	    			+IntArraySpaceComplexity(node.getOutAjacentArcs())
    	    			+OBJREF_HEADER_INFORMATION ;
    			// in case of isolated node
    	
    	
    	
    }

    
    public int StringSpaceComplexity(String string){
    	
    	String s = string;
    	
    	return (CHAR_FIELD_SIZE*s.length()) + STRING_HEADER_INFORMATION;
    	
    	
    }

    
    public int IntArraySpaceComplexity(int[] array){
    	
    	int[] a = array;
    	
    	if (a.length == 0 || a == null ){
    	
    	return  INT_HEADER_INFORMATION;
    	
    	}
    	
    	return (INT_FIELD_SIZE * a.length) + INT_HEADER_INFORMATION;
    }
    
   

}
