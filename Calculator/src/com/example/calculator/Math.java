//this class is handling my calculations

package com.example.calculator;

public class Math 
{
	// set as string because we need to display on screen
	public String operation(String input1, String operator, String input2) 
	{
		if (operator.equals("+")) //if the operator is "+" return it input1
		{
			return add(input1, input2);
		} // end if

		if (operator.equals("-")) 
		{
			return subtract(input1, input2);
		} // end if

		if (operator.equals("*")) 
		{
			return multiply(input1, input2);
		} // end if

		if (operator.equals("/")) 
		{
			return divide(input1, input2);
		} // end if

		return "null";// if error is made return "Null"
	}// end public

	
	
	// Separate functions within the business class "Math"
	//encapsulated functions
	private String add(String input1, String input2) 
	{

		// the "parse" converting both inputs to doubles in order to do math with inputs
		// returning the results as a single string
		// must return as String so it will display
		return String.valueOf((Double.parseDouble(input1) + (Double
				.parseDouble(input2))));
	}//end private
	
	////////////////////////////////
	public String posNeg(String input1)	
	{
		return String.valueOf((-1*Double.parseDouble(input1)));
	}//end public
	
	
//private String posNeg(String input2)/////////WRONG!!!!
//	
//	
//	{
//		return String.valueOf((-1*Double.parseDouble(input2)));/////WRONG!!!!
//	}
	
	///////////////////////////////

	private String subtract(String input1, String input2)
	{
		return String.valueOf((Double.parseDouble(input1) - (Double
				.parseDouble(input2))));
	}//end if

	private String multiply(String input1, String input2)
	{
		return String.valueOf((Double.parseDouble(input1) * (Double
				.parseDouble(input2))));
	}//end if

	
	// want our screen to display "NAN" if dividing by zero
	private String divide(String input1, String input2) 
	{
		if (Double.parseDouble(input1) == 0
				|| (Double.parseDouble(input2) == 0)) 
		{
			return "NAN";
		}//end if

		return String.valueOf((Double.parseDouble(input1) / (Double
				.parseDouble(input2))));
	}//end

}//end public class Math
