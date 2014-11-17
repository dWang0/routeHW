package routes;

public class Node {
	private Integer step;
	private Route myRoute;
	private Node parent;
//	private boolean alreadyVisited;
	
	public Node(Route route){
		myRoute = route;
	//	setAlreadyVisited(false);
	}
	
	public Integer getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public Route getMyRoute() {
		return myRoute;
	}
	public void setMyRoute(Route myRoute) {
		this.myRoute = myRoute;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
/**
	public boolean isAlreadyVisited() {
		return alreadyVisited;
	}

	public void setAlreadyVisited(boolean alreadyVisited) {
		this.alreadyVisited = alreadyVisited;
	}
**/	
	
}