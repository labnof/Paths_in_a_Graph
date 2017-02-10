		
		
/**
 * 
 */

/**
 * @author babatundeanafi
 *
 */
public class Node {
	
	 private int name;
	 private int [] InAjacentArcs;
	 private int [] OutAjacentArcs;



 
		
		
		public Node(int n, int [] inajc,  int [] outajc ) {
			// TODO Auto-generated constructor stub
			this.name = n;
			this.InAjacentArcs = inajc;
			this.OutAjacentArcs = outajc;
		}
		
		
		
		public int getName() {
			return name;
		}
		
		
		
		public void setName(int name) {
			this.name = name;
		}
		
		public int []  getOutAjacentArcs( ){
				return  OutAjacentArcs;
		}
		
		public void setOutAjacentArcs(int[] out_ajcN) {
			InAjacentArcs = out_ajcN;
		}  
		
		
		
		public int [] getInAjacentArcs( ){
			return  InAjacentArcs;
	    }
	
	    public void setInAjacentArcs(int[] in_ajcN) {
		InAjacentArcs = in_ajcN;
	    }  
		
		//get the Nodes from the user and returns a array of Nodes
		
		public static int []  StringToAjcNodes( String ajcNodesString){
				
				
				String ajacentNodes = ajcNodesString;
				int[] ArrayOfajacentNodes  = stringToArray(ajacentNodes);
				
				return ArrayOfajacentNodes;
		}
			
			// convert String to array
		public static int[] stringToArray(String a ){
		
				String arr = a;
				String[] items = arr.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("\\s", "").split(",");
		
				int[] results = new int[items.length];
		
				for (int i = 0; i < items.length; i++) {
				    try {
				        results[i] = Integer.parseInt(items[i]);
				    } catch (NumberFormatException nfe) {
				        //NOTE: write something here if you need to recover from formatting errors
				    }
				}
				    return results;
		
} 
		
		
		
		
		
		
		
		
		
		}