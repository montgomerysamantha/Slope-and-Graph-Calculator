/**
 * Project 3
 * 
 * Program that asks user for two (x,y) coordinates. It will calculate 
 * the equation between the coordinates in slope intercept form. Then
 * it plots these points on a graph. The program will then ask the
 * user if they would like to repeat this process.
 *
 * @author Samantha Montgomery
 * @version 3
 */

import java.util.*;
import java.text.*;

public class Proj3 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		
		char graphContinue = 'y';
		
		do { //start of do while graphContinue is true
			int bound = 0;
			
			while (bound <= 0 || bound > 15) {
				System.out.print("Enter the bound for the grid (1-15): ");
				bound = Integer.parseInt(s.nextLine());
				
				if (bound <= 0 || bound > 15) {
					System.out.println("Error: please enter a bound from 1 to 15.");
				}
			}
			
			//this is getting the x1 coordinate from the user
			double x1 = -1;
			while (x1 < 0 || x1 > bound) { //checks if number entered is less than bound but greater than or equal to 0
				System.out.print("Enter x1: ");
				x1 = Double.parseDouble(s.nextLine());
				
				if (x1 < 0 || x1 > bound) 
				{
					System.out.println("Error: coordinates must be between 0 and " + bound);
				}
			}
			
			
			//this is getting the y1 coordinate from the user
			double y1 = -1;
			while (y1 < 0 || y1 > bound) { //checks if number entered is less than bound but greater than or equal to 0
				System.out.print("Enter y1: ");
				y1 = Double.parseDouble(s.nextLine());
				
				if (y1 < 0 || y1 > bound) 
				{
					System.out.println("Error: coordinates must be between 0 and " + bound);
				}
			}
			
			//this is getting the x2 coordinate from the user
			double x2 = -1;
			while (x2 < 0 || x2 > bound) { //checks if number entered is less than bound but greater than or equal to 0
				System.out.print("Enter x2: ");
				x2 = Double.parseDouble(s.nextLine());
				
				if (x2 < 0 || x2 > bound) 
				{
					System.out.println("Error: coordinates must be between 0 and " + bound);
				}
			}
			
			
			//this is getting the y2 coordinate from the user
			double y2 = -1;
			while (y2 < 0 || y2 > bound) { //checks if number entered is less than bound but greater than or equal to 0
				System.out.print("Enter y2: ");
				y2 = Double.parseDouble(s.nextLine());
				
				if (y2 < 0 || y2 > bound) 
				{
					System.out.println("Error: coordinates must be between 0 and " + bound);
				}
			}
			
			System.out.println(); //new line for cool aesthetic
			
			if (x1 > x2 && y1 == y2) { //this is error handling in case the y coordinates match and the x1 coordinate is bigger than the x2
				double newx2 = x1;
				x1 = x2;
				x2 = newx2;
			} 
			
			
			//this prints out the y-axis of our graph
			for (int i = bound; i >= 0; i--) 
			{
				System.out.print(i);
				if (i < 10) { //if we have less than two digits we need to print out an extra space to match our two digit numbers
					System.out.print(" ");
				}
				
				//special case for the 0, this prints out the line marking the x-axis
				if (i == 0) {
					double dashes = bound * 3; //we want the number of dashes printed to be three times our bound
					dashes += 2;
					System.out.print(" ");
					for (double j = 0; j <= dashes; j++) {
						if ((y1 == 0 && j == (x1*3)) || (y2 == 0 && j == (x2*3))) {
							System.out.print("*");
						} else {
							System.out.print("-");
						}
					}
					System.out.println();
					break;
				}
				
				//this is a special case if x1 is 0 or if x2 is 0, it won't print out the "|" it will print out a "*"
				if ((x1 == 0 && i == y1 && y1 != 0) || (x2 == 0 && i == y2 && y2 != 0)) {
					System.out.print(" *");
				} else {
					System.out.print(" |");
				}
				
				
				//this prints out an asterisk marking where the (x1, y1) coordinate pair is
				if (i == y1 && x1 != 0) { //make sure x1 is not 0
					for (double numberOfSpaces = (x1*3); numberOfSpaces > 0; numberOfSpaces--)
					{
						if (numberOfSpaces > 1) 
							{
							System.out.print(" ");
							} else {
								System.out.print("*");
							}
					}
				}
				
				//this prints out an asterisk marking where the (x2, y2) coordinate pair is
				//make sure x2 is not 0, also checks to make sure the pairs don't match, if they do, we don't want to print out another asterisk
				if (i == y2 && x2 != 0 && (x1 != x2 && y1 != y2)) 
				{
					for (double numberOfSpaces = (x2*3); numberOfSpaces > 0; numberOfSpaces--)
					{
						if (numberOfSpaces > 1) 
							{
							System.out.print(" ");
							} else {
								System.out.print("*");
							}
					}
				} else if (y1 == y2 && x1 != x2 && i == y2 && x2 > x1) { //this is a special case if the pairs share the same y coordinate (x2 is bigger)
					for (double numberOfSpaces = (x2*3)-(x1*3); numberOfSpaces > 0; numberOfSpaces--)
					{
						if (numberOfSpaces > 1) 
						{
						System.out.print(" ");
						} else {
							System.out.print("*");
						}
					}
				} else if (x1 == x2 && y1 != y2 && i == y2) 
				{
					for (double numberOfSpaces = (x2*3); numberOfSpaces > 0; numberOfSpaces--)
					{
						if (numberOfSpaces > 1) 
							{
							System.out.print(" ");
							} else {
								System.out.print("*");
							}
					}	
				}
				System.out.println(); //new line for next row
			}
			
			//this prints out the numbers for the x-axis
			System.out.print("   ");
			for (int k = 0; k <= bound; k++) 
			{
				System.out.print(k + " ");
				if (k < 10) {
					System.out.print(" ");
				}
			}
			System.out.println(); //new line for cool aesthetic
			
			//some math stuff for the equation of the line between the points
			if (x1 != x2 && y1 != y2) 
			{
				double slope = (y2 - y1)/(x2 - x1);
				double yintercept =  y1 - (slope*x1);
				
				System.out.println(); //new line
				
				//print out equation
				System.out.print("y = " + df.format(slope) + "x + " + df.format(yintercept));
				System.out.println(); //new line
			} 
			//user enters point that make a vertical line, slope is undefined
			else if (x1 == x2 && y1 != y2) 
			{
				System.out.println("The slope is undefined because this is a vertical line.");
			} 
			//user enters points that make a horizontal line, slope is zero
			else if (y1 == y2 && x1 != x2) 
			{
				double slope = 0;
				double yintercept =  y1 - (slope*x1);
				
				System.out.println(); //new line
				
				//print out equation
				System.out.print("y = " + df.format(slope) + "x + " + df.format(yintercept));
				System.out.println(); //new line
			}
			//if (x1,y1) and (x2,y2) are the same thing we are going to print out this message
			else if (y1 == y2 && x1 == x2) 
			{
				System.out.println("These coordinates are the same, so there is no equation for a line that connects them.");
			}
			
			System.out.println(" ");
			
			do {
				System.out.println("Do you want to go again (y/n)?");
				graphContinue = (s.nextLine().toLowerCase().charAt(0));
				
				
				if (graphContinue != 'y' && graphContinue != 'n') 
				{
					System.out.println("Error: please enter (y)es or (n)o.");
				}
			} while (graphContinue != 'y' && graphContinue != 'n'); //loop until user enters proper input
			
		} while (graphContinue == 'y'); //main loop for our graphing
		
		//closing the scanner
		s.close();
	}
}
