import java.util.LinkedList;

public class DirectedListGraph {
	private LinkedList<Integer>[] nodes;

	public DirectedListGraph(int numNodes){
		this.nodes = new LinkedList[numNodes];
	} 

	// check if two nodes are adjacent
	public boolean adjacent(int j, int k) throws Exception{

		if(j>(nodes.length-1)||j<0){
			throw new Exception("Error: Nodes out of range.");
		}
		if(k>(nodes.length-1)||k<0){
			throw new Exception("Error: Nodes out of range.");
		}

		LinkedList<Integer> adjacents = nodes[j];
		if(adjacents==null){return false;}
		return adjacents.contains(k);
	}

	// returns list of nodes y where there is a node from x to y
	public Integer[] neighbours(int j) throws Exception{

		LinkedList<Integer> adjacents = nodes[j];

		if(adjacents==null){return new Integer[0];}

		return ((Integer[])adjacents.toArray());
	}

	// add an edge
	public void add(int j, int k) throws Exception{

		if(j>(nodes.length-1)||j<0){
			throw new Exception("Error: Nodes out of range.");
		}
		if(k>(nodes.length-1)||k<0){
			throw new Exception("Error: Nodes out of range.");
		}

		if(nodes[j]==null){
			nodes[j] = new LinkedList<Integer>();
		}

		if(!nodes[j].contains(k)){
			nodes[j].add(k);
		}
		
	}

	// delete an edge
	public void delete(int j, int k) throws Exception{

		if(j>(nodes.length-1)||j<0){
			throw new Exception("Error: Nodes out of range.");
		}
		if(k>(nodes.length-1)||k<0){
			throw new Exception("Error: Nodes out of range.");
		}

		if(nodes[j]==null){
			throw new Exception("Edge does not exist");
		}

		int nodeToDelete = nodes[j].indexOf(k);
		if(nodeToDelete==-1){
			throw new Exception("Edge does not exist");
		}

		nodes[j].remove(nodeToDelete);
	}

	public void printGraph(){
		for(int i=0;i<nodes.length;i++){
			System.out.print("Node "+i+": ");
			if(nodes[i]!=null){
				for(Integer j : nodes[i]){
					System.out.print(j + " ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args){
		DirectedListGraph g = new DirectedListGraph(5);
		try {
			System.out.println("Adding edge 0, 2");
			g.add(0, 2);
			System.out.println("Adding edge 0, 4");
			g.add(0, 4);
			System.out.println("Deleting edge 0, 4");
			g.delete(0, 4);
			System.out.println("Adding edge 2, 3");
			g.add(2,3);
			System.out.println("Adding edge 1, 4");
			g.add(1,4);
			System.out.println("Adding edge 4, 1");
			g.add(4,1);
			System.out.println("Adding edge 3, 2");
			g.delete(3,2);
		} catch(Exception e){
			System.out.println("error: " + e.getMessage());
		}
		g.printGraph();

	}

}