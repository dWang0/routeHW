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

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test cases for the Route Network problem.
 * @version Nov 7, 2014
 */
public class SampleRouteNetworkTest
{

	@Test(expected=RouteException.class)
	public void test() throws RouteException
	{
		new RouteNetworkImpl().addRoute(new Route("A", "B"));
	}
	
	@Test
	public void addRouteToNetwork() throws RouteException
	{
		RouteNetwork network = new RouteNetworkImpl();
		network.initializeNetwork();
		network.addRoute(new Route("A", "B"));
		assertTrue(network.isPathFrom("A", "B"));
	}

	@Test
	public void initializeRoutes() throws RouteException
	{
		RouteNetwork network = new RouteNetworkImpl();
		network.initializeNetwork( new Route[] {
				new Route("A", "B"),
				new Route("B", "C"),
				new Route("X", "Y")
			}
		);
		assertTrue(network.isPathFrom("A", "B"));
	}
	
	@Test
	public void shortRouteTest() throws RouteException
	{
		RouteNetwork network = new RouteNetworkImpl();
		network.initializeNetwork( new Route[] {
				new Route("A", "B"),
				new Route("B", "C"),
				new Route("X", "Y"),
				new Route("C", "D"),
				new Route("A", "D")
			}
		);
		Route[] temp = new Route[1];
		temp[0] = new Route ("A","D");
		assertArrayEquals(temp, network.getShortestPath("A", "D"));
	}
	

	@Test
	public void shortRouteTest2() throws RouteException
	{
		RouteNetwork network = new RouteNetworkImpl();
		network.initializeNetwork( new Route[] {
				new Route("A", "B"),
				new Route("B", "C"),
				new Route("C", "D"),
				new Route("D", "E"),
				new Route("E", "F"),
				new Route("A", "C"),
				new Route("C", "E"),
			}
		);
		Route[] expected = new Route[3];
		expected[0] = new Route ("A","C");
		expected[1] = new Route ("C","E");
		expected[2] = new Route ("E","F");
		
		System.out.println(network.getShortestPath("A", "F"));
		assertArrayEquals(expected, network.getShortestPath("A", "F"));
		
	}

	@Test
	public void shortRouteTest3() throws RouteException
	{
		RouteNetwork network = new RouteNetworkImpl();
		network.initializeNetwork( new Route[] {
				new Route("A", "B"),
				new Route("B", "C"),
				new Route("C", "D"),
				new Route("D", "E"),
				new Route("E", "F"),
				new Route("A", "C"),
				new Route("C", "E"),
				new Route("F", "A")
			}
		);
		Route[] expected = new Route[3];
		expected[0] = new Route ("A","C");
		expected[1] = new Route ("C","E");
		expected[2] = new Route ("E","F");
		
		assertArrayEquals(expected, network.getShortestPath("A", "F"));
		
	}
}