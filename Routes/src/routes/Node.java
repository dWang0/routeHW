package routes;

/**
 * This data structure class defines a single node of the Route class and a Node that is connected
 * to this Node
 * 
 * @author rwang3
 * @author dlbourque
 *
 */
public class Node {
	private Integer step;
	private Route myRoute;
	private Node parent;
	
	/**
	 * 
	 * @param route
	 */
	public Node(Route route){
		myRoute = route;
	}
	
	/**
	 * 
	 * @return step
	 */
	public Integer getStep() {
		return step;
	}
	/**
	 * @param step The number of nodes away from a starting node
	 */
	public void setStep(int step) {
		this.step = step;
	}
	/**
	 * 
	 * @return myRoute
	 */
	public Route getMyRoute() {
		return myRoute;
	}
	
	/**
	 * @param myRoute The route of this Node
	 */
	public void setMyRoute(Route myRoute) {
		this.myRoute = myRoute;
	}
	/**
	 * 
	 * @return parent
	 */
	public Node getParent() {
		return parent;
	}
	
	/**
	 * @param parent A node with a step count of 1 less and connected to this Node
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}
}
