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

/**
 * This interface describes the require behavior of a route network.
 * @version Nov 5, 2014
 */
public interface RouteNetwork
{
	/**
	 * This method initializes a network to be empty. Once it is initialized, routes
	 * can be added.
	 */
	void initializeNetwork();
	
	/**
	 * This method initializes a network and then populates it with the routes
	 * specified in the parameter.
	 * @param routes an array of Route objects.
	 */
	void initializeNetwork(Route ... routes);
	
	/**
	 * Add a Route to the network.
	 * @param route the route to add
	 * @throws RouteException if the network has not been initialized or if the
	 * 	route already exists in the network
	 */
	void addRoute(Route route) throws RouteException;
	
	/**
	 * Given a source and a destination, determine if there is a route from the source
	 * to the destination in the network.
	 * @param source the starting node
	 * @param destination the end node
	 * @return true if there is a path from the source to the destination in the network
	 * @throws RouteException if the network has not been initialized
	 */
	boolean isPathFrom(String source, String destination) throws RouteException;
	
	/**
	 * <p>
	 * Given a source and destination, find the shortest path from the source to the 
	 * destination and return the path as a series of Route objects in order. For
	 * example, if the source is A and the destination is C, and there is a route
	 * from A to B and one from B to C, then this will return the array of routes:
	 * <br>
	 * [{A, B}, {B, C}].
	 * </p><p>
	 * If there are multiple shortest paths, just return one of them.
	 * </p>
	 * @param source
	 * @param destination
	 * @return the array of routes that go from the source to the destination
	 * @throws RouteException if the network has not been initialized or if there is 
	 * 	no path from the source to the destination
	 */
	Route[] getShortestPath(String source, String destination) throws RouteException;
}
