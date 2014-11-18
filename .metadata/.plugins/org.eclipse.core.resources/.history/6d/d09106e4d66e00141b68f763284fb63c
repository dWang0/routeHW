/*******************************************************************************
 * Copyright (c) 2014 Gary F. Pollice
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Used in CS3733, Software Engineering at Worcester Polytechnic Institute
 *******************************************************************************/

package routes;

import java.util.ArrayList;

/**
 * This is the concrete implementation of the route network.
 * @version Nov 7, 2014
 */
public class RouteNetworkImpl implements RouteNetwork
{
	private ArrayList<Route> network;
	private ArrayList<Node> nodes;
	
	/**
	 * Default, and only constructor.
	 */
	//constructor
	public RouteNetworkImpl()
	{
	}
	
	/**
	 * @see RouteNetwork.initializeNetwork()
	 */
	//initializes network
	@Override
	public void initializeNetwork()
	{
		network = new ArrayList<Route>();
	}

	/**
	 * @see RouteNetwork.initializeNetwork(Route... routes)
	 */
	//initializes network with routes
	@Override
	public void initializeNetwork(Route... routes)
	{
		this.network = new ArrayList<Route>();
		for (Route r: routes) {
			network.add(r);
		}
	}

	/**
	 * @see RouteNetwork.addRoute(Route route)
	 */
	//this method adds a route to the network
	@Override
	public void addRoute(Route route) throws RouteException
	{
		if (network == null){
			//then the network has not been initialized yet
			throw new RouteException("Bro, what're you doing? Network hasn't been initiated yet.");
		}
		else {
			network.add(route);
		}
	}

	//this checks to see if there is a path between a source and a destination
	@Override
	public boolean isPathFrom(String source, String destination) throws RouteException
	{
		if (this.network == null)
			throw new RouteException("Can't check path if network hasn't been initiated, bro");
		else {
			for (Route r : network){
				if (r.getSource().equals(source)) {
					return recursivePathCheck(r,destination);
				}
			}
		}
		return false;
	}
	
	public boolean recursivePathCheck(Route route, String destination){
		if (route.getDestination().equals(destination)){
			return true;
		}
		for (Route r : network){
			if (r.getSource().equals(route.getDestination())) {
				return recursivePathCheck(r,destination);
			}
		}
		return false;
	}

	@Override
	public Route[] getShortestPath(String source, String destination)
			throws RouteException
	{	
		if(!isPathFrom(source, destination)){
			throw new RouteException("A path does not exist between the source and destination");
		}
		
		Route[] shortestRoute;
		nodes = new ArrayList<Node>();
		
		//generate list of nodes from input routes
		for (Route r : network){
			nodes.add(new Node(r));
		}
		
		//generate shortest path connections between nodes
		for (Node n : nodes){
			//from each potential starting location
			if(n.getMyRoute().getSource() == source){
				n.setStep(0);
				//generate shortest path connections to other nodes
				generateConnections(n, source);
			}
		}
		
		//find shortest path to destination
		Node tempShortestGoalNode = new Node(null); //used as a temp variable to compare to possible goal nodes
		//for each node
		for (Node n : nodes){
			//if node goes to destination
			if(n.getMyRoute().getDestination() == destination){
				//if node does not have a parent it is either a direct route or cannot be traced back to a source
				if(n.getParent() == null){
					//if it is not a direct rout
					if(n.getMyRoute().getSource() != source){
						//then it cannot be traced back to a source
						continue;
					}
					else{	//then direct route and best choice
						tempShortestGoalNode = n;
						break;
					}
				}
				//at this point we know that this node can be traced back to a source node
				//find node with smallest step count -> shortest route
				if(tempShortestGoalNode.getStep() == null){	//if first potential node
					tempShortestGoalNode = n;
				}
				else{	//compare to tempShortestNode and set to shortestDestination
					if(n.getStep() < tempShortestGoalNode.getStep()){
						tempShortestGoalNode = n;
					}
				}
			}
		}
		
		//now we have the optimal destination node
		//trace goal node back to source node		
		shortestRoute = new Route[1 + tempShortestGoalNode.getStep()];
		recursiveGetRoute(tempShortestGoalNode,shortestRoute);
		return shortestRoute;
				
	}
	
	public void generateConnections(Node node, String source){
		//for each node in the list of nodes
		for(Node n : nodes){
			//if the node's source is the same as my current destination
			if (n.getMyRoute().getSource() == node.getMyRoute().getDestination()){
				//then set node's parent to current node if current route is shorter
				if(n.getParent() == null){	//if the node does not have a parent yet
					if(n.getMyRoute().getSource() == source){
						return;
					}
					else{
						n.setParent(node);		//set parent to current node
						//set node's step count to 1 + the current node's step count
						if(node.getStep() == null){	
							n.setStep(1);
						}
						else{
							n.setStep(1 + node.getStep());
						}
						//n.setAlreadyVisited(true);
						generateConnections(n,source);
					}
				}
				//if the node already has a parent
				else{
					//if node's route is longer than current node's route
					//then update node's parent and step count
					if(n.getStep() > (1 + node.getStep())){
						n.setParent(node);
						n.setStep(1 + node.getStep());
						generateConnections(n,source);
					}
				}
			}
		}
	}
	
	public void recursiveGetRoute(Node node, Route[] route){
		if(node.getParent() == null){
			route[0] = node.getMyRoute();
		}
		else{
			route[node.getStep()] = node.getMyRoute();
			recursiveGetRoute(node.getParent(),route);
		}
	}
}
