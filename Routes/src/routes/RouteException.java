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
 * Exception for the Routes homework assignment.
 * @version Nov 7, 2014
 */
public class RouteException extends Exception
{
	/**
	 * The only constructor. There must be a message.
	 * @param message the reason for throwing the exception
	 */
	public RouteException(String message)
	{
		super(message);
	}
}
